package com.example.ss8_validate_form.controller;

import com.example.ss8_validate_form.model.User;
import com.example.ss8_validate_form.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class FormController {
    @Autowired
    private UserService userService;
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }
    @PostMapping("/register")
    public String register(
            @Valid @ModelAttribute("user") User user,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        userService.save(user);
        return "result";
    }
}