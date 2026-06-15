package com.ecoride.ms_notificaciones.config;

import com.ecoride.ms_notificaciones.model.Notificacion;
import com.ecoride.ms_notificaciones.repository.NotificacionRepository;
import lombok.extern.slf4j.Slf4j; // Import para Slf4j
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(NotificacionRepository repository) {
        return args -> {
            log.info("MS-NOTIFICACIONES: Verificando historial de notificaciones...");

            if (repository.count() == 0) {
                repository.save(new Notificacion(null, 1L, "Bienvenido a ECO-RIDE", "CORREO", "ENVIADO", LocalDateTime.now()));

                log.info("MS-NOTIFICACIONES: Notificación de bienvenida inicializada con éxito.");
            } else {
                log.info("MS-NOTIFICACIONES: El repositorio ya contiene registros previos.");
            }
        };
    }
}