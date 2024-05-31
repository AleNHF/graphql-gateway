package com.gatewaygraph.gateway_store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

import com.gatewaygraph.gateway_store.resolvers.UserMutationResolver;
import com.gatewaygraph.gateway_store.resolvers.UserResolver;

@Configuration
public class GraphQLConfig {

    @Bean
    RuntimeWiringConfigurer runtimeWiringConfigurer(UserResolver userResolver,
            UserMutationResolver userMutationResolver) {
        return wiringBuilder -> wiringBuilder
                .type("Query", typeWiring -> typeWiring
                        .dataFetcher("users", env -> userResolver.users())
                        .dataFetcher("user", env -> userResolver.user(env.getArgument("id")))
                        .dataFetcher("customers", env -> userResolver.customers())
                        .dataFetcher("customer", env -> userResolver.customer(env.getArgument("id")))
                        .dataFetcher("suppliers", env -> userResolver.suppliers())
                        .dataFetcher("supplier", env -> userResolver.supplier(env.getArgument("id"))))
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
                        .dataFetcher("deleteUser", env -> userMutationResolver.deleteUser(env.getArgument("id")))
                        .dataFetcher("loginUser", env -> userMutationResolver.loginUser(
                                env.getArgument("username"),
                                env.getArgument("password")))
                        .dataFetcher("createCustomer", env -> userMutationResolver.createCustomer(
                                env.getArgument("name"),
                                env.getArgument("phone"),
                                env.getArgument("email")))
                        .dataFetcher("updateCustomer", env -> userMutationResolver.updateCustomer(
                                env.getArgument("id"),
                                env.getArgument("name"),
                                env.getArgument("phone"),
                                env.getArgument("email")))
                        .dataFetcher("deleteCustomer",
                                env -> userMutationResolver.deleteCustomer(env.getArgument("id")))
                        .dataFetcher("createSupplier", env -> userMutationResolver.createSupplier(
                                env.getArgument("name"),
                                env.getArgument("email"),
                                env.getArgument("phone"),
                                env.getArgument("address")))
                        .dataFetcher("updateSupplier", env -> userMutationResolver.updateSupplier(
                                env.getArgument("id"),
                                env.getArgument("name"),
                                env.getArgument("email"),
                                env.getArgument("phone"),
                                env.getArgument("address")))
                        .dataFetcher("deleteSupplier",
                                env -> userMutationResolver.deleteSupplier(env.getArgument("id"))));
    }
}
