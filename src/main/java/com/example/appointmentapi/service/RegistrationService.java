package com.example.appointmentapi.service;

import com.example.appointmentapi.model.Role;
import com.example.appointmentapi.model.User;

public interface RegistrationService {
    User register(String email, String password, Role.RoleName roleName);
}
