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

    @Test
    @DisplayName("Deve estimar o preco de uma cadeira")
    void estimateChairPrice() {
        IPriceCalculator priceCalculator = new PriceCalculator();
        IRepository repository = new FurnitureMaterialRepositoryInMemory();
        var calculator = new CalculatePrice(priceCalculator, repository);
        Map<String, String> data = new HashMap<>();

        data.put("costumerId", UUID.randomUUID().toString());
        data.put("itemCategory", "furniture");
        data.put("itemType", "chair");
        data.put("material", "lightWood");
        data.put("length", "50.0");
        data.put("width", "80.0");
        data.put("height", "75.0");
        data.put("deliveryDate", "2024-12-30");
        data.put("additionalFeatures",  "iron feet, piston, padded");

        String price = calculator.execute(data);

        assertThat(price).isEqualTo("R$ 1136,0");
    }
    @Test
    @DisplayName("Deve estimar o preco de uma armario")
    void estimateCabinetPrice() {
        IPriceCalculator priceCalculator = new PriceCalculator();
        IRepository repository = new FurnitureMaterialRepositoryInMemory();
        var calculator = new CalculatePrice(priceCalculator, repository);
        Map<String, String> data = new HashMap<>();

        data.put("costumerId", UUID.randomUUID().toString());
        data.put("itemCategory", "furniture");
        data.put("itemType", "cabinet");
        data.put("material", "lightWood");
        data.put("length", "75.0");
        data.put("width", "170.0");
        data.put("height", "240.0");
        data.put("deliveryDate", "2024-12-30");
        data.put("additionalFeatures",  "4 drawers, metalHandles");

        String price = calculator.execute(data);

        assertThat(price).isEqualTo("R$ 1323,0");
    }

    @Test
    @DisplayName("Deve estimar o preco de uma estante")
    void estimateBookCasePrice() {
        IPriceCalculator priceCalculator = new PriceCalculator();
        IRepository repository = new FurnitureMaterialRepositoryInMemory();
        var calculator = new CalculatePrice(priceCalculator, repository);
        Map<String, String> data = new HashMap<>();

        data.put("costumerId", UUID.randomUUID().toString());
        data.put("itemCategory", "furniture");
        data.put("itemType", "BookCase");
        data.put("material", "lightWood");
        data.put("length", "40.0");
        data.put("width", "50.0");
        data.put("height", "100.0");
        data.put("deliveryDate", "2024-12-30");
        data.put("additionalFeatures",  "metal Frame");

        String price = calculator.execute(data);

        assertThat(price).isEqualTo("R$ 574,0");
    }

}
