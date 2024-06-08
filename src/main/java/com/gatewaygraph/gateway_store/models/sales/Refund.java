package com.gatewaygraph.gateway_store.models.sales;

public class Refund {
    private String date;
    private String reason;
    private int quantity;
    private String customer_id;
    private SaleDetail detail_sale;

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

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public SaleDetail getDetail_sale() {
        return detail_sale;
    }

    public void setDetail_sale(SaleDetail detail_sale) {
        this.detail_sale = detail_sale;
    }
}
