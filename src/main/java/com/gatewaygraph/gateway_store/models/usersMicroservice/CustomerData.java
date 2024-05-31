package com.gatewaygraph.gateway_store.models.usersMicroservice;

import java.util.List;

public class CustomerData {
    private List<Customer> customers;

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
