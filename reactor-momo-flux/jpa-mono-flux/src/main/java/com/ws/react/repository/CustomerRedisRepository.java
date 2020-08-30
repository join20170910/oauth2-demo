package com.ws.react.repository;

import com.ws.react.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @ClassName CustomerRedisRepository
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 17:30
 * @Version 1.0
 **/

@Repository
public class CustomerRedisRepository {
    @Autowired
    RedisTemplate<Object,Object> redisTemplate;
    @Resource(name = "redisTemplate")
    ValueOperations<Object,Object> valueOperation;

    public void saveCustomer(Customer customer){
        valueOperation.set(customer.getId(),customer);
    }

    public Customer getCustomer(){
        return (Customer) valueOperation.get("Customer001");
    }
}
