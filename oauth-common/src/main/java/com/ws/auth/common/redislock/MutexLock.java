package com.ws.auth.common.redislock;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.RetryNTimes;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import static com.ws.auth.common.component.CommonEnv.ZK_ADDRESS;
import static com.ws.auth.common.component.CommonEnv.ZK_LOCK_PATH;

public class MutexLock implements InitializingBean, DisposableBean {

    private static CuratorFramework client;
    private static InterProcessLock mutexLock;
    private static volatile boolean acquiredLock;
    private static volatile MutexLock instance;

    public MutexLock() {
        client = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(10,5000));
        client.start();
        mutexLock =  new InterProcessMutex(client, ZK_LOCK_PATH);
    }

    public static MutexLock getInstance(){
        if (instance == null) {
            synchronized (MutexLock.class) {
                if (instance == null) {//二次检查
                    instance = new MutexLock();
                }
            }
        }
        return instance;
    }

    public static boolean isInstantiated() {
        if (instance == null) {
            return false;
        }
        return true;
    }

    //获取锁
    public static void acquireMutexLock() throws Exception {
        mutexLock.acquire();
        acquiredLock = true;
    }

    //释放锁
    public static void releaseMutexLock() throws Exception {
        mutexLock.release();
    }

    public static boolean isAcquiredLock() {
        return acquiredLock;
    }


    @Override
    public void destroy() throws Exception {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}