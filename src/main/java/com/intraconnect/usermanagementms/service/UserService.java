package com.intraconnect.usermanagementms.service;
import com.intraconnect.usermanagementms.dto.UserInput;
import com.intraconnect.usermanagementms.entities.Role;
import com.intraconnect.usermanagementms.entities.Token;
import com.intraconnect.usermanagementms.entities.User;
import com.intraconnect.usermanagementms.repository.TokenRepo;
import com.intraconnect.usermanagementms.repository.UserRepo;
import lombok.AllArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor


public class UserService implements UserDetailsService {



    private  final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final TokenRepo tokenRepo;

@Transactional
    public String register(UserInput userInput)
    {
        boolean userExists=userRepo.findByEmail2(userInput.getEmail()).isPresent();
        if (userExists)
        {
            throw  new IllegalStateException("A user already exists with that email");
        }
        //encode password
        String encodedPassword = passwordEncoder.encode(userInput.getPassword());

        User user = User.builder().firstName(userInput.getFirstName()).
                lastName(userInput.getLastName())
                .adresse(userInput.getAddress())
                .contactNumber(userInput.getContactNumber())
                .dateOfBirth(userInput.getDateOfBirth())
                .password(encodedPassword)
                .email(userInput.getEmail())
                .role(Role.USER)
                .build();

        userRepo.save(user);
        String generatedToken= UUID.randomUUID().toString();
        Token  token=Token.builder().token(generatedToken).createdAT(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(15)).build();
        tokenRepo.save(token);
        return generatedToken;
    }
public User save (User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepo.save(user);
}
    public User assignRole(String id, Role role) throws RuntimeException {
        User u = userRepo.findById(id).orElse(null);
        if(!Objects.isNull(u)){
            u.setRole(role);
            return userRepo.save(u);
        }else{
            throw new RuntimeException("User not found with ID: " + id);
        }
    }




    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserDetails> userOptional = Optional.ofNullable(userRepo.findByEmail(email));
        return userOptional.orElseThrow(() -> new UsernameNotFoundException("No USER Found with this mail"));
    }


}





