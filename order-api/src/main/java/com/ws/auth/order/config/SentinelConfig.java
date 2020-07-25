package com.ws.auth.order.config;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.zookeeper.ZookeeperDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @ClassName SentinelConfig
 * @Deacription TODO
 * @Author apple
 * @Date 2020/7/22 23:03
 * @Version 1.0
 **/
@Component
public class SentinelConfig {

    @Value("${sentinel.zookeeper.address}")
    private String zkServer;
    @Value("${sentinel.zookeeper.path}")
    private String zkPath;
    @Value("${spring.application.name}")
    private String appName;

    @PostConstruct
    public void loadRules(){
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new ZookeeperDataSource<>(zkServer, zkPath +"/"+appName,
                source -> JSON.parseArray(source,
                        FlowRule.class));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());


    }
}
