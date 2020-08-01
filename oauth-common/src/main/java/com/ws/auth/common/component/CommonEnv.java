package com.ws.auth.common.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CommonEnv {

    public static String ZK_ADDRESS;
    public static String ZK_LOCK_PATH;

    @Autowired
    public void setZkAddress(@Value("${zk.address}") String zkAddress) {
        ZK_ADDRESS = zkAddress;
    }

    @Autowired
    public void setZkLockPath(@Value("${zk.lock.path}") String zkLockPath) {
        ZK_LOCK_PATH = zkLockPath;
    }
}