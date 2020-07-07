package com.hzm.springcloud.controller;

import com.hzm.springcloud.entity.CommonResult;
import com.hzm.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/7 22:10
 */
@RestController
@Slf4j
@RequestMapping("order")
public class OrderController {
    public static  final String PAYMENT_URL = "http://localhost:8001/payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/create",payment,CommonResult.class);
    }

    @GetMapping("payment/get")
    public CommonResult<Payment> getPayment(Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/get?id="+id,CommonResult.class);
    }
}
