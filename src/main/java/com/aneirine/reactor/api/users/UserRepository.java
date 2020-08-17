package com.aneirine.reactor.api.users;

import com.aneirine.reactor.entities.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
