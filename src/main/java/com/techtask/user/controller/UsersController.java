package com.techtask.user.controller;

import com.techtask.user.dao.abstraction.UserDaoService;
import com.techtask.user.model.UserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
@RequestMapping("/pages")
public class UsersController {


    private final UserDaoService userDaoService;
    private UUID uuid;

    @GetMapping("/customer")
    public String allUsers(Model model, Principal principal) {
//        userDaoService.save(new UserModel("Petr", "Ivanov", "1234567890", "1234567890", "1234567890","1234567890","1234567890","1234567890" )
        List<UserModel> listUsers = userDaoService.findAll();
        model.addAttribute("allUsers",
                listUsers);

        return "pages/customer";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") UUID uuid){
        userDaoService.delete(uuid);
        return "redirect:/pages/customer";
    }
    @GetMapping("/404")
    public String page404() {
        return "pages/404";
    }

}