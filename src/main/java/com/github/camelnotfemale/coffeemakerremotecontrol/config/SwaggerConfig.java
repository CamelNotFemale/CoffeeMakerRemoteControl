package com.github.camelnotfemale.coffeemakerremotecontrol.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicRestApi() {
        return GroupedOpenApi.builder()
                .group("CoffeeMaker")
                .pathsToMatch("/coffee-maker/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(@Value("${application-description}")String appDescription,
                                 @Value("${application-version}")String appVersion) {
        return new OpenAPI().info(new Info().title("Coffee maker API")
                        .version(appVersion)
                        .description(appDescription)
                        .contact(new Contact().name("Dmitriy Dementev")
                                .email("d-1953@inbox.ru")))
                .servers(List.of(new Server().url("http://localhost:8080")
                                .description("Dev service")));
    }
}
