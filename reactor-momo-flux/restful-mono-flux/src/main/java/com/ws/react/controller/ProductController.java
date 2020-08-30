package com.ws.react.controller;

import com.ws.react.entity.Product;
import com.ws.react.service.ProductService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @ClassName ProductController
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 15:33
 * @Version 1.0
 **/
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public Flux<Product> getProducts(){
        return productService.getProducts();
    }

}
