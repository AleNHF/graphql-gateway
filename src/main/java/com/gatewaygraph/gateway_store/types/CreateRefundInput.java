package com.gatewaygraph.gateway_store.types;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRefundInput {
    @JsonProperty("date") 
    private String date;

    @JsonProperty("reason") 
    private String reason;
    
    @JsonProperty("quantity") 
    private Integer quantity;

    @JsonProperty("customer_id") 
    private Integer customer_id;

    @JsonProperty("detail_sale_id") 
    private Integer detail_sale_id;

    public CreateRefundInput(String date, String reason, int quantity, int customer_id, int detail_sale_id) {
        this.date = date;
        this.reason = reason;
        this.quantity = quantity;
        this.customer_id = customer_id;
        this.detail_sale_id = detail_sale_id;
    }

    public CreateRefundInput() {
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getDetail_sale_id() {
        return detail_sale_id;
    }

    public void setDetail_sale_id(int detail_sale_id) {
        this.detail_sale_id = detail_sale_id;
    }
    
}
