package com.gatewaygraph.gateway_store.models.sales;

public class SaleDetail {
    private int quantity;
    private double price;
    private double total;
    private String productId;
    private String saleId;

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
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public String getSaleId() {
        return saleId;
    }
    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
}
