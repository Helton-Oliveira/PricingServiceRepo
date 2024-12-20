package com.digisphere.PricingService.domain.StrategyPattern;

import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;

import java.util.HashMap;
import java.util.Map;

public class StrategyCommand implements IStrategyCommand {
    private final Map<String, IStrategy> strategy = new HashMap<>();

    private void setStrategies() {
        this.strategy.put("table", new CalculateTablePrice());
    }

    @Override
    public String executeStrategy(FurnitureOrderAggregate data) {
        setStrategies();
        return this.strategy.get(data.getItemDetails().getName()).executeStrategy(data);
    }

}
