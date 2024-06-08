package com.gatewaygraph.gateway_store.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateProductInput {
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

    public CreateProductInput() {
    }

    public CreateProductInput(String code, String name, String description, double price, Integer stock, String image,
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    
}
