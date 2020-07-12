package com.hzm.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author hzm
 * @version 1.0
 * 手写轮询负载均衡算法 （参考IRule）
 * @date 2020/7/12 15:46
 */
@Component
public class MyLB implements LoadBalancer {
    //访问次数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    //获取访问次数
    public final int getAndIncrement(){
        int current;
        int next;
        //自旋锁
        do{
            current = this.atomicInteger.get();
            //整型的最大值  Integer.MAX_VALUE
            next = current>2147483647 ? 0 : current + 1;
        }while (!this.atomicInteger.compareAndSet(current,next)); //CAS方法
        return next;
    }

    /**
     *
     * @param serviceInstances 服务的实例列表
     * @return
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
