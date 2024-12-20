package com.digisphere.PricingService.domain.Agregate;

import com.digisphere.PricingService.domain.Agregate.objectValues.FurnitureDetails;
import com.digisphere.PricingService.domain.Agregate.objectValues.ItemDetails;

import java.time.LocalDate;
import java.util.Map;

public class FurnitureOrderAggregate {
    private final String itemType;
    private final ItemDetails itemDetails;
    private final LocalDate deliveryDate;
    private final FurnitureDetails furnitureDetails;
    private Double pricePerMeter;
    private final String material;

    public FurnitureOrderAggregate(Map<String, Object> data) {
        this.itemType = data.get("itemType").toString();
        this.itemDetails = new ItemDetails((Map<String, Object>) data.get("itemDetails"));
        this.furnitureDetails = new FurnitureDetails((Map<String, Object>) data.get("furnitureDetails"));
        this.material = data.get("material").toString();
        this.deliveryDate = LocalDate.parse(data.get("deliveryDate").toString());
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getMaterial() {
        return material;
    }

    public String getItemType() {
        return itemType;
    }

    public void setMaterialPricePerMeter(Double price) {
        this.pricePerMeter = price;
    }

    public ItemDetails getItemDetails() {
        return itemDetails;
    }

    public FurnitureDetails getFurnitureDetails() {
        return furnitureDetails;
    }

    public Double getPricePerMeter() {
        return pricePerMeter;
    }
}
