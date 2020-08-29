package com.ws.auth.gateway;

import com.ws.auth.gateway.filter.CustomGatewayFilter;
import com.ws.core.launch.WsApplication;
import com.ws.core.launch.constant.AppConstant;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

/** 网关启动类
 * @author john
 */

@EnableHystrix
@EnableScheduling
@SpringCloudApplication
public class GatewayServer {
  public static void main(String[] args) {
      WsApplication.run(AppConstant.APPLICATION_GATEWAY_NAME, GatewayServer.class, args);

  }

  @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder builder){
      return builder.routes()
              .route(
                      r -> r.path("/test")
                      .filters( f -> f.filter(new CustomGatewayFilter()))
                      .uri("http://localhost:8001/customFilter?name=john")
                      .order(0)
                      .id("custom_filter")
              ).build();
  }
}
