package com.example.appointmentapi.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teacher")
public class Teacher extends User {
    @OneToMany
    @UniqueElements
    private List<Pricing> pricing;

    public Teacher() {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.of("TEACHER"));
        super.setRoles(roles);
        pricing = new ArrayList<>();
    }

    public List<Pricing> getPricing() {
        return pricing;
    }

    public void setPricing(List<Pricing> pricing) {
        this.pricing = pricing;
    }
}
