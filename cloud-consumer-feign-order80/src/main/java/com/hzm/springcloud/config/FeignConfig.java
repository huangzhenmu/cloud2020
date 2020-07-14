package com.hzm.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hzm
 * @version 1.0
 * 配置feign的日志级别
 * NONE：默认的，不显示任何日志
 * BASIC:仅记录请求方法、URL、响应状态码及执行时间
 * HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息
 * FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据
 * @date 2020/7/13 22:14
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feignLoggerLever(){
        return Logger.Level.FULL;
    }
}
