package com.hzm.springcloud.controller;

import com.hzm.springcloud.entity.CommonResult;
import com.hzm.springcloud.entity.Payment;
import com.hzm.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/12 16:54
 */
@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "payment/get")
    public CommonResult<Payment> getPaymentById(Long id){
        return paymentFeignService.getPaymentById(id);
    }
}
