CREATE TABLE perfiles (
                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                          usuario_id BIGINT NOT NULL,
                          nombre VARCHAR(100),
                          apellido VARCHAR(100),
                          telefono VARCHAR(20),
                          numero_licencia VARCHAR(50),
                          fecha_nacimiento DATE
);

INSERT INTO perfiles (usuario_id, nombre, apellido, numero_licencia, fecha_nacimiento)
VALUES (1, 'Víctor', 'Loaiza', 'LIC-12345', '1995-01-01'),
       (2, 'Pedro', 'Conductor', 'LIC-99887', '1990-05-10');