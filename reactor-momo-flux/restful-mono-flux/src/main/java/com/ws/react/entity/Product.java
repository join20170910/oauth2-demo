package com.ws.react.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @ClassName Product
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 15:19
 * @Version 1.0
 **/

@Data
@AllArgsConstructor
public class Product {

    private String id;
    private String productCode;
    private String productName;
    private String description;
    private Float price;

}
