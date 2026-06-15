package com.ecoride.ms_perfiles.config;

import com.ecoride.ms_perfiles.model.Perfil;
import com.ecoride.ms_perfiles.repository.PerfilRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDate;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(PerfilRepository repository) {
        return args -> {
            log.info("MS-PERFILES: Verificando perfiles de usuario en el sistema...");

            if (repository.count() == 0) {
                repository.save(new Perfil(null, 1L, "Víctor", "Loaiza", "+56912345678", "LIC-V-123", LocalDate.of(1995, 1, 1)));
                repository.save(new Perfil(null, 2L, "Juan", "Conductor", "+56998877665", "LIC-J-999", LocalDate.of(1990, 5, 10)));

                log.info("MS-PERFILES: Base de datos de perfiles inicializada con los registros de prueba.");
            } else {
                log.info("MS-PERFILES: Se detectaron perfiles existentes, omitiendo inicialización.");
            }
        };
    }
}