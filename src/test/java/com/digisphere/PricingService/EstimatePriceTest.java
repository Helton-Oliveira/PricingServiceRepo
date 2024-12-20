package com.digisphere.PricingService;

import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;
import com.digisphere.PricingService.domain.StrategyPattern.IStrategyCommand;
import com.digisphere.PricingService.domain.StrategyPattern.StrategyCommand;
import com.digisphere.PricingService.application.useCase.EstimateFurniturePrice;
import com.digisphere.PricingService.infra.FurnitureMaterialRepositoryInMemory;
import com.digisphere.PricingService.infra.IRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class EstimatePriceTest {

    @Test
    @DisplayName("Deve estimar o preco de uma mesa")
    void estimateTablePrice() {
        IRepository repository = new FurnitureMaterialRepositoryInMemory();
        IStrategyCommand strategy = new StrategyCommand();
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

        var aggregate = new FurnitureOrderAggregate(data);
        var estimate = new EstimateFurniturePrice(repository, strategy, aggregate);
        String price = estimate.execute();

        assertThat(price).isNotNull();
        assertThat(price).isNotBlank();
        assertThat(price).isEqualTo("728.4");
    }
}
