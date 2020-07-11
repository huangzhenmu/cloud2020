package com.hzm.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/7 22:15
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced //赋予resttemplate负载均衡的能力，否则只通过服务名称访问集群的服务是会报错的
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
