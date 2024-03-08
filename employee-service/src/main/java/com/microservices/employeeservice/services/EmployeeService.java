package com.microservices.employeeservice.services;

import com.microservices.employeeservice.dtos.ApiResponseDto;
import com.microservices.employeeservice.dtos.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    ApiResponseDto getEmployeebyId(Long employeeId);
}
