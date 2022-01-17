package com.zxl.sentinel.consumer.datasource;

import com.alibaba.csp.sentinel.property.DynamicSentinelProperty;
import com.alibaba.csp.sentinel.property.SentinelProperty;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.nacos.common.utils.IoUtils;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * 文件流
 * Created by ZXL on 2021/10/6.
 */
@Component
public class FileDataSource implements DataSource {

    public void initFlowRule() {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("flowrule.json");
            String string = IoUtils.toString(inputStream, "UTF-8");
            SentinelProperty property = new DynamicSentinelProperty<List<FlowRule>>();
            property.updateValue(JSON.parseObject(string, new TypeReference<List<FlowRule>>() {
            }));
            FlowRuleManager.register2Property(property);
//            System.out.println(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
