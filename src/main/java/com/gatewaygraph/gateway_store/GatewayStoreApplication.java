package com.gatewaygraph.gateway_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayStoreApplication.class, args);

		/* WebClient client = WebClient.create("http://localhost:8080/graphql");

        // Create the JSON object for the GraphQL mutation
        String mutation = "mutation { createUser(username: \"serkanb\", email: \"serkanbolat@gmail.com\", password: \"123456789\") { id username email } }";
        String requestBody = String.format("{\"query\": \"%s\"}", mutation.replace("\"", "\\\""));
        System.out.println("Request Body: " + requestBody); // Log request body

        // Send the request
        Mono<String> response = client.post()
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(String.class);

        // Subscribe to the response
        response.subscribe(System.out::println, Throwable::printStackTrace); */
	}
}
