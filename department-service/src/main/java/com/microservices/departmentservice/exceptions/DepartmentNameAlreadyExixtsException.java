package com.microservices.departmentservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DepartmentNameAlreadyExixtsException extends RuntimeException {
    private String message;
    public DepartmentNameAlreadyExixtsException(String message) {
        super(message);
    }
}
