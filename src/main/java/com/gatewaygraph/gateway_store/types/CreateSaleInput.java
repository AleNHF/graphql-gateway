package com.gatewaygraph.gateway_store.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateSaleInput {
    @JsonProperty("date") 
    private String date;

    @JsonProperty("payment_type") 
    private String paymentType;
    
    @JsonProperty("customer_id") 
    private int customerId;

    @JsonProperty("user_id") 
    private int userId;
    
    @JsonProperty("details") 
    private List<SaleDetailInput> details;

    public CreateSaleInput() {

    }

    public CreateSaleInput(String date, String paymentType, int customerId, int userId, List<SaleDetailInput> details) {
        this.date = date;
        this.paymentType = paymentType;
        this.customerId = customerId;
        this.userId = userId;
        this.details = details;
    }

    // Getters y setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
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

    public List<SaleDetailInput> getDetails() {
        return details;
    }

    public void setDetails(List<SaleDetailInput> details) {
        this.details = details;
    }
}
