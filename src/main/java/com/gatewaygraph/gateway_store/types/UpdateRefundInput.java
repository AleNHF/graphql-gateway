package com.gatewaygraph.gateway_store.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateRefundInput {
    @JsonProperty("date") 
    private String date;

    @JsonProperty("reason") 
    private String reason;

    @JsonProperty("quantity") 
    private Integer quantity;

    @JsonProperty("customer_id") 
    private Integer customer_id;

    public UpdateRefundInput() {
    }

    public UpdateRefundInput(String date, String reason, Integer quantity, Integer customer_id) {
        this.date = date;
        this.reason = reason;
        this.quantity = quantity;
        this.customer_id = customer_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    
}
