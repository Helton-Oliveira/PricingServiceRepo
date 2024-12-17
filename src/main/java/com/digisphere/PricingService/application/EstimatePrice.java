package com.digisphere.PricingService.application;

import com.digisphere.PricingService.domain.StrategyPattern.IStrategyCommand;
import com.digisphere.PricingService.infra.IRepository;

import java.util.Map;

public class EstimatePrice implements IEstimatePrice {
    private final IRepository repository;
    private final IStrategyCommand strategy;

    public EstimatePrice(IRepository repository, IStrategyCommand strategy) {
        this.repository = repository;
        this.strategy = strategy;
    }

    @Override
    public String execute(Map<String, Object> reqData) {
        Double price = repository.get(reqData.get("material").toString());
        reqData.put("materialPricePerMeter", price);
        return strategy.executeStrategy(reqData);
    }
}
