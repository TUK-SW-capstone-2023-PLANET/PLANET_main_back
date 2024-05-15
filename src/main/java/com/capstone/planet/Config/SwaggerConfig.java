package com.capstone.planet.Config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig{

    private static final String SERVICE_NAME = "Planet Project";
    private static final String version = "v1.0.0";
    private static final String API_DESCRIPTION = "Planet Backend API";
    private static final String server = "Planet Main Backend Server check";
    private static final String github = "GitHub Organization Link";
    private static final String githubUrl = "https://github.com/TUK-SW-capstone-2023-PLANET/PLANET_main_back";
    private static final String API_URL = "http://54.180.102.87:8080/";

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info().title(SERVICE_NAME)
                        .description(API_DESCRIPTION)
                        .version(version)
                        .license(new License().name(server).url(API_URL)))
                .externalDocs(new ExternalDocumentation()
                        .description(github)
                        .url(githubUrl));
    }
}
