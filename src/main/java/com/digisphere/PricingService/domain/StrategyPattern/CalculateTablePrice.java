package com.digisphere.PricingService.domain.StrategyPattern;

import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CalculateTablePrice implements IStrategy {
    @Override
    public String executeStrategy(FurnitureOrderAggregate data) {
        Long deliveryPeriodInDays = ChronoUnit.DAYS.between(data.getDeliveryDate(), LocalDate.now());

        double pricePerMeter = data.getPricePerMeter();
        double lengthInMeter = data.getItemDetails().getDimensions().get("length") / 100;
        double widthInMeter = data.getItemDetails().getDimensions().get("width") / 100;
        double heightInMeter = data.getItemDetails().getDimensions().get("height") / 100;
        int featuresSize = data.getFurnitureDetails().getDetails().get("additionalFeature").split(",").length;

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
