package com.aneirine.reactor.config;

import com.aneirine.reactor.handler.GreetingHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class GreetingRouter {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(GreetingHandler handler) {
        RequestPredicate requestPredicates = RequestPredicates
                .GET("/hello")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON));
        return RouterFunctions.route(requestPredicates, handler::hello)
                .andRoute(RequestPredicates.GET("/"), handler::main);

    }
}
