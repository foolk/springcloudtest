package com.zhangzk.springcloud.controller;

import com.zhangzk.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Intian
 * @create 2021-08-13 15:13
 */

@RestController
public class DeptConsumerController {

    // 理解： 消费者，不应该有service层~
    // RestTemplate .... 供我们直接调用就可以了！ 注册到spring中
    //（url,实体：Map，Class<T> responseType）
    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程http服务的方法，简单的Restful服务模板

    //private static final String REST_URL_PRIFIX = "http://localhost:8001";
    //通过Ribbon。我们这里的地址，应该是一个变量，通过服务名来访问
    private static final String REST_URL_PRIFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PRIFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL_PRIFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PRIFIX+"/dept/list",List.class);
    }

}
