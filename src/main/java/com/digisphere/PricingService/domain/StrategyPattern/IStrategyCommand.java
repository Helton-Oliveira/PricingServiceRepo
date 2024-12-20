package com.digisphere.PricingService.domain.StrategyPattern;

import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;

public interface IStrategyCommand {
    String executeStrategy(FurnitureOrderAggregate data);
}
