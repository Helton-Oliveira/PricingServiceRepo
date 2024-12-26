package com.digisphere.PricingService.application.utils.mediatorPattern.components;

import java.util.Map;

public interface IComponent {
    double calculatePricePerMeterOfMaterial();
    void setMeasures(Map<String, String> data);
}
