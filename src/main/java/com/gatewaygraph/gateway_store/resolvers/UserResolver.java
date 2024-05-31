package com.gatewaygraph.gateway_store.resolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.gatewaygraph.gateway_store.models.GraphQLResponse;
import com.gatewaygraph.gateway_store.models.GraphQLResponseWrapper;
import com.gatewaygraph.gateway_store.models.usersMicroservice.Customer;
import com.gatewaygraph.gateway_store.models.usersMicroservice.CustomerData;
import com.gatewaygraph.gateway_store.models.usersMicroservice.Supplier;
import com.gatewaygraph.gateway_store.models.usersMicroservice.SupplierData;
import com.gatewaygraph.gateway_store.models.usersMicroservice.User;
import com.gatewaygraph.gateway_store.models.usersMicroservice.UserData;

import graphql.kickstart.tools.GraphQLQueryResolver;
import reactor.core.publisher.Mono;

@Component
public class UserResolver implements GraphQLQueryResolver {

    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String GRAPHQL_ENDPOINT = "http://localhost:8080/graphql";

    public Mono<List<User>> users() {
        return fetchData("{ users { id username email } }",
                new ParameterizedTypeReference<GraphQLResponse<UserData>>() {
                })
                .map(response -> response.getData().getUsers());
    }

    public Mono<User> user(String id) {
        String query = "{ user(id: \"" + id + "\") { id username email } }";
        return fetchDataId(query, new ParameterizedTypeReference<GraphQLResponseWrapper<User>>() {
        })
                .map(wrapper -> wrapper.getData().get("user"));
    }

    public Mono<List<Customer>> customers() {
        return fetchData("{ customers { id name email phone } }",
                new ParameterizedTypeReference<GraphQLResponse<CustomerData>>() {
                })
                .map(response -> response.getData().getCustomers());
    }

    public Mono<Customer> customer(String id) {
        return fetchDataId("{ customer(id: \"" + id + "\") { id name email phone } }",
                new ParameterizedTypeReference<GraphQLResponseWrapper<Customer>>() {
                })
                .map(wrapper -> wrapper.getData().get("customer"));
    }

    public Mono<List<Supplier>> suppliers() {
        return fetchData("{ suppliers { id name email phone address } }",
                new ParameterizedTypeReference<GraphQLResponse<SupplierData>>() {
                })
                .map(response -> response.getData().getSuppliers());
    }

    public Mono<Supplier> supplier(String id) {
        return fetchDataId("{ supplier(id: \"" + id + "\") { id name email phone address } }",
                new ParameterizedTypeReference<GraphQLResponseWrapper<Supplier>>() {
                })
                .map(wrapper -> wrapper.getData().get("supplier"));
    }

    private <T> Mono<GraphQLResponse<T>> fetchData(String query,
            ParameterizedTypeReference<GraphQLResponse<T>> responseType) {
        String requestBody = String.format("{\"query\": \"%s\"}", query.replace("\"", "\\\""));

        return webClientBuilder.build()
                .post()
                .uri(GRAPHQL_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseType)
                .doOnNext(response -> System.out.println("Response: " + response))
                .doOnError(error -> System.err.println("Error: " + error.getMessage()));
    }

    private <T> Mono<GraphQLResponseWrapper<T>> fetchDataId(String query,
            ParameterizedTypeReference<GraphQLResponseWrapper<T>> responseType) {
        String requestBody = String.format("{\"query\": \"%s\"}", query.replace("\"", "\\\""));

        return webClientBuilder.build()
                .post()
                .uri(GRAPHQL_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseType)
                .doOnNext(response -> System.out.println("Response: " + response))
                .doOnError(error -> System.err.println("Error: " + error.getMessage()));
    }
}
