package com.example.appointmentapi.model.dto;

import java.math.BigDecimal;

public class PricingRequestDto {
    private int time;
    private BigDecimal price;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
