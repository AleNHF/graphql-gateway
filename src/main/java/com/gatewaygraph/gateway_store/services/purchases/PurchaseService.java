package com.gatewaygraph.gateway_store.services.purchases;

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

import com.gatewaygraph.gateway_store.models.purchases.Purchase;

@Service
public class PurchaseService {

    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "https://microservicioproductos-production.up.railway.app/api/compra/";

    public List<Object> getAllPurchases() {
        String url = BASE_URL;
        ResponseEntity<List<Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {
                });

        return response.getBody();
    }

    public Object getPurchaseById(String purchaseId) {
        String endpoint = BASE_URL + purchaseId + "/details";
        System.out.println("url: "+endpoint);
        ResponseEntity<Object> response = restTemplate.getForEntity(endpoint, Object.class);
        System.out.println("response body: "+response.getBody());

        return response.getBody();
    }

    public Purchase createPurchase(String purchaseJson) {
        String url = BASE_URL + "createwithdetails";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(purchaseJson, header);
        ResponseEntity<Purchase> response = restTemplate.postForEntity(url, entity, Purchase.class);

        return response.getBody();
    }

    public Object updatePurchase(String purchaseId, String purchaseJson) {
        String url = BASE_URL + purchaseId;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<>(purchaseJson, headers);

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

        return getPurchaseById(purchaseId);
    }

    public boolean deletePurchase(String purchaseId) {
        String url = BASE_URL + purchaseId;
        try {
            restTemplate.delete(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
