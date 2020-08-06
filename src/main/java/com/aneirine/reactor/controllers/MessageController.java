package com.aneirine.reactor.controllers;

import com.aneirine.reactor.models.Message;
import com.aneirine.reactor.services.MessageService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @GetMapping
    public Flux<Message> getList(@RequestParam("start") int start, @RequestParam("count") int count){
        return messageService.findAll();
    }

    @PostMapping
    public Mono<Message> createMessage(Message message){
        return messageService.createMessage(message);
    }


}
