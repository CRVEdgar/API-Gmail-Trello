package com.example.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

    return builder.routes()
            .route(p -> p.path("/post")
                .uri("http://httpbin.org:80"))
            .route(p -> p.path("/trello-service/**")
                .uri("lb://trello-service"))
            .route(p -> p.path("/sendmail-service/**")
                .uri("lb://sendmail-service"))
            .build();
}
}
