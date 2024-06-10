package com.gatewaygraph.gateway_store.services.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PromotionService {
    
    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "https://microservicioproductos-production.up.railway.app/api/";

    public List<Object> getAllPromotions() {
        String url = BASE_URL + "promocion";
        ResponseEntity<List<Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {
                });

        return response.getBody();
    }

    public Object getPromotionById(String promId) {
        String endpoint = BASE_URL + "promocion/" + promId;
        ResponseEntity<Object> response = restTemplate.getForEntity(endpoint, Object.class);

        return response.getBody();
    }
}
