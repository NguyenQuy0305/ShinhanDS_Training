package com.example.practice_aop.controller;

import com.example.practice_aop.dto.DepartmentDTO;
import com.example.practice_aop.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity getAll(@RequestBody @Valid DepartmentDTO departmentDTO) {
        return ResponseEntity.ok(departmentService.getDepartmentDto(departmentDTO));
    }
}
