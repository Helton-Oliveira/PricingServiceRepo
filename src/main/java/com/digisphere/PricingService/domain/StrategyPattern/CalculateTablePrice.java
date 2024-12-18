package com.digisphere.PricingService.domain.StrategyPattern;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class CalculateTablePrice implements IStrategy {
    @Override
    public String executeStrategy(Map<String, Object> data) {
        Double pricePerMeter = (Double) (data.get("materialPricePerMeter"));
        Long deliveryPeriodInDays = ChronoUnit.DAYS.between(LocalDate.parse(data.get("deliveryDate").toString()), LocalDate.now());
        Map<String, Object> itemDetails = (Map<String, Object>) data.get("itemDetails");
        Map<String, Object> furnitureDetails = (Map<String, Object>) data.get("furnitureDetails");
        Map<String, Double> dimensions = (Map<String, Double>) itemDetails.get("dimensions");
        String additionalFeatures = (String) furnitureDetails.get("additionalFeatures");

        double lengthInMeter = dimensions.get("length") / 100;
        double widthInMeter = dimensions.get("width") / 100;
        double heightInMeter = dimensions.get("height") / 100;
        int featuresSize = additionalFeatures.split(",").length;

        double totalPriceWithDimensions = (lengthInMeter + widthInMeter + heightInMeter) * pricePerMeter; // 207
        double totalPriceWithDeliveryPeriod = calculateDelivery(deliveryPeriodInDays); // 300
        double totalPriceWithAdditionalFeatures = featuresSize * 50; // 100

        double total = (totalPriceWithDimensions + totalPriceWithDeliveryPeriod + totalPriceWithAdditionalFeatures) ;
        double totalWithSoftwareFeeInclude = total + (total * 0.20);
        return String.valueOf(totalWithSoftwareFeeInclude);
    }

    private Double calculateDelivery(Long periodInDays) {
        if(periodInDays <= 15){
            return 300.0;
        }
        if (periodInDays <= 30) {
            return 199.90;
        }
        return 150.0;
    }
}
