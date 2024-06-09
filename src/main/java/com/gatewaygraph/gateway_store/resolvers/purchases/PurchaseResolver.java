package com.gatewaygraph.gateway_store.resolvers.purchases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gatewaygraph.gateway_store.services.purchases.PurchaseService;

import graphql.kickstart.tools.GraphQLResolver;

@SuppressWarnings("rawtypes")
@Component
public class PurchaseResolver implements GraphQLResolver {

    @Autowired
    private PurchaseService purchaseService;

    public List<Object> getAllPurchases() {
        return purchaseService.getAllPurchases();
    }

    public Object getPurchaseById(String purchaseId) {
        return purchaseService.getPurchaseById(purchaseId);
    }
}
