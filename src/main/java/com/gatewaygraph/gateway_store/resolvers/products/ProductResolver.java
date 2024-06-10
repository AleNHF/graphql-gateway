package com.gatewaygraph.gateway_store.resolvers.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gatewaygraph.gateway_store.services.products.FeatureService;
import com.gatewaygraph.gateway_store.services.products.ProductService;
import com.gatewaygraph.gateway_store.services.products.PromotionService;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class ProductResolver implements GraphQLQueryResolver {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private FeatureService featureService;

    @Autowired
    private PromotionService promotionService;

    public List<Object> getAllProducts() {
        return productService.getAllProducts();
    }

    public Object getProductById(String productId) {
        return productService.getProductById(productId);
    }

    public List<Object> getAllBrands() {
        return featureService.getAllBrands();
    }

    public Object getBrandById(String brandId) {
        return featureService.getBrandById(brandId);
    }

    public List<Object> getAllColors() {
        return featureService.getAllColors();
    }

    public Object getColorById(String colorId) {
        return featureService.getColorById(colorId);
    }

    public List<Object> getAllSizes() {
        return featureService.getAllSizes();
    }

    public Object getSizeById(String sizeId) {
        return featureService.getSizeById(sizeId);
    }

    public List<Object> getAllModels() {
        return featureService.getAllModels();
    }

    public Object getModelById(String modelId) {
        return featureService.getModelById(modelId);
    }

    public List<Object> getAllPromotions() {
        return promotionService.getAllPromotions();
    }

    public Object getPromotionById(String promId) {
        return promotionService.getPromotionById(promId);
    }
}
