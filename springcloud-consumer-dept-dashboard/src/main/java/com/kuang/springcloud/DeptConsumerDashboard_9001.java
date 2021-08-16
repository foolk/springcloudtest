package com.kuang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author Intian
 * @create 2021-08-14 11:54
 */
@SpringBootApplication
@EnableHystrixDashboard //开启监控
public class DeptConsumerDashboard_9001 {
    public static void main(String[] args){
        SpringApplication.run(DeptConsumerDashboard_9001.class,args);
    }
}
