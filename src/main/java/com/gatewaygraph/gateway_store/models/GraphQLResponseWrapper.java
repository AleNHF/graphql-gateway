package com.gatewaygraph.gateway_store.models;

import java.util.Map;

public class GraphQLResponseWrapper<T> {
    private Map<String, T> data;

    public Map<String, T> getData() {
        return data;
    }

    public void setData(Map<String, T> data) {
        this.data = data;
    }
}