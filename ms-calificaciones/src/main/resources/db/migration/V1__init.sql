CREATE TABLE calificaciones (
                                id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                viaje_id BIGINT NOT NULL,
                                emisor_id BIGINT NOT NULL,
                                receptor_id BIGINT NOT NULL,
                                estrellas INT NOT NULL,
                                comentario TEXT,
                                fecha DATETIME
);