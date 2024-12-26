package com.digisphere.PricingService.application.domain.especificMethods;

public class CalculateTablePrice implements ICalculator {

    @Override
    public Double profitMargin() {
        return 0.35;
    }

    @Override
    public Double hourlyRate() {
        return 50.0;
    }

    @Override
    public Integer estimatedHours() {
        return 2;
    }
}
