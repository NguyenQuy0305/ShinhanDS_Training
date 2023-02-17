package com.example.practice_aop.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class EmployeeDTO {
    private Long employeeId;

    @NotEmpty(message = "Not empty name")
    @Length(min = 10, max = 50)
    private String name;

    private Date birthDate;

    private String gender;

    @NotEmpty(message = "Not empty email")
    @Email(message = "don't true format")
    private String email;
}
