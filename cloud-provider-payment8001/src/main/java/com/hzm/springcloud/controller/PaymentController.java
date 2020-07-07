package com.hzm.springcloud.controller;

import com.hzm.springcloud.entity.CommonResult;
import com.hzm.springcloud.entity.Payment;
import com.hzm.springcloud.service.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/6 23:45
 */
@RestController
@Slf4j
@RequestMapping("payment")
@Api("支付模块")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @ApiOperation("创建支付订单")
    @PostMapping(value = "create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果：{}",result);
        if (result > 0){
            return new CommonResult(200,"新增成功",result);
        }else {
            return new CommonResult(444,"新增失败");
        }
    }

    @GetMapping(value = "getPaymentById")
    public CommonResult getPaymentById(Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null){
            return new CommonResult(200,"查询成功",payment);
        }else {
            return new CommonResult(444,"查询不到对应数据");
        }
    }
}
