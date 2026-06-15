package com.ecoride.ms_calificaciones.config;

import com.ecoride.ms_calificaciones.model.Calificacion;
import com.ecoride.ms_calificaciones.repository.CalificacionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(CalificacionRepository repository) {
        return args -> {
            log.info("MS-CALIFICACIONES: Verificando registros existentes...");

            if (repository.count() == 0) {
                repository.save(new Calificacion(null, 100L, 1L, 2L, 5, "Excelente conductor, muy respetuoso.", LocalDateTime.now()));


                log.info("MS-CALIFICACIONES: Datos de prueba inicializados con éxito.");
            } else {
                log.info("MS-CALIFICACIONES: La base de datos ya cuenta con registros previos.");
            }
        };
    }
}