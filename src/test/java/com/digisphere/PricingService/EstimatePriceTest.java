package com.digisphere.PricingService;

import com.digisphere.PricingService.domain.StrategyPattern.IStrategyCommand;
import com.digisphere.PricingService.domain.StrategyPattern.StrategyCommand;
import com.digisphere.PricingService.application.EstimatePrice;
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
        var estimate = new EstimatePrice(repository, strategy);
        Map<String, Object> data = new HashMap<>();

        data.put("customerId", "12345");
        data.put("itemType", "furniture");
        data.put("material", "lightWood");
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


        String price = estimate.execute(data);

        assertThat(price).isNotNull();
        assertThat(price).isNotBlank();
    }
}
