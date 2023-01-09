package com.example.springboot_demo2.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {
    private String test;

    public DemoRepository() {
        this.test = "Hello World!";
    }

    public String getTest() {
        return test;
    }
}
