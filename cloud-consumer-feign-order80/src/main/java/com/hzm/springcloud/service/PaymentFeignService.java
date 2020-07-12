package com.hzm.springcloud.service;

import com.hzm.springcloud.entity.CommonResult;
import com.hzm.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/12 16:50
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //表明是利用feign调用其他服务的接口
public interface PaymentFeignService {

    @GetMapping(value = "payment/get")//前面定义的服务，再加上这个rest路径，调用该服务的该接口
    public CommonResult<Payment> getPaymentById(Long id);
}
