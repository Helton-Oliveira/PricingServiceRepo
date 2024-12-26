package com.digisphere.PricingService.application.utils.simpleFactory;

import com.digisphere.PricingService.application.utils.mediatorPattern.components.FurnitureSizeCalculator;
import com.digisphere.PricingService.application.utils.mediatorPattern.components.IComponent;
import com.digisphere.PricingService.application.utils.mediatorPattern.mediator.SizeCalculator;

public class SizeCalculatorFactory {

    public static IComponent getComponent(String componentType) {
        switch (componentType.toLowerCase()) {
            case "furniture" -> {
                return  new FurnitureSizeCalculator(new SizeCalculator());
            }
            default -> throw new RuntimeException("");
        }

    }
}
