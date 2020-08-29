package com.ws.auth.gateway.filter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName CustomGatewayFilter
 * @Deacription TODO 统计某个或者某种路由的处理时长
 * @Author apple
 * @Date 2020/8/26 21:06
 * @Version 1.0
 **/
public class CustomGatewayFilter implements GatewayFilter, Ordered {

    private static final Log log = LogFactory.getLog(CustomGatewayFilter.class);
    private static final String COUNT_START_TIME = "countStartTime";


    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
     exchange.getAttributes().put(
             COUNT_START_TIME,System.currentTimeMillis()
     );
     return chain.filter(exchange).then(
             Mono.fromRunnable(
                     () ->{
                         Long startTime = exchange.getAttribute(COUNT_START_TIME);
                         Long endTime = (System.currentTimeMillis()-startTime);
                         if (startTime != null){
                             log.info(exchange.getRequest().getURI().getRawPath() + ": "+ endTime + " MS");
                         }
                     }

             )
     );
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}
