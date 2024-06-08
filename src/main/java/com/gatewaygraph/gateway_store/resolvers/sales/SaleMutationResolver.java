package com.gatewaygraph.gateway_store.resolvers.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gatewaygraph.gateway_store.models.sales.Sale;
import com.gatewaygraph.gateway_store.services.sales.SalesService;
import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class SaleMutationResolver implements GraphQLMutationResolver {

    @Autowired
    private SalesService salesService;

    public SaleMutationResolver(SalesService salesService) {
        this.salesService = salesService;
    }

    public Sale createSale(String input) throws JsonProcessingException {
        return salesService.createSale(input);
    }

    public Object updateSale(String saleId, String input) throws JsonProcessingException {
        return salesService.updateSale(saleId, input);
    }

    public boolean deleteSale(String id) {
        return salesService.deleteSale(id);
    }
}
