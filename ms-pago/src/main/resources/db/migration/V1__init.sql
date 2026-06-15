CREATE TABLE pagos (
                       id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       usuario_id BIGINT NOT NULL,
                       monto DOUBLE NOT NULL,
                       metodo_pago VARCHAR(50),
                       estado VARCHAR(20),
                       fecha DATETIME
);

INSERT INTO pagos (usuario_id, monto, metodo_pago, estado, fecha)
VALUES (1, 5000.0, 'DEBITO', 'COMPLETADO', NOW());