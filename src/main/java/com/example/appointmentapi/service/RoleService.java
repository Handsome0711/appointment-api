package com.example.appointmentapi.service;

import com.example.appointmentapi.model.Role;

public interface RoleService {
    Role findByRoleName(Role.RoleName roleName);

    void add(Role role);
}
