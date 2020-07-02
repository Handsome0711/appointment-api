package com.example.appointmentapi.controller;

import com.example.appointmentapi.model.Role;
import com.example.appointmentapi.model.Teacher;
import com.example.appointmentapi.model.User;
import com.example.appointmentapi.service.RoleService;
import com.example.appointmentapi.service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InjectDataController {

    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    private UserService userService;

    public InjectDataController(RoleService roleService,
                                PasswordEncoder passwordEncoder,
                                UserService userService) {
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostConstruct
    public void injectRoles() {
        roleService.add(Role.of("STUDENT"));
        roleService.add(Role.of("TEACHER"));
    }

    @PostConstruct
    public void injectStudent() {
        User student = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName(Role.RoleName.STUDENT));
        student.setEmail("new.student@gmail.com");
        student.setPassword(passwordEncoder.encode("student"));
        student.setRoles(roles);
        userService.save(student);
    }

    @PostConstruct
    public void injectTeacher() {
        User teacher = new Teacher();
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName(Role.RoleName.TEACHER));
        teacher.setEmail("new.teacher@gmail.com");
        teacher.setPassword(passwordEncoder.encode("teacher"));
        teacher.setRoles(roles);
        userService.save(teacher);
    }
}
