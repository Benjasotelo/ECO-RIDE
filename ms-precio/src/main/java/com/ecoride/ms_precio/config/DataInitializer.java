package com.ecoride.ms_precio.config;

import com.ecoride.ms_precio.model.Precio;
import com.ecoride.ms_precio.repository.PrecioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(PrecioRepository repository) {
        return args -> {
            log.info("MS-PRECIO: Cargando configuraciones tarifarias...");

            if (repository.count() == 0) {
                repository.save(new Precio(null, "SCOOTER", 500.0, 100.0));
                repository.save(new Precio(null, "BICICLETA", 300.0, 50.0));
                repository.save(new Precio(null, "AUTO", 1000.0, 250.0));

                log.info("MS-PRECIO: Tarifas de SCOOTER, BICICLETA y AUTO inicializadas con éxito.");
            } else {
                log.info("MS-PRECIO: Las configuraciones de precios ya existen en la base de datos.");
            }
        };
    }
}