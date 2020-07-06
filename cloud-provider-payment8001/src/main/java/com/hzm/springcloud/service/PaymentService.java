package com.hzm.springcloud.service;

import com.hzm.springcloud.dao.PaymentDao;
import com.hzm.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/6 23:42
 */
@Service
public class PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment){
        return  paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }
}
