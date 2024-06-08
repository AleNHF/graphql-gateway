package com.gatewaygraph.gateway_store.resolvers.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gatewaygraph.gateway_store.models.sales.Refund;
import com.gatewaygraph.gateway_store.services.sales.RefundsService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class RefundMutationResolver implements GraphQLMutationResolver {
    
    @Autowired
    private RefundsService refundsService;

    public RefundMutationResolver(RefundsService refundsService) {
        this.refundsService = refundsService;
    }

    public Refund createRefund(String input) throws JsonProcessingException {
        return refundsService.createRefund(input);
    }

    public Object updateRefund(String refundId, String input) throws JsonProcessingException {
        return refundsService.updateRefund(refundId, input);
    }

    public boolean deleteRefund(String id) {
        return refundsService.deleteRefund(id);
    }
}
