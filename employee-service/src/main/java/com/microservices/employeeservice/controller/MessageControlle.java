package com.microservices.employeeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Value;

@RestController
public class MessageControlle {
    
    @Value("${spring.boot.message}")
    private String message;

    @GetMapping("/users/message")
    public String message(){
        return message;
    }
}
