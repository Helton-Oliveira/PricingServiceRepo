package com.digisphere.PricingService.application.useCase;

import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;
import com.digisphere.PricingService.domain.StrategyPattern.IStrategyCommand;
import com.digisphere.PricingService.infra.IRepository;

public class EstimateFurniturePrice implements IUseCase {
    private final IRepository repository;
    private final IStrategyCommand strategy;
    private final FurnitureOrderAggregate aggregate;

    public EstimateFurniturePrice(IRepository repository, IStrategyCommand strategy, FurnitureOrderAggregate aggregate) {
        this.repository = repository;
        this.strategy = strategy;
        this.aggregate = aggregate;
    }

    @Override
    public String execute() {
        Double price = repository.get(aggregate.getMaterial());
        aggregate.setMaterialPricePerMeter(price);
        return strategy.executeStrategy(aggregate);
    }
}
