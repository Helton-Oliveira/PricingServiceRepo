package com.digisphere.PricingService.application.domain.templateMethod;

import java.util.Map;

public interface IPriceCalculator {
    Double calculate(Map<String, String> data);
}
