package com.digisphere.PricingService.application.proxyPattern;

import com.digisphere.PricingService.application.useCase.EstimateFurniturePrice;
import com.digisphere.PricingService.application.useCase.IUseCase;
import com.digisphere.PricingService.domain.Agregate.FurnitureOrderAggregate;
import com.digisphere.PricingService.domain.StrategyPattern.StrategyCommand;
import com.digisphere.PricingService.infra.FurnitureMaterialRepositoryInMemory;

import java.util.Map;

public class EstimatePriceProxy implements IUseCase {
    private final Map<String, Object> req;
    private final IUseCase useCase;
    public EstimatePriceProxy(Map<String, Object> req, IUseCase useCase) {
        this.req = req;
        this.useCase = useCase;
    }

    @Override
    public String execute() {
        String itemType = req.get("itemType").toString();
        setUseCaseMap(req, itemType);
        return useCase.execute();
    }

    private void setUseCaseMap(Map<String, Object> reqData, String itemType) {
        switch (itemType.toLowerCase()) {
            case "furniture": {
                var furnitureAggregate = new FurnitureOrderAggregate(reqData);
                new EstimateFurniturePrice(new FurnitureMaterialRepositoryInMemory(), new StrategyCommand(), furnitureAggregate);
            }
        }
    }
}
