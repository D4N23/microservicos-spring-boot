package com.microservices.departmentservice.services;

import com.microservices.departmentservice.dtos.DepartmentDto;

public interface DepartmentService {
    
    DepartmentDto savDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByCode(String code);
}
