package com.gatewaygraph.gateway_store.config;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gatewaygraph.gateway_store.resolvers.products.ProductMutationResolver;
import com.gatewaygraph.gateway_store.resolvers.products.ProductResolver;
import com.gatewaygraph.gateway_store.resolvers.sales.RefundMutationResolver;
import com.gatewaygraph.gateway_store.resolvers.sales.RefundResolver;
import com.gatewaygraph.gateway_store.resolvers.sales.SaleMutationResolver;
import com.gatewaygraph.gateway_store.resolvers.sales.SaleResolver;
import com.gatewaygraph.gateway_store.resolvers.users.UserMutationResolver;
import com.gatewaygraph.gateway_store.resolvers.users.UserResolver;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Configuration
public class GraphQLConfig {

        @Bean
        RuntimeWiringConfigurer runtimeWiringConfigurer(UserResolver userResolver,
                        UserMutationResolver userMutationResolver, SaleResolver saleResolver,
                        SaleMutationResolver saleMutationResolver, RefundResolver refundResolver,
                        RefundMutationResolver refundMutationResolver, ProductResolver productResolver,
                        ProductMutationResolver productMutationResolver) {
                return wiringBuilder -> wiringBuilder
                                .type("Query", typeWiring -> typeWiring
                                                .dataFetcher("users", env -> userResolver.users())
                                                .dataFetcher("user", env -> userResolver.user(env.getArgument("id")))
                                                .dataFetcher("customers", env -> userResolver.customers())
                                                .dataFetcher("customer",
                                                                env -> userResolver.customer(env.getArgument("id")))
                                                .dataFetcher("suppliers", env -> userResolver.suppliers())
                                                .dataFetcher("supplier",
                                                                env -> userResolver.supplier(env.getArgument("id")))
                                                .dataFetcher("sales", new DataFetcher<List<Object>>() {
                                                        @Override
                                                        public List<Object> get(DataFetchingEnvironment environment)
                                                                        throws Exception {
                                                                return saleResolver.getAllSales();
                                                        }
                                                })
                                                .dataFetcher("sale",
                                                                env -> saleResolver.getSaleById(env.getArgument("id")))
                                                .dataFetcher("refunds", new DataFetcher<List<Object>>() {
                                                        @Override
                                                        public List<Object> get(DataFetchingEnvironment environment)
                                                                        throws Exception {
                                                                return refundResolver.getAllRefunds();
                                                        }
                                                })
                                                .dataFetcher("refund",
                                                                env -> refundResolver
                                                                                .getRefundById(env.getArgument("id")))
                                                .dataFetcher("products", new DataFetcher<List<Object>>() {
                                                        @Override
                                                        public List<Object> get(DataFetchingEnvironment environment)
                                                                        throws Exception {
                                                                return productResolver.getAllProducts();
                                                        }
                                                })
                                                .dataFetcher("product",
                                                                env -> productResolver
                                                                                .getProductById(env.getArgument("id"))))
                                .type("Mutation", typeWiring -> typeWiring
                                                .dataFetcher("createUser", env -> userMutationResolver.createUser(
                                                                env.getArgument("username"),
                                                                env.getArgument("email"),
                                                                env.getArgument("password")))
                                                .dataFetcher("updateUser", env -> userMutationResolver.updateUser(
                                                                env.getArgument("id"),
                                                                env.getArgument("username"),
                                                                env.getArgument("email"),
                                                                env.getArgument("password")))
                                                .dataFetcher("deleteUser",
                                                                env -> userMutationResolver
                                                                                .deleteUser(env.getArgument("id")))
                                                .dataFetcher("loginUser", env -> userMutationResolver.loginUser(
                                                                env.getArgument("username"),
                                                                env.getArgument("password")))
                                                .dataFetcher("createCustomer",
                                                                env -> userMutationResolver.createCustomer(
                                                                                env.getArgument("name"),
                                                                                env.getArgument("phone"),
                                                                                env.getArgument("email")))
                                                .dataFetcher("updateCustomer",
                                                                env -> userMutationResolver.updateCustomer(
                                                                                env.getArgument("id"),
                                                                                env.getArgument("name"),
                                                                                env.getArgument("phone"),
                                                                                env.getArgument("email")))
                                                .dataFetcher("deleteCustomer",
                                                                env -> userMutationResolver
                                                                                .deleteCustomer(env.getArgument("id")))
                                                .dataFetcher("createSupplier",
                                                                env -> userMutationResolver.createSupplier(
                                                                                env.getArgument("name"),
                                                                                env.getArgument("email"),
                                                                                env.getArgument("phone"),
                                                                                env.getArgument("address")))
                                                .dataFetcher("updateSupplier",
                                                                env -> userMutationResolver.updateSupplier(
                                                                                env.getArgument("id"),
                                                                                env.getArgument("name"),
                                                                                env.getArgument("email"),
                                                                                env.getArgument("phone"),
                                                                                env.getArgument("address")))
                                                .dataFetcher("deleteSupplier",
                                                                env -> userMutationResolver.deleteSupplier(
                                                                                env.getArgument("id")))
                                                .dataFetcher("createSale", env -> {
                                                        Map<String, Object> inputMap = env.getArgument("input");
                                                        ObjectMapper objectMapper = new ObjectMapper();
                                                        JsonNode inputJsonNode = objectMapper.valueToTree(inputMap);
                                                        String jsonString = inputJsonNode.toString();
                                                        return saleMutationResolver.createSale(jsonString);
                                                })
                                                .dataFetcher("updateSale", env -> {
                                                        String saleId = env.getArgument("id");
                                                        Map<String, Object> inputMap = env.getArgument("input");
                                                        ObjectMapper objectMapper = new ObjectMapper();
                                                        JsonNode inputJsonNode = objectMapper.valueToTree(inputMap);
                                                        String jsonString = inputJsonNode.toString();
                                                        return saleMutationResolver.updateSale(saleId, jsonString);
                                                })
                                                .dataFetcher("deleteSale", env -> saleMutationResolver
                                                                .deleteSale(env.getArgument("id")))
                                                .dataFetcher("createRefund", env -> {
                                                        Map<String, Object> inputMap = env.getArgument("input");
                                                        ObjectMapper objectMapper = new ObjectMapper();
                                                        JsonNode inputJsonNode = objectMapper.valueToTree(inputMap);
                                                        String jsonString = inputJsonNode.toString();
                                                        return refundMutationResolver.createRefund(jsonString);
                                                })
                                                .dataFetcher("updateRefund", env -> {
                                                        String refundId = env.getArgument("id");
                                                        Map<String, Object> inputMap = env.getArgument("input");
                                                        ObjectMapper objectMapper = new ObjectMapper();
                                                        JsonNode inputJsonNode = objectMapper.valueToTree(inputMap);
                                                        String jsonString = inputJsonNode.toString();
                                                        return refundMutationResolver.updateRefund(refundId,
                                                                        jsonString);
                                                })
                                                .dataFetcher("deleteRefund", env -> refundMutationResolver
                                                                .deleteRefund(env.getArgument("id")))
                                                .dataFetcher("createProduct", env -> {
                                                        Map<String, Object> inputMap = env.getArgument("input");
                                                        ObjectMapper objectMapper = new ObjectMapper();
                                                        JsonNode inputJsonNode = objectMapper.valueToTree(inputMap);
                                                        String jsonString = inputJsonNode.toString();
                                                        return productMutationResolver.createProduct(jsonString);
                                                })
                                                .dataFetcher("updateProduct", env -> {
                                                        String productId = env.getArgument("id");
                                                        Map<String, Object> inputMap = env.getArgument("input");
                                                        ObjectMapper objectMapper = new ObjectMapper();
                                                        JsonNode inputJsonNode = objectMapper.valueToTree(inputMap);
                                                        String jsonString = inputJsonNode.toString();
                                                        return productMutationResolver.updateProduct(productId, jsonString);
                                                })
                                                .dataFetcher("deleteProduct", env -> productMutationResolver
                                                                .deleteProduct(env.getArgument("id"))));

        }
}
