CREATE TABLE precios (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         tipo_vehiculo VARCHAR(50) NOT NULL,
                         valor_base DOUBLE NOT NULL,
                         valor_por_kilometro DOUBLE NOT NULL
);

INSERT INTO precios (tipo_vehiculo, valor_base, valor_por_kilometro)
VALUES ('SCOOTER', 500.0, 100.0),
       ('BICICLETA', 300.0, 50.0),
       ('AUTO', 1000.0, 250.0);