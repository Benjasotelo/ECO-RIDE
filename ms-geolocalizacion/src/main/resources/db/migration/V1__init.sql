CREATE TABLE ubicaciones (
                             id BIGINT PRIMARY KEY AUTO_INCREMENT,
                             vehiculo_id BIGINT NOT NULL UNIQUE,
                             latitud DOUBLE NOT NULL,
                             longitud DOUBLE NOT NULL,
                             ultima_actualizacion DATETIME
);

-- Ejemplo inicial (Punto en Santiago)
INSERT INTO ubicaciones (vehiculo_id, latitud, longitud, ultima_actualizacion)
VALUES (1, -33.4489, -70.6693, NOW());