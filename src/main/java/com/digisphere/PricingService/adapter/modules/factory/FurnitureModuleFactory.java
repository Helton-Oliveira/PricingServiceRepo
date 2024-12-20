package com.digisphere.PricingService.adapter.modules.factory;

import com.digisphere.PricingService.adapter.modules.products.FurnitureModuleProduct;
import com.digisphere.PricingService.adapter.modules.products.IPricingModule;
import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;
import com.digisphere.PricingService.infra.FurnitureMaterialRepositoryInMemory;

import java.util.Map;

public class FurnitureModuleFactory implements IModuleFactory{

    @Override
    public IPricingModule createModule(Map<String, Object> request) {
        return new FurnitureModuleProduct(
                new FurnitureMaterialRepositoryInMemory(),
                new FurnitureOrderAggregate(request)
        );
    }
}
