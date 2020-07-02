package com.example.appointmentapi.controller;

import com.example.appointmentapi.model.Pricing;
import com.example.appointmentapi.model.Teacher;
import com.example.appointmentapi.model.dto.PricingRequestDto;
import com.example.appointmentapi.model.mappers.PricingRequestDtoMapper;
import com.example.appointmentapi.service.PricingService;
import com.example.appointmentapi.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {
    private PricingService pricingService;
    private UserService userService;
    private PricingRequestDtoMapper pricingRequestDtoMapper;

    public TeacherController(PricingService pricingService,
                             UserService userService,
                             PricingRequestDtoMapper pricingRequestDtoMapper) {
        this.pricingService = pricingService;
        this.userService = userService;
        this.pricingRequestDtoMapper = pricingRequestDtoMapper;
    }

    @PostMapping("/addPricing")
    public void addPricing(@RequestBody PricingRequestDto pricingRequestDto,
                           Authentication authentication) {
        String email = (String) authentication.getPrincipal();
        Teacher teacher = (Teacher) userService.findByEmail(email);
        Pricing pricing = pricingService.addPricing(pricingRequestDtoMapper
                .mapToPricing(pricingRequestDto));
        teacher.getPricing().add(pricing);
        userService.flush();
    }
}
