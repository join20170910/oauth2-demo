package com.ws.react.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @ClassName HelloController
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 15:17
 * @Version 1.0
 **/

@RestController
public class HelloController {
    @GetMapping("/")
    public Mono<String> index(){
        return Mono.just("Hello Spring boot");
    }
}
