package com.gatewaygraph.gateway_store.resolvers.purchases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gatewaygraph.gateway_store.models.purchases.Purchase;
import com.gatewaygraph.gateway_store.services.purchases.PurchaseService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class PurchaseMutationResolver implements GraphQLMutationResolver {
    
    @Autowired
    private PurchaseService purchaseService;

    public PurchaseMutationResolver(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    public Purchase createPurchase(String input) throws JsonProcessingException {
        return purchaseService.createPurchase(input);
    }

    public Object updatePurchase(String purchaseId, String input) throws JsonProcessingException {
        return purchaseService.updatePurchase(purchaseId, input);
    }

    public boolean deletePurchase(String id) {
        return purchaseService.deletePurchase(id);
    }
}
