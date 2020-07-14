package com.hzm.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/14 9:37
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ProviderHystrix8001Main {
    public static void main(String[] args) {
        SpringApplication.run(ProviderHystrix8001Main.class,args);
    }
}
