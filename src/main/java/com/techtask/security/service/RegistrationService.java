package com.techtask.security.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techtask.user.model.UserModel;
import com.techtask.user.model.UserRegistrationDto;
import com.techtask.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ObjectMapper objectMapper;

    @Transactional
    public void register(UserRegistrationDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        UserModel userModel = objectMapper.convertValue(user, UserModel.class);

        userRepository.save(userModel);
    }
}
