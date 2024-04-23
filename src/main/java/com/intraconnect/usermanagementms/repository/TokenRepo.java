package com.intraconnect.usermanagementms.repository;

import com.intraconnect.usermanagementms.entities.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TokenRepo extends MongoRepository<Token,Integer> {

    Optional<Token> findByToken(String token);
}
