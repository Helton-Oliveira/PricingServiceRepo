package com.digisphere.PricingService.application.domain;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class PriceCalculator implements IPriceCalculator{
    private ICalculator calculator;

    @Override
    public Double calculate(Map<String, String> data) {
        setCalculator(data.get("itemType"));
        Double profitMargin = calculator.profitMargin();
        Double pricePerHourWork = calculator.pricePerHourWork();
        double total =
                calculatePriceMaterial(data) +
                calculatePriceOfAdditional(data.get("additionalFeatures")) +
                calculateLabor(pricePerHourWork, LocalDate.parse(data.get("deliveryDate")));
        return total + (total * profitMargin);
    }

    private double calculatePriceMaterial(Map<String, String> data) {
        double pricePerMeter = Double.parseDouble(data.get("pricePerMeter"));
        double lengthInMeter = Double.parseDouble(data.get("length")) / 100;
        double widthInMeter = Double.parseDouble(data.get("width")) / 100;
        double heightInMeter = Double.parseDouble(data.get("height")) / 100;
        return (lengthInMeter + widthInMeter + heightInMeter) * pricePerMeter; // 207
    }

    private double calculatePriceOfAdditional(String additional) {
        return additional.split(",").length * 50; // 100
    }

    private double calculateLabor(double pricePerHour, LocalDate deliveryDate) {
        long deliveryPeriodInDays = ChronoUnit.DAYS.between(deliveryDate, LocalDate.now());
        return Math.abs(deliveryPeriodInDays) * pricePerHour; //400
    }

    private void setCalculator(String calculator) {
        switch (calculator.toLowerCase()) {
            case "table" -> this.calculator = new CalculateTablePrice();
        }
    }
}
