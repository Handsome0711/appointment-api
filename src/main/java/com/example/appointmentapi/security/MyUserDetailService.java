package com.example.appointmentapi.security;

import com.example.appointmentapi.model.User;
import com.example.appointmentapi.service.UserService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    private UserService userService;

    public MyUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        User user = userService.findByEmail(email);
        UserBuilder userBuilder;
        if (user != null) {
            userBuilder = org.springframework.security.core.userdetails
                    .User.withUsername(email);
            userBuilder.password(user.getPassword());
            userBuilder.roles(user.getRoles().stream()
                    .map(role -> role.getRoleName().name())
                    .toArray(String[]::new));
        } else {
            throw new UsernameNotFoundException("User with email: " + email + " not found");
        }
        return userBuilder.build();
    }
}
