package com.microservices.employeeservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeEmailAlreadyExistsException extends RuntimeException {
    private String message;

    public EmployeeEmailAlreadyExistsException(String message) {
        super(message);
    }
}
