package com.microservices.employeeservice.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Long id;

    @NotEmpty(message = "The Employee must register a First Name")
    private String firstName;

    @NotEmpty(message = "The Employee must register a Last Name")
    private String lastName;

    @NotEmpty(message = "The Employee must register a Email")
    @Email(message = "Please use a valid email format: email@email.com")
    private String email;

    private String departmentCode;
    private String organizationCode;
}
