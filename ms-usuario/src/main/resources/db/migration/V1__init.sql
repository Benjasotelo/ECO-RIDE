-- Crear la tabla siguiendo la estructura de datos definida
CREATE TABLE usuarios (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          nombre_usuario VARCHAR(50) NOT NULL UNIQUE,
                          correo_electronico VARCHAR(100) NOT NULL UNIQUE,
                          contrasena VARCHAR(255) NOT NULL,
                          rol VARCHAR(20) NOT NULL, -- ADMIN, CONDUCTOR, PASAJERO
                          activo BOOLEAN DEFAULT TRUE
);

-- Cargar datos iniciales
INSERT INTO usuarios (nombre_usuario, correo_electronico, contrasena, rol, activo)
VALUES ('admin_victor', 'victor@ecoride.cl', 'admin123', 'ADMIN', true),
       ('conductor_pedro', 'pedro@ecoride.cl', 'cond123', 'CONDUCTOR', true),
       ('pasajero_lucia', 'lucia@gmail.com', 'pasaj123', 'PASAJERO', true);