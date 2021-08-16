package com.zhangzk.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.zhangzk.myrule.KRandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Intian
 * @create 2021-08-13 14:22
 */

@Configuration
public class ConfigBean { //@Configuration -- spring applicationContext.xml

    //配合负载均衡实现RestTemplate
    //IRule 这是负载均衡的实现
    //RoundRobinRule 轮询
    //KRandomRule 随机
    //AvailabilityFilteringRule : 会先过滤掉，跳闸，访问故障的服务~，对剩下的进行轮询~
    //RetryRule : 会按照轮询获取服务~，如果服务获取失败，则会在指定的时间内进行，重试
    @Bean
    @LoadBalanced //Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule myRule(){
        //随机询问
        //return new RandomRule();

        //使用自己的自定义
        //默认是轮询，现在我们定义为~KRandowRule
        return new KRandomRule();
    }

}
