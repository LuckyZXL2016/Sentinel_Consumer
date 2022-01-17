package com.zxl.sentinel.consumer.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zxl.sentinel.consumer.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author zxl
 * @date 2021/9/24.
 */
@Service
public class DepartServiceImpl implements DepartService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    @SentinelResource(value = "getDepartOne", fallback = "getFallHandlerBack", blockHandler = "getBlockHandlerBack")
    public Depart getDepartById(Integer id) {
        String url = "http://zxl-provider-depart/provider/depart/get/" + id;
        return restTemplate.getForObject(url, Depart.class);
    }

    public Depart getFallHandlerBack(Integer id, Throwable e) {
        return Depart.builder()
                .id(id)
                .name("flow-fallback-" + id)
                .build();
    }

    public Depart getBlockHandlerBack(Integer id, BlockException e) {
        return Depart.builder()
                .id(id)
                .name("flow-blockHandler-" + id)
                .build();
    }
}

