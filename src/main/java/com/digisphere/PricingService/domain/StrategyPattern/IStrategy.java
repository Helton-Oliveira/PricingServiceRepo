package com.digisphere.PricingService.domain.StrategyPattern;

import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;

public interface IStrategy {
    String executeStrategy(FurnitureOrderAggregate data);
}
