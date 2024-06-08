package com.gatewaygraph.gateway_store.resolvers.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gatewaygraph.gateway_store.models.sales.Refund;
import com.gatewaygraph.gateway_store.services.sales.RefundsService;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class RefundResolver implements GraphQLResolver<Refund> {

    @Autowired
    private RefundsService refundService;
    
    public List<Object> getAllRefunds() {
        return refundService.getAllRefunds();
    }
    
    public Object getRefundById(String refundId) {
        return refundService.getRefundById(refundId);
    }
}
