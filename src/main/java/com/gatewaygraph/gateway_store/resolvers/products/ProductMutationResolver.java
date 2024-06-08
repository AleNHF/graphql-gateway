package com.gatewaygraph.gateway_store.resolvers.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gatewaygraph.gateway_store.models.products.Product;
import com.gatewaygraph.gateway_store.services.products.ProductService;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class ProductMutationResolver implements GraphQLMutationResolver {
    
    @Autowired
    private ProductService productService;

    public ProductMutationResolver(ProductService productService) {
        this.productService = productService;
    }

    public Product createProduct(String input) throws JsonProcessingException {
        return productService.createProduct(input);
    }

    public Object updateProduct(String productId, String input) throws JsonProcessingException {
        System.out.println("Request: "+input+" Id: "+productId);
        return productService.updateProduct(productId, input);
    }

    public boolean deleteProduct(String id) {
        return productService.deleteProduct(id);
    }
}
