package com.techtask.user.controller;

import com.techtask.security.service.RegistrationService;
import com.techtask.user.model.UserRegistrationDto;
import com.techtask.util.UserRegistrationDtoValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RegistrationService registrationService;

    private final UserRegistrationDtoValidator userRegistrationDtoValidator;

    @GetMapping("/login")
    public String registrationPage(@ModelAttribute("userModel") UserRegistrationDto userRegistrationDto) {

        return "auth/login";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("userModel") @Valid UserRegistrationDto person,
                                      BindingResult bindingResult
    ) {
        userRegistrationDtoValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors()) {
            return "auth/login";
        }
        registrationService.register(person);

        return "redirect:/auth/login";
    }
}
