package com.microservices.departmentservice.dtos;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    
    private Long id;

    @NotEmpty(message = "Please the Department there must be a name")
    // @UniqueElements(message = "The Department name Already Exists")
    private String departmentName;

    @NotEmpty(message = "Please the department there must be a Code")
    private String departmentCode;

    @NotEmpty(message = "Please the department there must be a Description")
    private String departmentDescription;
}
