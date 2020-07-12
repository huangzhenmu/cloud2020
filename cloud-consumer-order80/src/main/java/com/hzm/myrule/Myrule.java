package com.hzm.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hzm
 * @version 1.0
 * Ribbon官网说明，定义负载均衡算法的配置类不能放在@ConfigurationScan同包
 * 或者子包下，否则不会生效，所以在外部文件夹配置负载均衡算法为随机
 * @date 2020/7/12 14:52
 */
@Configuration
public class Myrule {
    @Bean
    public IRule mySelfRule(){
        return new RandomRule();//随机负债均衡算法
    }
}
