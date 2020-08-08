package com.aneirine.reactor.controllers;

import com.aneirine.reactor.models.Message;
import com.aneirine.reactor.models.data.MessageData;
import com.aneirine.reactor.services.MessageService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public Flux<Message> getAllMessages(@RequestParam("start") long start,
                                        @RequestParam("count") long count){
        return messageService.getAllMessages();
    }

    @PostMapping
    public Mono<Message> crateMessage(@RequestBody MessageData messageData){
        return messageService.createMessage(messageData);
    }
}
