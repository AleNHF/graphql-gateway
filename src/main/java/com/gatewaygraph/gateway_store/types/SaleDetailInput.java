package com.gatewaygraph.gateway_store.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SaleDetailInput {
    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("quantity")
    private int quantity;
    
    @JsonProperty("price")
    private double price;

    // Constructor
    public SaleDetailInput() {

    }

    public SaleDetailInput(int productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters y setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
