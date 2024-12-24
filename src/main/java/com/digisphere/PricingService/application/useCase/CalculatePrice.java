package com.digisphere.PricingService.application.useCase;

import com.digisphere.PricingService.application.domain.templateMethod.IPriceCalculator;
import com.digisphere.PricingService.infra.IRepository;

import java.util.Map;

public class CalculatePrice implements IUseCase {
    private final IPriceCalculator priceCalculator;
    private final IRepository repository;

    public CalculatePrice(IPriceCalculator priceCalculator, IRepository repository) {
        this.priceCalculator = priceCalculator;
        this.repository = repository;
    }

    @Override
    public String execute(Map<String, String> req) {
        Double pricePerMeter = repository.get(req.get("material"));
        req.put("pricePerMeter" , String.valueOf(pricePerMeter));
        String price =  String.valueOf(priceCalculator.calculate(req));
        return "R$ " + price.replace(".", ",");
    }
}
