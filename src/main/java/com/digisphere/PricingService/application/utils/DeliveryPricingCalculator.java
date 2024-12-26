package com.digisphere.PricingService.application.utils;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DeliveryPricingCalculator {
    private static final double MAX_MARKUP = 500.0;
    private static  final double ALPHA = 0.2;

    public static double calculateByDeliveryTime(LocalDate deliveryDate, double hourlyRate ,Integer estimatedHours) {
        long daysRemaining = Math.abs(ChronoUnit.DAYS.between(deliveryDate, LocalDate.now()));
        double baseCost = calculateBaseCost(estimatedHours, hourlyRate);
        double urgencyMarkup = calculateUrgencyMarkup(daysRemaining);

        return baseCost + urgencyMarkup;
    }

    private static double calculateUrgencyMarkup(long daysRemaining) {
        if (daysRemaining <= 0) {
            return MAX_MARKUP;
        }
        if (daysRemaining < 5) {
            return MAX_MARKUP * Math.exp(-ALPHA * daysRemaining);
        }
        return MAX_MARKUP / daysRemaining;
    }

    private static double calculateBaseCost(Integer estimatedHours, double hourlyRate) {
        return estimatedHours * hourlyRate;
    }
}
