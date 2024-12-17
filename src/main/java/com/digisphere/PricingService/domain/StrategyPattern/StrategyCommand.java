package com.digisphere.PricingService.domain.StrategyPattern;

import java.util.HashMap;
import java.util.Map;

public class StrategyCommand implements IStrategyCommand {
    private final Map<String, IStrategy> strategy = new HashMap<>();

    private void setStrategy() {
        this.strategy.put("table", new CalculateTablePrice());
    }

    private String getStrategyName(Map<String, Object> data) {
        Map<String, Object> itemDetails = (Map<String, Object>) data.get("itemDetails");
       return itemDetails.get("name").toString();
    }

    @Override
    public String executeStrategy(Map<String, Object> data) {
        setStrategy();
        return this.strategy.get(getStrategyName(data)).executeStrategy(data);
    }

}
