package com.digisphere.PricingService.adapter.adapterPattern;

import com.digisphere.PricingService.adapter.modules.factory.IModuleFactory;
import com.digisphere.PricingService.adapter.modules.products.IPricingModule;
import com.digisphere.PricingService.application.useCase.EstimateFurniturePrice;
import com.digisphere.PricingService.application.useCase.IUseCase;

import java.util.Map;

public class Adapter implements IAdapter {
    private final IModuleFactory moduleFactory;
    private IUseCase furnitureUseCase;

    public Adapter(IModuleFactory moduleFactory) {
        this.moduleFactory = moduleFactory;
    }

    public void setUseCase(IUseCase furnitureUseCase) {
        this.furnitureUseCase = furnitureUseCase;
    }

    @Override
    public String adapterRequest(Map<String, Object> request) {
        IPricingModule module = moduleFactory.createModule(request);
        setUseCase(new EstimateFurniturePrice(module));
        return furnitureUseCase.execute();
    }
}
