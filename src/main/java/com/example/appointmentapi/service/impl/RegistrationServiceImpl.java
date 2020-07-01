package com.example.appointmentapi.service.impl;

import com.example.appointmentapi.model.Role;
import com.example.appointmentapi.model.User;
import com.example.appointmentapi.service.RegistrationService;
import com.example.appointmentapi.service.RoleService;
import com.example.appointmentapi.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private UserService userService;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public RegistrationServiceImpl(UserService userService,
                                   PasswordEncoder passwordEncoder,
                                   RoleService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password, Role.RoleName roleName) {
        User user = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName(roleName));
        user.setEmail(email);
        String hashedPassword = passwordEncoder.encode(password);
        user.setPassword(hashedPassword);
        user.setRoles(roles);
        user = userService.save(user);
        return user;
    }
}
