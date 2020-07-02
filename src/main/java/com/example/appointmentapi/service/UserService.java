package com.example.appointmentapi.service;

import com.example.appointmentapi.model.User;

public interface UserService {
    User findByEmail(String email);

    User save(User user);

    void flush();
}
