package com.digisphere.PricingService.application.domain.templateMethod;

import com.digisphere.PricingService.application.domain.especificMethods.CalculateTablePrice;
import com.digisphere.PricingService.application.domain.especificMethods.ICalculator;
import com.digisphere.PricingService.application.utils.DeliveryPricingCalculator;
import com.digisphere.PricingService.application.utils.simpleFactory.SizeCalculatorFactory;

import java.time.LocalDate;
import java.util.Map;

public class PriceCalculator implements IPriceCalculator {
    private ICalculator calculator;

    @Override
    public Double calculate(Map<String, String> data) {
        setCalculator(data.get("itemType"));
        Double profitMargin = calculator.profitMargin();
        Double pricePerHourWork = calculator.hourlyRate();
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

    private double calculateLabor(double hourlyRate, LocalDate deliveryDate) {
        return DeliveryPricingCalculator.calculateByDeliveryTime(deliveryDate, hourlyRate, calculator.estimatedHours());
    }

    private void setCalculator(String calculator) {
        switch (calculator.toLowerCase()) {
            case "table" -> this.calculator = new CalculateTablePrice();
        }
    }
}
