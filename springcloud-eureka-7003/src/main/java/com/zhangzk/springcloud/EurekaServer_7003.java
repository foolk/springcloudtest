package com.zhangzk.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author Intian
 * @create 2021-08-13 16:17
 */

//启动之后，访问 http://localhost:7003/
@SpringBootApplication
@EnableEurekaServer //EnableEurekaServer 服务端的启动类，可以接收别人注册进来
public class EurekaServer_7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7003.class,args);
    }
}
