package com.zhangzk.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zhangzk.springcloud.pojo.Dept;
import com.zhangzk.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Intian
 * @create 2021-08-13 13:51
 */

//提供Restful服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    //获取一些配置的信息，得到具体的微服务!

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll(){
        return deptService.queryAll();
    }

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = deptService.queryById(id);
        //判断是否从数据库中拿到了该id的对象
        if(dept==null){
            throw new RuntimeException("id=>"+id+",不存在该用户，或者信息无法找到~");
        }
        return dept;
    }



    //备选方法
    public Dept hystrixGet(@PathVariable("id")Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("id=>"+id+",没有对应的信息,null--@Hystrix")
                .setDb_source("this database is not hava you mysql");
    }

}
