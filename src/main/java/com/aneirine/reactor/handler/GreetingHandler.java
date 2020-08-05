package com.aneirine.reactor.handler;

import com.aneirine.reactor.models.Message;
import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class GreetingHandler {

    public Mono<ServerResponse> hello(ServerRequest request) {

        Long start = request.queryParam("start")
                .map(Long::valueOf)
                .orElse(0L);
        Long count = request.queryParam("count")
                .map(Long::valueOf)
                .orElse(3L);

        Flux<Message> messageFlux = Flux.just("Hello, reactive", "Second one", "3 post", "4 post", "5 post")
                .skip(start)
                .take(count)
                .map(Message::new);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(messageFlux, Message.class);
    }

    public Mono<ServerResponse> main(ServerRequest request) {
        String name = request.queryParam("name").orElse("Nobody");
        BodyInserter<String, ReactiveHttpOutputMessage> body = BodyInserters.fromValue("Hi, " + name + "!");
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);

    }
}
