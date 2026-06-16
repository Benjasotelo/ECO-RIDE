package com.ecoride.ms_perfiles.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MS Perfiles - ECO-RIDE")
                        .version("1.0")
                        .description("API de gestión de perfiles de usuarios en la plataforma ECO-RIDE"));
    }
}