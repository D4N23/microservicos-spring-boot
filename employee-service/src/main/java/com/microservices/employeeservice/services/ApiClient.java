package com.microservices.employeeservice.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.employeeservice.dtos.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

     @GetMapping("v1/departments/{department-code}")
     DepartmentDto getDepartment(@PathVariable("department-code") String departmentCode);
}
