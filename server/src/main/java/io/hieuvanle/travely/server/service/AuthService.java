package io.hieuvanle.travely.server.service;

import io.hieuvanle.travely.server.model.RegisterRequest;
import io.hieuvanle.travely.server.model.User;
import io.hieuvanle.travely.server.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Transactional
    public void register(RegisterRequest registerRequest) {
        if(registerRequest.getEmail() == null || registerRequest.getUsername() == null ||
            registerRequest.getPassword() == null) {
            throw new IllegalArgumentException("Please enter all fields.");
        }
        if(userRepository.findUserByEmail(registerRequest.getEmail()).isPresent() ||
            userRepository.findUserByUserName(registerRequest.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username or Email already exists.");
        }
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setUserName(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);
    }
}
