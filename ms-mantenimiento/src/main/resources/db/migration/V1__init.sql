CREATE TABLE mantenimientos (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                vehiculo_id BIGINT NOT NULL,
                                descripcion TEXT NOT NULL,
                                tecnico_responsable VARCHAR(100),
                                fecha_entrada DATETIME,
                                fecha_salida DATETIME,
                                estado VARCHAR(20)
);