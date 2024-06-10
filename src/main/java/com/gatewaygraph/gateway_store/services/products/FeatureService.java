package com.gatewaygraph.gateway_store.services.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FeatureService {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "https://microservicioproductos-production.up.railway.app/api/";

    public List<Object> getAllBrands() {
        String url = BASE_URL + "brand";
        ResponseEntity<List<Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {
                });

        return response.getBody();
    }

    public Object getBrandById(String brandId) {
        String endpoint = BASE_URL + "brand/" + brandId;
        ResponseEntity<Object> response = restTemplate.getForEntity(endpoint, Object.class);

        return response.getBody();
    }

    public List<Object> getAllColors() {
        String url = BASE_URL + "colors";
        ResponseEntity<List<Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {
                });

        return response.getBody();
    }

    public Object getColorById(String colorId) {
        String endpoint = BASE_URL + "colors/" + colorId;
        ResponseEntity<Object> response = restTemplate.getForEntity(endpoint, Object.class);

        return response.getBody();
    }

    public List<Object> getAllSizes() {
        String url = BASE_URL + "size";
        ResponseEntity<List<Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {
                });

        return response.getBody();
    }

    public Object getSizeById(String sizeId) {
        String endpoint = BASE_URL + "size/" + sizeId;
        ResponseEntity<Object> response = restTemplate.getForEntity(endpoint, Object.class);

        return response.getBody();
    }
    
    public List<Object> getAllModels() {
        String url = BASE_URL + "models";
        ResponseEntity<List<Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {
                });

        return response.getBody();
    }

    public Object getModelById(String modelId) {
        String endpoint = BASE_URL + "models/" + modelId;
        ResponseEntity<Object> response = restTemplate.getForEntity(endpoint, Object.class);

        return response.getBody();
    }
}
