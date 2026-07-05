package com.ecoride.ms_geolocalizacion.config;

import com.ecoride.ms_geolocalizacion.model.Ubicacion;
import com.ecoride.ms_geolocalizacion.repository.UbicacionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UbicacionRepository repository) {
        return args -> {
            log.info("MS-GEOLOCALIZACION: Verificando datos de posicionamiento...");

            if (repository.count() == 0) {

                repository.save(new Ubicacion(null, 1L, -33.4489, -70.6693, LocalDateTime.now()));

                log.info("MS-GEOLOCALIZACION: Coordenadas de prueba (Santiago) cargadas exitosamente.");
            } else {
                log.info("MS-GEOLOCALIZACION: La tabla de ubicaciones ya contiene datos.");
            }
        };
    }
}