package com.example.appointmentapi.service.impl;

import com.example.appointmentapi.model.Role;
import com.example.appointmentapi.model.Teacher;
import com.example.appointmentapi.model.User;
import com.example.appointmentapi.repo.TeacherRepo;
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
    private TeacherRepo teacherRepo;

    public RegistrationServiceImpl(UserService userService,
                                   PasswordEncoder passwordEncoder,
                                   RoleService roleService, TeacherRepo teacherRepo) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.teacherRepo = teacherRepo;
    }

    @Override
    public User register(String email, String password, Role.RoleName roleName) {
      //  User user = new User();
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.findByRoleName(roleName));
        String hashedPassword = passwordEncoder.encode(password);
        if (roleName == Role.RoleName.TEACHER) {
            return registerTeacher(email, hashedPassword, roles);
        }
        User user = new User();
        user.setEmail(email);
        user.setPassword(hashedPassword);
        user.setRoles(roles);
        user = userService.save(user);
        return user;
    }
    private User registerTeacher(String email, String hashedPassword, Set<Role> roles) {
        User teacher = new Teacher();
        teacher.setEmail(email);
        teacher.setPassword(hashedPassword);
        teacher.setRoles(roles);
        teacher =  userService.save(teacher);
        return teacher;
    }

}
