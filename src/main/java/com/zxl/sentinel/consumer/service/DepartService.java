package com.zxl.sentinel.consumer.service;


import com.zxl.sentinel.consumer.bean.Depart;

/**
 * @author zxl
 * @date 2021/9/24.
 */
public interface DepartService {

    default Depart getDepartById(Integer id) { return null; }

    default void initFlowRule(Integer count) {}

    default void initFlowRuleByFile() {}
}
