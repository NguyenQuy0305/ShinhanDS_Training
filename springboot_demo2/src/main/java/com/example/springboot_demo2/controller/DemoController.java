package com.example.springboot_demo2.controller;

import com.example.springboot_demo2.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping(value = "/")
    public String getDemo() {
        return demoService.getText();
    }
}
