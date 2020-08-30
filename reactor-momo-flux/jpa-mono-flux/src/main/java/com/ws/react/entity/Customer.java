package com.ws.react.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @ClassName Customer
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 17:11
 * @Version 1.0
 **/
@Entity
@NamedQuery(name ="Customer.withAddressNamedQuery",query = "select c from Customer c where c.address=?1")
@Data
public class Customer {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String address;
}
