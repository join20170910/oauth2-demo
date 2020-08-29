package com.ws.auth.demo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.codec.ServerCodecConfigurer;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayDemoApplication {

	public static  void main(String[] args) {
		SpringApplication.run(GatewayDemoApplication.class, args);
	}

	
	
}

