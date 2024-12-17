package com.digisphere.PricingService.infra;

import java.util.Map;

public class FurnitureMaterialRepositoryInMemory implements IRepository {
    private Map<String, Double> FAKE_DATABASE = Map.of(
            "lightWood", 60.0,
            "darkWood", 70.0,
            "wideGrainWood", 65.80,
            "embossedWood", 77.90,
            "plainGlass", 36.70,
            "sandBlastedGlass", 47.90
    );


    @Override
    public <T> T get(String materialName) {
        return (T) FAKE_DATABASE.get(materialName);
    }
}
