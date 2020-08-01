package com.ws.auth.common.zooklock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName DisZookLock
 * @Deacription TODO
 * @Author apple
 * @Date 2020/7/31 22:07
 * @Version 1.0
 **/
public class DisZookLock {

    @Autowired
    private CuratorFramework curatorFramework;

    private InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework,"/product_");
}
