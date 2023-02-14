package com.example.springboot_demo2.controller;


import com.example.springboot_demo2.dto.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymeleafDemoController {
    @GetMapping("/thymeleaf")
    public String index() {
        return "index";
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("today", "Monday");
        Todo helfeih = new Todo("hello", "HelloWorld");
        model.addAttribute("user", helfeih);
        return "hello";
    }
}
