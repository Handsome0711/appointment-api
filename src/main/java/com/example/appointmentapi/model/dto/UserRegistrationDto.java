package com.example.appointmentapi.model.dto;

import com.example.appointmentapi.annotation.EmailConstraint;
import com.example.appointmentapi.annotation.PasswordValueMatch;
import com.example.appointmentapi.model.Role;
import com.sun.istack.NotNull;
import javax.validation.constraints.Size;

@PasswordValueMatch
public class UserRegistrationDto {
    @NotNull
    @EmailConstraint
    private String email;
    @NotNull
    @Size(min = 8, max = 32)
    private String password;
    private String repeatPassword;
    @NotNull
    private Role.RoleName roleName;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public Role.RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(Role.RoleName roleName) {
        this.roleName = roleName;
    }
}
