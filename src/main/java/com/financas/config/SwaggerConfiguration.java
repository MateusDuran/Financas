package com.financas.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("projetofinanceiro")
                .pathsToMatch("/**")
                .packagesToScan("com.finacas.resources")
                .build();
    }
    @Bean
    public OpenAPI customOpenAPI(){

        return new OpenAPI().info(new Info().title("Projeto Financeiro 2025")
                                            .description("Projeto Financeiro 2025")
                                            .version("1.0")
                                            .contact(new Contact().name("Curso Spring")
                                                                  .url("https://github.com/curso-spring/Curso-Spring")
                                                                  .email("curso@curso.com.br")))        .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components().addSecuritySchemes("bearerAuth",
                        new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")
                ));
    }
}
