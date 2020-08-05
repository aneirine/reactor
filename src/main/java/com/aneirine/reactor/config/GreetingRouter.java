package com.aneirine.reactor.config;

import com.aneirine.reactor.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(GreetingHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/hello")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::hello)
                .andRoute(RequestPredicates.GET("/"),
                        serverRequest -> ServerResponse
                                .ok()
                                 .contentType(MediaType.APPLICATION_JSON)
                                .body(
                                        BodyInserters.fromValue("Hi!")
                                ));

    }
}
