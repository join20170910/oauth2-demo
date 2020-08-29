package com.ws.core.launch.config;

import com.ws.core.launch.props.WsProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Author apple 配置类
 * @Description //TODO
 * @Date 12:06 2020/8/23
 **/

@Configuration
@AllArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties({
	WsProperties.class
})
public class WsLaunchConfiguration {

}
