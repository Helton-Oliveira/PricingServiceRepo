package com.digisphere.PricingService.application.domain.especificMethods;

public class CalculateBookCasePrice implements ICalculator {

    @Override
    public Double profitMargin() {
        return 0.20;
    }

    @Override
    public Double hourlyRate() {
        return 40.0;
    }

    @Override
    public Integer estimatedHours() {
        return 1;
    }
}
