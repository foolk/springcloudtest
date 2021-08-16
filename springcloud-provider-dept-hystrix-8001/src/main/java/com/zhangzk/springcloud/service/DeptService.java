package com.zhangzk.springcloud.service;

import com.zhangzk.springcloud.pojo.Dept;

import java.util.List;

/**
 * @author Intian
 * @create 2021-08-13 13:46
 */
public interface DeptService {
    boolean addDept(Dept dept);

    Dept queryById(Long id);

    List<Dept> queryAll();
}
