package com.aneirine.reactor.api.messages;

import com.aneirine.reactor.entities.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}
