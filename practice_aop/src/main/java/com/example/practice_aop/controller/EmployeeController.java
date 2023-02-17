package com.example.practice_aop.controller;

import com.example.practice_aop.dto.EmployeeDTO;
import com.example.practice_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity getAll(@RequestBody @Valid EmployeeDTO employeeDTO) {
        return ResponseEntity.ok(employeeService.getEmployeeDto(employeeDTO));
    }
}
