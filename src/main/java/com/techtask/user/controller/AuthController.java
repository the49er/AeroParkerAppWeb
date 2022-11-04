package com.techtask.user.controller;

import com.techtask.security.service.RegistrationService;
import com.techtask.user.model.UserRegistrationDto;
import com.techtask.util.UserRegistrationDtoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class AuthController {

    private final RegistrationService registrationService;

    private final UserRegistrationDtoValidator userRegistrationDtoValidator;

    @GetMapping("/login")
    public String loginPage() {
        return "user/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("userModel") UserRegistrationDto userRegistrationDto) {

        return "user/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("userModel") @Valid UserRegistrationDto person,
                                      BindingResult bindingResult
    ) {
        userRegistrationDtoValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
        return "user/registration";

        registrationService.register(person);

        return "redirect:/login";
    }
}
