package com.digisphere.PricingService.application.utils.mediatorPattern.mediator;

import com.digisphere.PricingService.application.utils.mediatorPattern.components.FurnitureSizeCalculator;

public class SizeCalculator implements ISizeCalculator {

    @Override
    public double calculate(FurnitureSizeCalculator component) {
        return (component.getLength() + component.getWidth() + component.getHeight()) * component.getPricePerMeter();
    }
}
