package com.intraconnect.usermanagementms.controller;
import com.intraconnect.usermanagementms.Config.JwtUtils;
import com.intraconnect.usermanagementms.dto.UserInput;
import com.intraconnect.usermanagementms.entities.Role;
import com.intraconnect.usermanagementms.entities.User;
import com.intraconnect.usermanagementms.repository.UserRepo;
import com.intraconnect.usermanagementms.service.UserService;
import lombok.AllArgsConstructor;


import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

import java.util.Optional;


@Controller
@AllArgsConstructor
public class UserController {
private  final UserRepo userRepo;
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @MutationMapping
    public String registerUser(@Argument("userInput") UserInput userInput) {
        if (userInput != null) {
            try {
                return userService.register(userInput);
            } catch (IllegalStateException e) {
                throw new IllegalArgumentException("User registration failed: " + e.getMessage());
            }
        } else {
            throw new IllegalArgumentException("User input must not be null");
        }
    }
@MutationMapping
public String authenticate(@Argument("user") User user) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
     authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword()));
            final UserDetails userDetails = userRepo.findByEmail(user.getEmail());
            final String jwt = jwtUtils.generateToken(userDetails);
            return jwt;
}



    @MutationMapping
    public User assignRole(@Argument String id,@Argument Role role){
        return userService.assignRole(id,role);
    }

}



