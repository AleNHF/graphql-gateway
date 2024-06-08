package com.gatewaygraph.gateway_store.services.sales;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gatewaygraph.gateway_store.models.sales.Sale;

@Service
public class SalesService {
    
    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://4.203.105.3";
    //private final String BASE_URL = "http://127.0.0.1:8000";

    public List<Object> getAllSales() {
        String url = BASE_URL + "/sales";
        ResponseEntity<List<Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {}
        );
        
        return response.getBody();
    }

    public Object getSaleById(String saleId) {
        String endpoint = BASE_URL + "/sales/" + saleId;
        ResponseEntity<Object> response = restTemplate.getForEntity(endpoint, Object.class);

        return response.getBody();
    }

    public Sale createSale(String saleJson) {
        String url = BASE_URL + "/sales";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(saleJson, header);
        ResponseEntity<Sale> response = restTemplate.postForEntity(url, entity, Sale.class);

        return response.getBody();
    }

    public Object updateSale(String saleId, String sale) {
        String url = BASE_URL + "/sales/" + saleId;
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(sale, header);
        restTemplate.put(url, entity);

        return getSaleById(saleId);
    }

    public boolean deleteSale(String saleId) {
        String url = BASE_URL + "/sales/" + saleId;
        try {
            restTemplate.delete(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
