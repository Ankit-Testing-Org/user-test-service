package com.app.user.service;

import com.app.user.dto.UserRegistrationRequest;
import com.app.user.dto.UserResponse;
import com.app.user.entity.User;
import com.app.user.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponse registerUser(UserRegistrationRequest request) {
        if (userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email is already in use");
        }
        
        User user = new User();
        user.setFirstName(request.firstName());
        user.setLastName(request.lastName());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setPhoneNumber(request.phoneNumber());
        
        userRepository.save(user);
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhoneNumber());
    }
}