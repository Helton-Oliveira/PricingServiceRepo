package com.digisphere.PricingService.application.domain.templateMethod;

import com.digisphere.PricingService.application.domain.especificMethods.CalculateTablePrice;
import com.digisphere.PricingService.application.domain.especificMethods.ICalculator;
import com.digisphere.PricingService.application.utils.simpleFactory.SizeCalculatorFactory;

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
        var component = SizeCalculatorFactory.getComponent(data.get("itemCategory"));
        component.setMeasures(data);
        return component.calculatePricePerMeterOfMaterial();
    }

    private double calculatePriceOfAdditional(String additional) {
        return additional.split(",").length * 50;
    }

    private double calculateLabor(double pricePerHour, LocalDate deliveryDate) {
        long deliveryPeriodInDays = ChronoUnit.DAYS.between(deliveryDate, LocalDate.now());
        return Math.abs(deliveryPeriodInDays) * pricePerHour;
    }

    private void setCalculator(String calculator) {
        switch (calculator.toLowerCase()) {
            case "table" -> this.calculator = new CalculateTablePrice();
        }
    }
}
