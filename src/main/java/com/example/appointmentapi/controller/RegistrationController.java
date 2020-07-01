package com.example.appointmentapi.controller;

import com.example.appointmentapi.model.dto.UserRegistrationDto;
import com.example.appointmentapi.service.RegistrationService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/registration")
    public void registration(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        registrationService.register(userRegistrationDto.getEmail(),
                userRegistrationDto.getPassword(), userRegistrationDto.getRoleName());
    }
}
