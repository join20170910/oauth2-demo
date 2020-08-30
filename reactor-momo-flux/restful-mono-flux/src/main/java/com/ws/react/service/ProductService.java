package com.ws.react.service;

import com.ws.react.entity.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName ProductService
 * @Deacription TODO
 * @Author apple
 * @Date 2020/8/29 15:21
 * @Version 1.0
 **/

@Service
public class ProductService {

    private final Map<String, Product> products = new ConcurrentHashMap<>();

    public Flux<Product> getProducts(){
        return Flux.fromIterable(this.products.values());
    }
    public Flux<Product> getProductByIds(final Flux<String> ids){
        return ids.flatMap(id -> Mono.justOrEmpty(this.products.get(id)));
    }

    public Mono<Product> getProductById(final String id){
        return Mono.justOrEmpty(this.products.get(id));
    }

    public Mono<Void> createOrUpdateProduct(final Mono<Product> productMono){
        return productMono.doOnNext(
                product -> {
                    products.put(product.getId(),product);
                }
        ).thenEmpty(Mono.empty());
    }

    public Mono<Product> deleteProduct(final String id){
        return Mono.justOrEmpty(this.products.remove(id));
    }
}
