package com.digisphere.PricingService.application;

import java.util.Map;

public interface IEstimatePrice {
    String execute(Map<String, Object> reqData);
}
