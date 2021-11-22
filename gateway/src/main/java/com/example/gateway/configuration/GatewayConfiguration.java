package com.example.gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

//        return builder.routes()
//                .route(p -> p.path("/get") // intercepta o que passa na requisição do tipo especificado e redireciona para:
//                        .filters(
//                                f -> f.addRequestHeader("NomeCabecalho", "Valor")
//                                        .addRequestParameter("Parametro", "Valor")
//                        )
//                        .uri("http://httpbin.org:80"))
//                // caminhos de acesso ao loadbalance do Eureka
//                .route(p -> p.path("/trello-service/**") //TODO - NOME DA APP
//                        .uri("lb://trello-service")) // nome do serviço registrado no Eureka
//                .route(p -> p.path("/sendmail-service/**") // TODO - NOME DO APP
//                        .uri("lb://sendmail-service")) // nome do serviço registrado no Eureka
//                .build();
//    }

    return builder.routes()
            .route(p -> p.path("/post") // intercepta o que passa na requisição do tipo especificado e redireciona para:
//                .filters(
//                    f -> f.addRequestHeader("NomeCabecalho", "Valor")
//                            .addRequestParameter("Parametro", "Valor")
//                        )
                .uri("http://httpbin.org:80"))
            // caminhos de acesso ao loadbalance do Eureka
            .route(p -> p.path("/trello-service/**") //TODO - NOME DA APP
                .uri("lb://trello-service")) // nome do serviço registrado no Eureka
            .route(p -> p.path("/sendmail-service/**") // TODO - NOME DO APP
                .uri("lb://sendmail-service")) // nome do serviço registrado no Eureka
            .build();
}
}
