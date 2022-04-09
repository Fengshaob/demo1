package com.example.demo.common;

import com.baomidou.mybatisplus.core.toolkit.Assert;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 基于redission客户端实现的分布式锁
 * 1，防止死锁
 * 2，只能解锁自己加的锁
 * 3，自动续上锁的过期时间
 * 4，能设置锁的等待时间，到了时间还获取不到则抛异常
 * 5，redis集群部署（有主从切换的时候数据丢失问题，解决方案用redLock）
 */
@Component
public class LockUtil {

    @Autowired
    private RedissonClient redissonClient;

    public void lock(String key, Long waitSecond) throws Exception{
        Assert.notEmpty(key, "锁key不能为空");
        RLock lock = redissonClient.getLock(key);
        boolean tryLock = lock.tryLock(waitSecond, TimeUnit.SECONDS);
        if (!tryLock) {
            throw new RuntimeException("获取锁超时: " + key);
        }
    }

    public void unlock(String key) {
        Assert.notEmpty(key, "锁key不能为空");
        RLock lock = redissonClient.getLock(key);
        if (lock.isLocked() && lock.isHeldByCurrentThread()) lock.unlock();
    }

}
