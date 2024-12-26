package com.digisphere.PricingService.application.domain.especificMethods;

public interface ICalculator {
    Double profitMargin();
    Double hourlyRate();
    Integer estimatedHours();
}
