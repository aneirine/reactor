package com.aneirine.reactor.repo;

import com.aneirine.reactor.models.Message;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<Message, Long> {
}
