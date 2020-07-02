package com.example.appointmentapi.service.impl;

import com.example.appointmentapi.model.Pricing;
import com.example.appointmentapi.repo.PricingRepo;
import com.example.appointmentapi.service.PricingService;
import org.springframework.stereotype.Service;

@Service
public class PricingServiceImpl implements PricingService {

    private PricingRepo pricingRepo;

    public PricingServiceImpl(PricingRepo pricingRepo) {
        this.pricingRepo = pricingRepo;
    }

    @Override
    public Pricing addPricing(Pricing pricing) {
        pricingRepo.save(pricing);
        return pricing;
    }
}
