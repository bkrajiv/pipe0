package com.example.pipe0.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    int change=5;
    @GetMapping
    public String getEmployees() {
        return "List of employees";
    }

}
