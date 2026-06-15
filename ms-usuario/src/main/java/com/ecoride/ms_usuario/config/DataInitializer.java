package com.ecoride.ms_usuario.config;

import com.ecoride.ms_usuario.model.Usuario;
import com.ecoride.ms_usuario.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j; // Import para Slf4j
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(UsuarioRepository repository) {
        return args -> {
            log.info("MS-USUARIO: Verificando integridad de la tabla de credenciales...");

            if (repository.count() == 0) {
                repository.save(new Usuario(null, "victor_admin", "victor@ecoride.cl", "12345", "ADMIN", true));
                repository.save(new Usuario(null, "benja_user", "benja@ecoride.cl", "12345", "PASAJERO", true));

                log.info("MS-USUARIO: Credenciales de administrador y usuario inicializadas correctamente.");
            } else {
                log.info("MS-USUARIO: Base de datos de usuarios ya poblada, saltando inicialización.");
            }
        };
    }
}