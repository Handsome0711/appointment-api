package com.example.appointmentapi.repo;

import com.example.appointmentapi.model.Pricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PricingRepo extends JpaRepository<Pricing, Long> {
}
