CREATE TABLE viajes (
                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        pasajero_id BIGINT NOT NULL,
                        conductor_id BIGINT,
                        origen VARCHAR(255) NOT NULL,
                        destino VARCHAR(255) NOT NULL,
                        distancia_km DOUBLE,
                        costo_total DOUBLE,
                        estado VARCHAR(50),
                        fecha_inicio DATETIME,
                        tipo_vehiculo VARCHAR(50)
);

-- Insertamos un dato inicial para probar
INSERT INTO viajes (pasajero_id, origen, destino, distancia_km, costo_total, estado, fecha_inicio, tipo_vehiculo)
VALUES (1, 'Plaza de Armas', 'Costanera Center', 5.5, 2750.0, 'SOLICITADO', NOW(), 'AUTO');