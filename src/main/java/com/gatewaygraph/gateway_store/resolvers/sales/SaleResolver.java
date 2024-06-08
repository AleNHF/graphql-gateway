package com.gatewaygraph.gateway_store.resolvers.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gatewaygraph.gateway_store.models.sales.Sale;
import com.gatewaygraph.gateway_store.services.sales.SalesService;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class SaleResolver implements GraphQLResolver<Sale> {
    
    @Autowired
    private SalesService saleService;

    public List<Object> getAllSales() {
        return saleService.getAllSales();
    }

    public Object getSaleById(String saleId) {
        return saleService.getSaleById(saleId);
    }
}
