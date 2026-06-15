package com.ecoride.ms_viaje.config;

import com.ecoride.ms_viaje.model.Viaje;
import com.ecoride.ms_viaje.repository.ViajeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(ViajeRepository repository) {
        return args -> {
            log.info("Verificando existencia de datos en ms-viaje...");

            if (repository.count() == 0) {
                repository.save(new Viaje(null, 1L, null, "Plaza de Armas", "Costanera Center", 5.5, 2750.0, "SOLICITADO", LocalDateTime.now(), "AUTO"));

                // Usamos log.info con el formato correcto
                log.info("Microservicio Viajes: Datos de prueba inicializados correctamente.");
            } else {
                log.info("Microservicio Viajes: La base de datos ya contiene registros.");
            }
        };
    }
}