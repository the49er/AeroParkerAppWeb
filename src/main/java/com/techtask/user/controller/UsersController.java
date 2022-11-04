package com.techtask.user.controller;

import com.techtask.user.dao.abstraction.UserDaoService;
import com.techtask.user.model.UserModel;
import com.techtask.user.dao.abstraction.UserDaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/pages")
public class UsersController {


    private final UserDaoService userDaoService;

    @GetMapping("/customer")
    public String allUsers(Model model, Principal principal) {
        List<UserModel> listUsers = userDaoService.findAll();
        model.addAttribute("allUsers",
                listUsers);

        return "pages/customer";
    }


}