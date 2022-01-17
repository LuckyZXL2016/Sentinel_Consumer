package com.zxl.sentinel.consumer.controller;

import com.zxl.sentinel.consumer.bean.Depart;
import com.zxl.sentinel.consumer.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxl
 * @date 2021/9/23.
 */
@RestController
public class DepartController {

    @Autowired
    DepartService departServiceImpl;

    @Autowired
    DepartService departTwoServiceImpl;

    @Autowired
    DepartService departThreeServiceImpl;

    @Autowired
    DepartService departConfigServiceImpl;

    @GetMapping("/consumer/depart/get/{id}")
    public Depart getHandle(@PathVariable("id") int id) {
        return departServiceImpl.getDepartById(id);
    }

    @GetMapping("/consumer/depart/get2/{id}")
    public Depart getHandleTwo(@PathVariable("id") int id) {
        return departTwoServiceImpl.getDepartById(id);
    }

    @GetMapping("/consumer/depart/get3/{id}")
    public Depart getHandleThree(@PathVariable("id") int id) {
        return departThreeServiceImpl.getDepartById(id);
    }

    @GetMapping("/consumer/config/update/{count}")
    public void updateConfig(@PathVariable("count") int count) {
        departConfigServiceImpl.initFlowRule(count);
    }

    @GetMapping("/consumer/config/update2")
    public void updateConfigByFile() {
        departConfigServiceImpl.initFlowRuleByFile();
    }
}