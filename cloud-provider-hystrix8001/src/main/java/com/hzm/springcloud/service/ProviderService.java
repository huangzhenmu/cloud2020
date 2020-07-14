package com.hzm.springcloud.service;

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

    public String timeout(){
        long timeout = 3;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "端口："+serverPort+"的timeout接口调用成功,耗时（秒）："+timeout;
    }
}
