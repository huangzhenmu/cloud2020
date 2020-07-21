package com.hzm.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/14 9:39
 */
@Service
public class ProviderService {
    @Value("${server.port}")
    private String serverPort;

    public String ok(){
        return "端口："+serverPort+"的ok接口调用成功哈哈哈哈";
    }

    //设定超时值为3秒
    @HystrixCommand(fallbackMethod = "timouthandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String timeout(){
        int i = 10/0;//这里报错也会调用fallback方法
        long timeout = 5;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "端口："+serverPort+"的timeout接口调用成功,耗时（秒）："+timeout;
    }

    //服务降级方法
    public String timouthandler(){
        return "端口："+serverPort+"的timouthandler接口调用成功,这是fallback方法";
    }

    @HystrixCommand(fallbackMethod = "rongduan",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//时间单位内访问数达到此阈值才触发熔断
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间间隔
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60")//单位时间内的接口访问失败率
    })
    public String success(int id){
        return "调用success方法成功。id:"+id;
    }
    //服务熔断方法
    public String rongduan(){
        return "端口："+serverPort+"的rongduan接口调用成功,这是熔断方法";
    }
}
