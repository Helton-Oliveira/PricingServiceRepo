package com.digisphere.PricingService;

import com.digisphere.PricingService.application.domain.templateMethod.IPriceCalculator;
import com.digisphere.PricingService.application.domain.templateMethod.PriceCalculator;
import com.digisphere.PricingService.application.useCase.CalculatePrice;
import com.digisphere.PricingService.infra.FurnitureMaterialRepositoryInMemory;
import com.digisphere.PricingService.infra.IRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class EstimatePriceTest {

    @Test
    @DisplayName("Deve estimar o preco de uma mesa")
    void estimateTablePrice() {
        IPriceCalculator priceCalculator = new PriceCalculator();
        IRepository repository = new FurnitureMaterialRepositoryInMemory();
        var calculator = new CalculatePrice(priceCalculator, repository);
        Map<String, String> data = new HashMap<>();

        data.put("costumerId", UUID.randomUUID().toString());
        data.put("itemCategory", "furniture");
        data.put("itemType", "table");
        data.put("material", "lightWood");
        data.put("length", "180.0");
        data.put("width", "90.0");
        data.put("height", "75.0");
        data.put("deliveryDate", "2024-12-30");
        data.put("additionalFeatures",  "iron feet, rounded corners");

        String price = calculator.execute(data);

        assertThat(price).isEqualTo("R$ 852,0");
    }
}
