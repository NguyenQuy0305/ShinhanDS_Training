package com.example.practice_aop.service.impl;

import com.example.practice_aop.dto.EmployeeDTO;
import com.example.practice_aop.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public EmployeeDTO getEmployeeDto(EmployeeDTO employeeDTO) {
        //Create exception for test logging
        if(employeeDTO.getEmployeeId() == 0) {
            try {
                throw new Exception("Id can't be zero");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return employeeDTO;
    }
}
