package com.digisphere.PricingService.application.utils.mediatorPattern.mediator;

import com.digisphere.PricingService.application.utils.mediatorPattern.components.FurnitureSizeCalculator;

public interface ISizeCalculator {
    double calculate(FurnitureSizeCalculator component);
}
