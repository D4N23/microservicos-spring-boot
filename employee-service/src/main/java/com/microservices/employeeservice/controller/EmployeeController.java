package com.microservices.employeeservice.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.employeeservice.dtos.ApiResponseDto;
import com.microservices.employeeservice.dtos.EmployeeDto;
import com.microservices.employeeservice.services.EmployeeService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("v1/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Valid EmployeeDto employeeDto) {
        EmployeeDto createEmployeeDto = service.saveEmployee(employeeDto);
        return new ResponseEntity<>(createEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ApiResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        ApiResponseDto apiResponseDto = service.getEmployeebyId(employeeId);
        return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
    }

    

}
