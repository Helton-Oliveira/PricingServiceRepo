package com.digisphere.PricingService.domain.StrategyPattern;

import java.util.Map;

public class CalculateTablePrice implements IStrategy {
    @Override
    public String executeStrategy(Map<String, Object> data) {
        return "tudo certo";
    }
}
