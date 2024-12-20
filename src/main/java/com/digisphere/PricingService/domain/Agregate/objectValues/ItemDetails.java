package com.digisphere.PricingService.domain.Agregate.objectValues;

import java.util.Map;

public class ItemDetails {
    private final String name;
    private final Map<String, Double> dimensions;

    public ItemDetails( Map<String, Object> data) {
        this.name = data.get("name").toString();
        this.dimensions = (Map<String, Double>) data.get("dimensions");
    }

    public String getName() {
        return name;
    }

    public Map<String, Double> getDimensions() {
        return dimensions;
    }
}
