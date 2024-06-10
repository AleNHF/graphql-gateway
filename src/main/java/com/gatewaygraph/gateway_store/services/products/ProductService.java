package com.gatewaygraph.gateway_store.services.products;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.gatewaygraph.gateway_store.models.products.Product;

@Service
public class ProductService {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "https://microservicioproductos-production.up.railway.app/api/producto/";

    public List<Object> getAllProducts() {
        String url = BASE_URL + "ver";
        ResponseEntity<List<Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {
                });

        return response.getBody();
    }

    public Object getProductById(String productId) {
        String endpoint = BASE_URL + productId;
        ResponseEntity<Object> response = restTemplate.getForEntity(endpoint, Object.class);

        return response.getBody();
    }

    public Product createProduct(String productJson) {
        String url = BASE_URL + "crear";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(productJson, header);
        ResponseEntity<Product> response = restTemplate.postForEntity(url, entity, Product.class);

        return response.getBody();
    }

    public Object updateProduct(String productId, String productJson) {
        String url = BASE_URL + productId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(productJson, headers);

        try {
            restTemplate.put(url, entity);
        } catch (HttpClientErrorException e) {
            // Manejar y loguear errores
            System.err.println("Error occurred: " + e.getStatusCode());
            System.err.println("Response body: " + e.getResponseBodyAsString());
            // Puede lanzar una excepción o manejarla de otra manera
            throw e;
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            // Puede lanzar una excepción o manejarla de otra manera
            throw e;
        }

        return getProductById(productId);
    }

    public boolean deleteProduct(String productId) {
        String url = BASE_URL + productId;
        try {
            restTemplate.delete(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}