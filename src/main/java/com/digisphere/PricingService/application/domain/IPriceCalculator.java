package com.digisphere.PricingService.application.domain;

import java.util.Map;

public interface IPriceCalculator {
    Double calculate(Map<String, String> data);
}
