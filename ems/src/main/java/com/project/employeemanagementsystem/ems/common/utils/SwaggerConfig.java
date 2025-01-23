package com.project.employeemanagementsystem.ems.common.utils;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(description = "API FOR EMPLOYEE MANAGEMENT SYSTEM", version = "1.0"),
        servers = @Server(url = "http://localhost:9595/ems", description = "LOCAL SERVER")
)
public class SwaggerConfig {
}
