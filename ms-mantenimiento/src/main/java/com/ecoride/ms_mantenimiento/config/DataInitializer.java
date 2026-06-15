package com.ecoride.ms_mantenimiento.config;

import com.ecoride.ms_mantenimiento.model.Mantenimiento;
import com.ecoride.ms_mantenimiento.repository.MantenimientoRepository;
import lombok.extern.slf4j.Slf4j; // Import para Slf4j
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(MantenimientoRepository repository) {
        return args -> {
            log.info("MS-MANTENIMIENTO: Chequeando estado inicial de la base de datos...");

            if (repository.count() == 0) {
                repository.save(new Mantenimiento(null, 1L, "Revisión preventiva de frenos", "Juan Pérez", LocalDateTime.now(), null, "EN_REPARACION"));

                log.info("MS-MANTENIMIENTO: Registro de mantenimiento preventivo creado correctamente.");
            } else {
                log.info("MS-MANTENIMIENTO: Registros existentes detectados, omitiendo carga inicial.");
            }
        };
    }
}