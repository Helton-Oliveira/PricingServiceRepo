package com.digisphere.PricingService.domain.Agregate.objectValues;

import java.util.HashMap;
import java.util.Map;

public class FurnitureDetails {
    private final Map<String, String> details = new HashMap<>();

    public FurnitureDetails(Map<String, Object> furnitureDetails) {
        details.put("additionalFeature", (String) furnitureDetails.get("additionalFeatures"));
    }

    public Map<String, String> getDetails() {
        return details;
    }
}
