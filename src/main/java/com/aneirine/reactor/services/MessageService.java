package com.aneirine.reactor.services;

import com.aneirine.reactor.models.Message;
import com.aneirine.reactor.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Flux<Message> findAll(){
        return messageRepository.findAll();
    }

    public Mono<Message> createMessage(Message message){
        return messageRepository.save(message);
    }
}
