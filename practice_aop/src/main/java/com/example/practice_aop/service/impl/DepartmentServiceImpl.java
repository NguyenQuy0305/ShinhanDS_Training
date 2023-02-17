package com.example.practice_aop.service.impl;

import com.example.practice_aop.dto.DepartmentDTO;
import com.example.practice_aop.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Override
    public DepartmentDTO getDepartmentDto(DepartmentDTO departmentDTO) {
        return departmentDTO;
    }
}
