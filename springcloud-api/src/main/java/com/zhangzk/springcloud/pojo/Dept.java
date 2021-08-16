package com.zhangzk.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Intian
 * @create 2021-08-13 12:52
 */
@Data
@NoArgsConstructor
@Accessors(chain = true) //链式写法
/*
 * 链式写法：
 * Dept dept = new Dept();
 * dept.setDeptno(11).setDname('ssss').setDb_source('001');
 * */
public class Dept implements Serializable { //Dept 实体类 orm 类表关系映射

    private Long deptno;
    private String dname;
    //这个数据存在哪个数据库的字段 ~微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(String dname){
        this.dname = dname;
    }

}
