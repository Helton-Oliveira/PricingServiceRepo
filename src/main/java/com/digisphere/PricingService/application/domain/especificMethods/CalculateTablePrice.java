package com.digisphere.PricingService.application.domain.especificMethods;

public class CalculateTablePrice implements ICalculator {

    @Override
    public Double profitMargin() {
        return 0.35;
    }

    @Override
    public Double pricePerHourWork() {
        return 50.0;
    }
}
