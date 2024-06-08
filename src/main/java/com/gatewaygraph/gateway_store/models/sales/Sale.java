package com.gatewaygraph.gateway_store.models.sales;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sale {
    private int id;

    private String date;

    private double total;

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("quantity_items")
    private int quantityItems;

    @JsonProperty("customer_id")
    private int customerId;

    @JsonProperty("user_id")
    private int userId;

    private List<SaleDetail> details;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getQuantityItems() {
        return quantityItems;
    }

    public void setQuantityItems(int quantityItems) {
        this.quantityItems = quantityItems;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<SaleDetail> getDetails() {
        return details;
    }

    public void setDetails(List<SaleDetail> details) {
        this.details = details;
    } 
}
