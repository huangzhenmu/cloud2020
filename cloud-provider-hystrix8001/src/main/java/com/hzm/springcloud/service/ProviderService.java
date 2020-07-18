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

    public String timouthandler(){
        return "端口："+serverPort+"的timouthandler接口调用成功,这是fallback方法";
    }
}
