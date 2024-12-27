package com.digisphere.PricingService.application.domain.especificMethods;

public class CalculateCabinetPrice implements ICalculator {

    @Override
    public Double profitMargin() {
        return 0.40;
    }

    @Override
    public Double hourlyRate() {
        return 70.0;
    }

    @Override
    public Integer estimatedHours() {
        return 4;
    }
}
