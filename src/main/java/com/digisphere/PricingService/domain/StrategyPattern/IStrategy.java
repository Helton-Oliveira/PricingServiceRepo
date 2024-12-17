package com.digisphere.PricingService.domain.StrategyPattern;

import java.util.Map;

public interface IStrategy {
    String executeStrategy(Map<String, Object> data);
}
