package com.intraconnect.usermanagementms.repository;

import com.intraconnect.usermanagementms.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends MongoRepository<User, String> {

//Optional<User> findByEmail2(String email);
   Optional<User> findByEmail2(String email);

    UserDetails findByEmail(String email);

}