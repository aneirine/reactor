package com.aneirine.reactor.api.messages;

import com.aneirine.reactor.api.messages.domain.MessageData;
import com.aneirine.reactor.entities.Message;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Flux<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Mono<Message> createMessage(MessageData messageData) {
        return messageRepository.save(new Message(messageData.getData()));
    }
}
