package com.gatewaygraph.gateway_store.models.products;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product {
    private int id;

    private String code;

    private String name;

    private String description;

    private int quantity;

    @JsonProperty("customer_id")
    private int customerId;

    @JsonProperty("detail_sale_id")
    private int detailSaleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getDetailSaleId() {
        return detailSaleId;
    }

    public void setDetailSaleId(int detailSaleId) {
        this.detailSaleId = detailSaleId;
    }
    
}
