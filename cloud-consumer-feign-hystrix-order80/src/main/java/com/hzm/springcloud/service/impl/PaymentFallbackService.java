package com.hzm.springcloud.service.impl;

import com.hzm.springcloud.entity.CommonResult;
import com.hzm.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/18 15:33
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public CommonResult ok() {
        String result = "===PaymentFallbackService fall back method:ok";
        return new CommonResult(444,"fallback",result);
    }

    @Override
    public CommonResult timeout() {
        String result = "===PaymentFallbackService fall back method:timeout";
        return new CommonResult(444,"fallback",result);
    }
}
