package com.digisphere.PricingService.adapter.modules.products;

import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;
import com.digisphere.PricingService.infra.IRepository;

public class FurnitureModuleProduct implements IPricingModule {
    private final IRepository repository;
    private final FurnitureOrderAggregate aggregate;

    public FurnitureModuleProduct(IRepository repository, FurnitureOrderAggregate aggregate) {
        this.repository = repository;
        this.aggregate = aggregate;
    }

    @Override
    public FurnitureOrderAggregate getRequestConverter() {
        return aggregate;
    }

    @Override
    public IRepository getRepository() {
        return repository;
    }
}
