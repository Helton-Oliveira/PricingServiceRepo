package com.digisphere.PricingService.domain.StrategyPattern;

import java.util.Map;

public interface IStrategyCommand {
    String executeStrategy(Map<String, Object> data);
}
