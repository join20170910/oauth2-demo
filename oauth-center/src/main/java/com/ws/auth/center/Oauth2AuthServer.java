package com.ws.auth.center;

import com.ws.core.launch.WsApplication;
import com.ws.core.launch.constant.AppConstant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author John
 * @Description //TODO 用户认证服务器
 * @Date 15:43 2020/8/23
 **/
@SpringCloudApplication
@EnableFeignClients(AppConstant.BASE_PACKAGES)

public class Oauth2AuthServer {
  public static void main(String[] args) {
      WsApplication.run(AppConstant.APPLICATION_AUTH_NAME, Oauth2AuthServer.class,args);
  }
}
