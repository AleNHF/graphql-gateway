package com.gatewaygraph.gateway_store.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateProductInput {
    @JsonProperty("code") 
    private String code;

    @JsonProperty("name") 
    private String name;
    
    @JsonProperty("description") 
    private String description;

    @JsonProperty("price") 
    private double price;

    @JsonProperty("stock") 
    private Integer stock;

    @JsonProperty("image") 
    private String image;

    @JsonProperty("brand_id") 
    private Integer brandId;

    @JsonProperty("size_id") 
    private Integer sizeId;

    @JsonProperty("color_id") 
    private Integer colorId;

    @JsonProperty("model_id") 
    private Integer modelId;

    public UpdateProductInput() {
    }

    public UpdateProductInput(String code, String name, String description, double price, Integer stock, String image,
            Integer brandId, Integer sizeId, Integer colorId, Integer modelId) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.image = image;
        this.brandId = brandId;
        this.sizeId = sizeId;
        this.colorId = colorId;
        this.modelId = modelId;
    }
}
