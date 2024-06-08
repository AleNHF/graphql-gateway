package com.gatewaygraph.gateway_store.types;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UpdateSaleInput {
    @JsonProperty("date") 
    private String date;

    /* @JsonProperty("payment_type") 
    private String paymentType; */
    
    @JsonProperty("details") 
    private List<SaleDetailInput> details;

    public UpdateSaleInput() {

    }

    public UpdateSaleInput(String date, List<SaleDetailInput> details) {
        this.date = date;
        //this.paymentType = paymentType;
        this.details = details;
    }

    // Getters y setters
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /* public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    } */

    public List<SaleDetailInput> getDetails() {
        return details;
    }

    public void setDetails(List<SaleDetailInput> details) {
        this.details = details;
    }
}
