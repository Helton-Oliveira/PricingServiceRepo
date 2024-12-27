package com.digisphere.PricingService.application.domain.templateMethod;

import com.digisphere.PricingService.application.domain.especificMethods.*;
import com.digisphere.PricingService.application.utils.deliveryPrincingCalculator.DeliveryPricingCalculator;
import com.digisphere.PricingService.application.utils.simpleFactory.SizeCalculatorFactory;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class PriceCalculator implements IPriceCalculator {
    private final Map <String, ICalculator> calculator = new HashMap<>();

    @Override
    public Double calculate(Map<String, String> data) {
        var calculator = getCalculator(data.get("itemType"));
        Double profitMargin = calculator.profitMargin();
        Double pricePerHourWork = calculator.hourlyRate();
        double total =
                calculatePriceMaterial(data) +
                calculatePriceOfAdditional(data.get("additionalFeatures")) +
                calculateLabor(pricePerHourWork, LocalDate.parse(data.get("deliveryDate")), calculator.estimatedHours());
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

    private double calculateLabor(double hourlyRate, LocalDate deliveryDate, Integer estimatedHours) {
        return DeliveryPricingCalculator.calculateByDeliveryTime(deliveryDate, hourlyRate, estimatedHours);
    }

    private ICalculator getCalculator(String calculatorName) {
        calculatorCollection();
        return calculator.get(calculatorName.toLowerCase());
    }

    private void calculatorCollection() {
        calculator.put("table", new CalculateTablePrice());
        calculator.put("chair", new CalculateChairPrice());
        calculator.put("cabinet", new CalculateCabinetPrice());
        calculator.put("bookcase", new CalculateBookCasePrice());
    }
}
