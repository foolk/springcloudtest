package com.zhangzk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Intian
 * @create 2021-08-13 13:57
 */

//启动类
@SpringBootApplication
@EnableEurekaClient //在服务启动后自动注册到Eureka中！
@EnableDiscoveryClient //服务发现
public class DeptProvider_8003 {
    public static void main(String[] args){
        SpringApplication.run(DeptProvider_8003.class,args);
    }
}
