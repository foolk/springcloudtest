package com.zhangzk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Intian
 * @create 2021-08-13 15:29
 */
//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址
@SpringBootApplication
@EnableEurekaClient

//扫描包 //扫描注解
@EnableFeignClients(basePackages = {"com.zhangzk.springcloud"})
@ComponentScan("com.zhangzk.springcloud")

public class FeignDeptConsumer_80 {
    public static void main(String[] args){
        SpringApplication.run(FeignDeptConsumer_80.class,args);
    }
}
