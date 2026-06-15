package com.ecoride.ms_vehiculo.config;

import com.ecoride.ms_vehiculo.model.Vehiculo;
import com.ecoride.ms_vehiculo.repository.VehiculoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(VehiculoRepository repository) {
        return args -> {
            log.info("MS-VEHICULO: Iniciando verificación de inventario de flota...");

            if (repository.count() == 0) {
                repository.save(new Vehiculo(null, "SCOOT-01", "SCOOTER", "EcoWheel v2", "DISPONIBLE", 100.0));
                repository.save(new Vehiculo(null, "BIKE-05", "BICICLETA", "Mountain Pro", "DISPONIBLE", 100.0));
                repository.save(new Vehiculo(null, "GHTY-88", "AUTO", "Tesla Model 3", "DISPONIBLE", 85.0));

                log.info("MS-VEHICULO: Flota inicial cargada (SCOOTER, BICICLETA y AUTO).");
            } else {
                log.info("MS-VEHICULO: Inventario de vehículos detectado, omitiendo inicialización.");
            }
        };
    }
}