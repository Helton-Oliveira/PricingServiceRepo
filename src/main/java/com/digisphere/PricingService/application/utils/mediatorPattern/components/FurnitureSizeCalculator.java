package com.digisphere.PricingService.application.utils.mediatorPattern.components;

import com.digisphere.PricingService.application.utils.mediatorPattern.mediator.ISizeCalculator;

import java.util.Map;

public class FurnitureSizeCalculator implements IComponent {
    private final ISizeCalculator sizeCalculator;
    private double pricePerMeter;
    private double length;
    private double width;
    private double height;

    public FurnitureSizeCalculator(ISizeCalculator sizeCalculator) {
        this.sizeCalculator = sizeCalculator;
    }

    @Override
    public double calculatePricePerMeterOfMaterial() {
        return sizeCalculator.calculate(this);
    }

    @Override
    public void setMeasures(Map<String, String> data) {
        this.pricePerMeter = Double.parseDouble(data.get("pricePerMeter"));
        this.length = Double.parseDouble(data.get("length")) / 100;
        this.width = Double.parseDouble(data.get("width")) / 100;
        this.height = Double.parseDouble(data.get("height")) / 100;
    }

    public double getPricePerMeter() {
        return pricePerMeter;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
