package com.gatewaygraph.gateway_store.resolvers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gatewaygraph.gateway_store.models.users.Customer;
import com.gatewaygraph.gateway_store.models.users.Supplier;
import com.gatewaygraph.gateway_store.models.users.User;

import graphql.kickstart.tools.GraphQLMutationResolver;
import reactor.core.publisher.Mono;

@Component
public class UserMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String GRAPHQL_ENDPOINT = "http://3.143.218.65/graphql"; //"http://localhost:8080/graphql";

    // Métodos para User
    public Mono<User> createUser(String username, String email, String password) {
        String mutation = String.format(
                "mutation { createUser(username: \"%s\", email: \"%s\", password: \"%s\") { id username email } }",
                username, email, password);
        return sendMutation(mutation, User.class, "createUser");
    }

    public Mono<User> updateUser(String id, String username, String email, String password) {
        String mutation = String.format(
                "mutation { updateUser(id: \"%s\", username: \"%s\", email: \"%s\", password: \"%s\") { id username email } }",
                id, username, email, password);
        return sendMutation(mutation, User.class, "updateUser");
    }

    public Mono<Boolean> deleteUser(String id) {
        String mutation = String.format(
                "mutation { deleteUser(id: \"%s\") }", id);
        return sendMutation(mutation, Boolean.class, "deleteUser");
    }

    public Mono<String> loginUser(String username, String password) {
        String mutation = String.format(
                "mutation { loginUser(username: \"%s\", password: \"%s\") }", username, password);
        return sendMutation(mutation, String.class, "loginUser");
    }

    // Métodos para Customer
    public Mono<Customer> createCustomer(String name, String phone, String email) {
        String mutation = String.format(
                "mutation { createCustomer(name: \"%s\", phone: \"%s\", email: \"%s\") { id name phone email } }",
                name, phone, email);
        return sendMutation(mutation, Customer.class, "createCustomer");
    }

    public Mono<Customer> updateCustomer(String id, String name, String phone, String email) {
        String mutation = String.format(
                "mutation { updateCustomer(id: \"%s\", name: \"%s\", phone: \"%s\", email: \"%s\") { id name phone email } }",
                id, name, phone, email);
        return sendMutation(mutation, Customer.class, "updateCustomer");
    }

    public Mono<Boolean> deleteCustomer(String id) {
        String mutation = String.format(
                "mutation { deleteCustomer(id: \"%s\") }", id);
        return sendMutation(mutation, Boolean.class, "deleteCustomer");
    }

    // Métodos para Supplier
    public Mono<Supplier> createSupplier(String name, String email, String phone, String address) {
        String mutation = String.format(
                "mutation { createSupplier(name: \"%s\", email: \"%s\", phone: \"%s\", address: \"%s\") { id name email phone address } }",
                name, email, phone, address);
        return sendMutation(mutation, Supplier.class, "createSupplier");
    }

    public Mono<Supplier> updateSupplier(String id, String name, String email, String phone, String address) {
        String mutation = String.format(
                "mutation { updateSupplier(id: \"%s\", name: \"%s\", email: \"%s\", phone: \"%s\", address: \"%s\") { id name email phone address } }",
                id, name, email, phone, address);
        return sendMutation(mutation, Supplier.class, "updateSupplier");
    }

    public Mono<Boolean> deleteSupplier(String id) {
        String mutation = String.format(
                "mutation { deleteSupplier(id: \"%s\") }", id);
        return sendMutation(mutation, Boolean.class, "deleteSupplier");
    }

    private <T> Mono<T> sendMutation(String mutation, Class<T> responseType, String rootField) {
        String requestBody = String.format("{\"query\": \"%s\"}", mutation.replace("\"", "\\\""));

        return webClientBuilder.build()
                .post()
                .uri(GRAPHQL_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class)
                .flatMap(response -> {
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        JsonNode jsonNode = objectMapper.readTree(response);
                        JsonNode dataNode = jsonNode.get("data").get(rootField);
                        return Mono.justOrEmpty(objectMapper.treeToValue(dataNode, responseType));
                    } catch (Exception e) {
                        return Mono.error(e);
                    }
                });
    }
}