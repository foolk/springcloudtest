package com.zhangzk.springcloud;

import com.zhangzk.myrule.ZhangZKRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author Intian
 * @create 2021-08-13 15:29
 */
//Ribbon 和 Eureka 整合以后，客户端可以直接调用，不用关心IP地址
@SpringBootApplication
@EnableEurekaClient
//在微服务启动的时候就可以加载我们自定义的ribbon类
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = ZhangZKRule.class)
public class    DeptConsumer_80 {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
