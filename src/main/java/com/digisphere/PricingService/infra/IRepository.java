package com.digisphere.PricingService.infra;

public interface IRepository {
    <T> T get(String materialName);
}
