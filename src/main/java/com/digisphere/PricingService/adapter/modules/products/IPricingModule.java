package com.digisphere.PricingService.adapter.modules.products;

import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;
import com.digisphere.PricingService.infra.IRepository;

public interface IPricingModule {
    FurnitureOrderAggregate getRequestConverter();
    IRepository getRepository();
}
