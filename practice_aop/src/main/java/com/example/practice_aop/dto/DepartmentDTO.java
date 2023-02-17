package com.example.practice_aop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long departmentId;

    @NotEmpty(message = "department name is not empty")
    @Length(min = 10, max = 50)
    private String deptName;

    @NotEmpty(message = "description for department is not empty")
    private String description;

    @Valid
    private List<EmployeeDTO> employeeList;
}
