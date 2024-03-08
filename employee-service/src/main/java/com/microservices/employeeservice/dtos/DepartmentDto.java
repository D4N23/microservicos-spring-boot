package com.microservices.employeeservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    
    private Long id;
    private String departmentName;
    private String departmentCode;
    private String departmentDescription;
}
