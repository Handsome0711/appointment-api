package com.example.appointmentapi.model.mappers;

import com.example.appointmentapi.model.Pricing;
import com.example.appointmentapi.model.dto.PricingRequestDto;
import org.springframework.stereotype.Component;

@Component
public class PricingRequestDtoMapper {
    public Pricing mapToPricing(PricingRequestDto pricingRequestDto) {
        Pricing pricing = new Pricing();
        pricing.setPrice(pricingRequestDto.getPrice());
        pricing.setTime(pricingRequestDto.getTime());
        return pricing;
    }
}
