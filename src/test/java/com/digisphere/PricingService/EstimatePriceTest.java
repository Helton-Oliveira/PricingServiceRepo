package com.digisphere.PricingService;

import com.digisphere.PricingService.adapter.adapterPattern.Adapter;
import com.digisphere.PricingService.adapter.adapterPattern.IAdapter;
import com.digisphere.PricingService.adapter.modules.factory.FurnitureModuleFactory;
import com.digisphere.PricingService.adapter.modules.factory.IModuleFactory;
import com.digisphere.PricingService.adapter.modules.products.IPricingModule;
import com.digisphere.PricingService.application.useCase.EstimateFurniturePrice;
import com.digisphere.PricingService.application.useCase.IUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EstimatePriceTest {

    @Test
    @DisplayName("Deve estimar o preco de uma mesa")
    void estimateTablePrice() {
       ;
        Map<String, Object> data = new HashMap<>();

        data.put("customerId", "12345");
        data.put("itemType", "furniture");
        data.put("material", "lightWood");
        data.put("deliveryDate", "2024-12-27");
        data.put("itemDetails",
                Map.of(
                        "name", "table",
                        "dimensions", Map.of(
                                "length", 180.0,
                                "width", 90.0,
                                "height", 75.0)
                ));
        data.put("furnitureDetails", Map.of(
                "hasTop", true,
                "hasLegs", true,
                "numberOfShelves", 0,
                "additionalFeatures", "acabamento em verniz, bordas arredondadas"
        ));
        IPricingModule module = new FurnitureModuleFactory().createModule(data);
        IUseCase estimate = new EstimateFurniturePrice(module);
        var price = estimate.execute();

        assertThat(price).isNotNull();
        assertThat(price).isNotBlank();
        assertThat(price).isEqualTo("728.4");
    }
}
