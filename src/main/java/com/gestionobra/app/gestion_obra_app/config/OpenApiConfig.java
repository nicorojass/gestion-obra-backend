package com.gestionobra.app.gestion_obra_app.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Gestión de Obras API",
        version = "1.0",
        description = "Backend SaaS para obras, materiales y certificados de avance"
    )
)
public class OpenApiConfig {
}

