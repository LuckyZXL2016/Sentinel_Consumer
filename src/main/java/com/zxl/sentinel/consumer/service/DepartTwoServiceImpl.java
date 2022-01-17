package com.zxl.sentinel.consumer.service;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zxl.sentinel.consumer.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zxl
 * @date 2021/9/26.
 */
@Service
public class DepartTwoServiceImpl implements DepartService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Depart getDepartById(Integer id) {
        Entry entry = null;
        try {
            entry = SphU.entry("getDepartTwo");
            String url = "http://zxl-provider-depart/provider/depart/get/" + id;
            return restTemplate.getForObject(url, Depart.class);
        } catch (BlockException e) {
            return Depart.builder()
                    .id(id)
                    .name("flow-blockHandler2-" + id)
                    .build();
        } finally {
            // SphU.entry(xxx) 需要与 entry.exit() 成对出现,否则会导致调用链记录异常
            if (entry != null) {
                entry.exit();
            }
        }
    }
}
