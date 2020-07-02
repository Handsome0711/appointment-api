package com.example.appointmentapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthTestController {
    @GetMapping("/auth")
    public String authTest() {
        return "Hello from auth test controller!";
    }
}
