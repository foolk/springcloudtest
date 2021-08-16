package com.zhangzk.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Intian
 * @create 2021-08-14 0:36
 */


@Configuration
public class ZhangZKRule {

    @Bean
    public IRule myRule(){
//        return new KRandomRule();        //默认是轮询，现在我们定义为~KRandowRule
        return new RandomRule();
    }
}
