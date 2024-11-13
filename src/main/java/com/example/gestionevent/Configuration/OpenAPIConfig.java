package com.example.gestionevent.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("Gestion des events")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")
                .email("bahroun.yasmine@esprit.tn")
                .url("https://www.linkedin.com/in/**********/");
        return contact;
    }

    @Bean
    public GroupedOpenApi EventApi() {
        return GroupedOpenApi.builder()
                .group("Only Event API")
                .pathsToMatch("/api/events/**")
                .pathsToExclude("**")
                .build();


    }

    @Bean
    public GroupedOpenApi UserApi() {
        return GroupedOpenApi.builder()
                .group("Only User API")
                .pathsToMatch("/api/users/**")
                .pathsToExclude("**")
                .build();


    }

    @Bean
    public GroupedOpenApi AvisApi() {
        return GroupedOpenApi.builder()
                .group("Only Avis API")
                .pathsToMatch("/api/avis/**")
                .pathsToExclude("**")
                .build();


    }

    @Bean
    public GroupedOpenApi CategorieApi() {
        return GroupedOpenApi.builder()
                .group("Only Categorie API")
                .pathsToMatch("/api/categorieevents/**")
                .pathsToExclude("**")
                .build();


    }


}
