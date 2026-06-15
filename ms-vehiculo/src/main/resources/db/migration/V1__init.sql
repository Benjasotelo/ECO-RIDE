CREATE TABLE vehiculos (
                           id BIGINT PRIMARY KEY AUTO_INCREMENT,
                           placa VARCHAR(20) NOT NULL,
                           tipo VARCHAR(50) NOT NULL,
                           modelo VARCHAR(100),
                           estado VARCHAR(20),
                           nivel_bateria DOUBLE
);
INSERT INTO vehiculos (placa, tipo, modelo, estado, nivel_bateria)
VALUES ('ABC-123', 'AUTO', 'Sedan Electric', 'DISPONIBLE', 100.0);