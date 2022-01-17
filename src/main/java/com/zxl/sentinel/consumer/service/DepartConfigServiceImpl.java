package com.zxl.sentinel.consumer.service;

import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.zxl.sentinel.consumer.datasource.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置文件
 * Created by ZXL on 2021/10/6.
 */
@Component
public class DepartConfigServiceImpl implements DepartService {

    @Autowired
    DataSource fileDataSource;

    @Override
    public void initFlowRule(Integer count) {
        FlowRule flowRule=new FlowRule();
        flowRule.setResource("updateConfig");
        flowRule.setCount(count);
        flowRule.setGrade(1);
        flowRule.setStrategy(0);
        flowRule.setControlBehavior(0);
        flowRule.setLimitApp("default");
        List<FlowRule> list=new ArrayList<>();
        list.add(flowRule);
        FlowRuleManager.loadRules(list);
    }

    @Override
    public void initFlowRuleByFile() {
        fileDataSource.initFlowRule();
    }
}
