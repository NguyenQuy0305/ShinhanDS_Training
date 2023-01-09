package com.example.springboot_demo2.service.impl;

import com.example.springboot_demo2.repository.DemoRepository;
import com.example.springboot_demo2.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoRepository demoRepository;

    @Override
    public String getText() {
        return demoRepository.getTest();
    }
}
