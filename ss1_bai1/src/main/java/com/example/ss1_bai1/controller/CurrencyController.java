package com.example.ss1_bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CurrencyController {
    @GetMapping("/")
    public String showForm() {
        return "index";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam("usd") double usd,
                          @RequestParam("rate") double rate,
                          Model model) {
        double result = usd * rate;
        model.addAttribute("result", result);
        return "index";
    }
}