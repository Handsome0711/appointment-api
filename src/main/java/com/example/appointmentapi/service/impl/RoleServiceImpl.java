package com.example.appointmentapi.service.impl;

import com.example.appointmentapi.model.Role;
import com.example.appointmentapi.repo.RoleRepo;
import com.example.appointmentapi.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepo roleRepo;

    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role findByRoleName(Role.RoleName roleName) {
        return roleRepo.findByRoleName(roleName);
    }

    @Override
    public void add(Role role) {
        roleRepo.save(role);
    }
}
