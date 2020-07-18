package com.hzm.springcloud.service;

import com.hzm.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/16 16:07
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentHystrixService {

    @GetMapping("/payment/ok")
    public CommonResult ok();

    @GetMapping("/payment/timeout")
    public CommonResult timeout();
}
