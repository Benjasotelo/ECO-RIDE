CREATE TABLE notificaciones (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                usuario_id BIGINT NOT NULL,
                                mensaje TEXT NOT NULL,
                                tipo VARCHAR(20),
                                estado VARCHAR(20),
                                fecha_envio DATETIME
);