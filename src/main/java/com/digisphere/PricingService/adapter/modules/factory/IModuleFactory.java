package com.digisphere.PricingService.adapter.modules.factory;

import com.digisphere.PricingService.adapter.modules.products.IPricingModule;

import java.util.Map;

public interface IModuleFactory {
    IPricingModule createModule(Map<String, Object> request);
}
