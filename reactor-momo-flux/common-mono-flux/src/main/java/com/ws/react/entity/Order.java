package com.ws.react.entity;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName Order
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 13:43
 * @Version 1.0
 **/
@Data
public class Order {

    private String id ;
    private String accountId;
    private String item;
    private Date createTime;
}
