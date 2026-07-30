package com.example.ss2_bai1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class SandwichController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment,
                       Model model) {
        model.addAttribute("condiments", condiment);
        return "result";
    }
}