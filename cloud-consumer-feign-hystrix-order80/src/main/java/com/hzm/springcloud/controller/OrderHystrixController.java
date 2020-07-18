package com.hzm.springcloud.controller;

import com.hzm.springcloud.entity.CommonResult;
import com.hzm.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/16 16:18
 */
@RestController
@RequestMapping("consumer")
@Slf4j
@DefaultProperties(defaultFallback = "gloadFallback")//配置全局服务降级方法gloadFallback
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/ok")
    public CommonResult ok(){
        return paymentHystrixService.ok();
    }

    @GetMapping("/timeout")
    @HystrixCommand(fallbackMethod = "timouthandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")//设置超时参数的值为3000ms
    })
    public CommonResult timeout(){
        return paymentHystrixService.timeout();
    }

    public CommonResult timouthandler(){
        String result = "消费者端80的timouthandler接口调用成功,这是fallback方法";
        return new CommonResult(444,"fallback",result);
    }

    public CommonResult gloadFallback(){
        String result = "消费者端80的gloadFallback接口调用成功,这是全局fallback方法";
        return new CommonResult(444,"fallback",result);
    }
}
