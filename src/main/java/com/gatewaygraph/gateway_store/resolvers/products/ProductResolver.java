package com.gatewaygraph.gateway_store.resolvers.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gatewaygraph.gateway_store.services.products.ProductService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class ProductResolver implements GraphQLQueryResolver {
    
    @Autowired
    private ProductService productService;

    public List<Object> getAllProducts() {
        return productService.getAllProducts();
    }

    public Object getProductById(String productId) {
        return productService.getProductById(productId);
    }
}
