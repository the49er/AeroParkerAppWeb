package com.techtask.security.service;

import com.techtask.security.PersonDetails;
import com.techtask.user.model.UserModel;
import com.techtask.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class PersonDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserModel> userModel = ofNullable(userRepository.findByEmail(email));

        if (userModel.isEmpty()) throw new UsernameNotFoundException("User not found");

        return new PersonDetails(userModel.get());
    }
}
