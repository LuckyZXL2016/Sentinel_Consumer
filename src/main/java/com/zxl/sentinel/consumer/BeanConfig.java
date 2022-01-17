package com.zxl.sentinel.consumer;

import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zxl
 * @date 2021/9/27.
 */

//@Configuration
public class BeanConfig {

//    @PostConstruct
    public void initFlowRule(){
        FlowRule flowRule = new FlowRule();
        // 资源名，限流规则作用对象，一般为请求URI，@SentinelResource 中定义的value
        flowRule.setResource("getDepartByBeanConfig");
        // 限流阈值
        flowRule.setCount(1);
        // 限流阈值类型；0表示根据并发量来限流，1表示根据QPS来进行限流
        flowRule.setGrade(1);
        // 调用关系限流策略
        flowRule.setStrategy(0);
        // 限流控制行为（快速失败 、warm up 、排队等候）
        flowRule.setControlBehavior(0);
        // 控流针对的调用来源，default则不区分调用来源
        flowRule.setLimitApp("default");
        // 将该规则加载进 系统中
        List<FlowRule> list=new ArrayList<>();
        list.add(flowRule);
        FlowRuleManager.loadRules(list);
    }
}
