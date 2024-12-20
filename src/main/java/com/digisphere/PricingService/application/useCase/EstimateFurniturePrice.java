package com.digisphere.PricingService.application.useCase;

import com.digisphere.PricingService.adapter.modules.products.IPricingModule;
import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;
import com.digisphere.PricingService.domain.StrategyPattern.IStrategyCommand;
import com.digisphere.PricingService.domain.StrategyPattern.StrategyCommand;
import com.digisphere.PricingService.infra.IRepository;

public class EstimateFurniturePrice implements IUseCase {
    private final IRepository repository;
    private final IStrategyCommand strategy;
    private final FurnitureOrderAggregate request;

    public EstimateFurniturePrice (IPricingModule module) {
        this.request = module.getRequestConverter();
        this.repository = module.getRepository();
        this.strategy = new StrategyCommand();
    }

    @Override
    public String execute() {
        Double price = repository.get(this.request.getMaterial());
        this.request.setMaterialPricePerMeter(price);
        return strategy.executeStrategy(this.request);
    }
}
