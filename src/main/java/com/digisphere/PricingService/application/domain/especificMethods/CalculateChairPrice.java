package com.digisphere.PricingService.application.domain.especificMethods;

public class CalculateChairPrice implements ICalculator {

    @Override
    public Double profitMargin() {
        return 0.50;
    }

    @Override
    public Double hourlyRate() {
        return 70.0;
    }

    @Override
    public Integer estimatedHours() {
        return 3;
    }
}
