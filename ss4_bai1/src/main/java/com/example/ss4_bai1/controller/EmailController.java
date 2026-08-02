package com.example.ss4_bai1.controller;

import com.example.ss4_bai1.model.EmailSetting;
import com.example.ss4_bai1.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {

    @Autowired
    private IEmailService service;

    @GetMapping("/")
    public String showForm(Model model) {

        model.addAttribute("setting", service.getSetting());

        model.addAttribute("languages",
                new String[]{
                        "English",
                        "Vietnamese",
                        "Japanese",
                        "Chinese"
                });

        model.addAttribute("pageSizes",
                new Integer[]{
                        5, 10, 15, 25, 50, 100
                });

        return "settings";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute EmailSetting setting) {

        service.update(setting);

        return "redirect:/";
    }
}