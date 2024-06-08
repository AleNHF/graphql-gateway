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

import com.gatewaygraph.gateway_store.models.sales.Refund;

@Service
public class RefundsService {
    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://4.203.105.3";

    public List<Object> getAllRefunds() {
        String url = BASE_URL + "/refunds";
        ResponseEntity<List<Object>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Object>>() {}
        );
        
        return response.getBody();
    }

    public Object getRefundById(String refundId) {
        String url = BASE_URL + "/refunds/" + refundId;
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);
        return response.getBody();
    }

    public Refund createRefund(String refund) {
        String url = BASE_URL + "/refunds";
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(refund, header);
        ResponseEntity<Refund> response = restTemplate.postForEntity(url, entity, Refund.class);

        return response.getBody();
    }

    public Object updateRefund(String refundId, String refund) {
        String url = BASE_URL + "/refunds/" + refundId;
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(refund, header);
        restTemplate.put(url, entity);

        return getRefundById(refundId);
    }

    public boolean deleteRefund(String refundId) {
        String url = BASE_URL + "/refunds/" + refundId;
        try {
            restTemplate.delete(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
