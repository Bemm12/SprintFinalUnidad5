-- Eliminar la base de datos en caso de que ya exista
DROP DATABASE IF EXISTS prevencion_riesgos;

-- Eliminar el usuario en caso de que ya exista
DROP USER IF EXISTS 'usuarioejercicio'@'localhost';

-- Creación de la base de datos
CREATE DATABASE prevencion_riesgos;

-- Creación del usuario
CREATE USER 'usuarioejercicio'@'localhost' IDENTIFIED BY '1234'; 

-- Otorgando privilegios al usuario
GRANT SELECT, CREATE, DROP, ALTER, INSERT, UPDATE ON prevencion_riesgos.* TO 'usuarioejercicio'@'localhost'; 
FLUSH PRIVILEGES;

-- Uso de la base de datos
USE prevencion_riesgos;

-- Creación de las tablas
CREATE TABLE Usuarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  rut VARCHAR(12) NOT NULL,  -- Nuevo campo para RUT
  fecha_nacimiento DATE NOT NULL,  -- Nuevo campo para fecha de nacimiento
  sexo ENUM('M', 'F') NOT NULL,  -- Nuevo campo para sexo
  direccion VARCHAR(255) NOT NULL,  -- Nuevo campo para dirección
  tipo ENUM('CLIENTE', 'ADMINISTRATIVO', 'PROFESIONAL') NOT NULL
);

CREATE TABLE Capacitaciones (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  detalle TEXT
);

CREATE TABLE Visitas (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  fecha_visita DATE,
  detalle TEXT,
  profesional_id INT
);

CREATE TABLE Chequeos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  visita_id INT,
  detalle TEXT,
  estado ENUM('Pendiente', 'Completado')
);

CREATE TABLE Pagos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  monto DECIMAL(10,2),
  fecha_pago DATE
);

CREATE TABLE Asesorias (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(100) NOT NULL,
  detalle TEXT,
  profesional_id INT
);

CREATE TABLE Accidentes (
  id INT PRIMARY KEY AUTO_INCREMENT,
  cliente_id INT,
  fecha_accidente DATE,
  detalle TEXT
);

CREATE TABLE Asistentes (
  capacitacion_id INT,
  usuario_id INT
);

-- Insertando registros en la tabla Usuarios con todos los campos
INSERT INTO Usuarios (nombre, tipo, rut, fecha_nacimiento, sexo, direccion) VALUES 
('Camilo Benavides', 'PROFESIONAL', '12345678-9', '1985-03-15', 'M', 'Av. Libertador 1234'),
('Gerardo Valles', 'CLIENTE', '98765432-1', '1990-07-20', 'M', 'Calle de la Esperanza 456'),
('Javiera Lopez', 'ADMINISTRATIVO', '11223344-5', '1988-11-30', 'F', 'Paseo de la Reforma 789');


-- Insertando registros en la tabla Capacitaciones
INSERT INTO Capacitaciones (nombre, detalle) VALUES ('Capacitación de Seguridad', 'Detalles de la capacitación de seguridad.');
INSERT INTO Capacitaciones (nombre, detalle) VALUES ('Capacitación en Primeros Auxilios', 'Detalles de la capacitación en primeros auxilios.');
INSERT INTO Capacitaciones (nombre, detalle) VALUES ('Capacitación en Manejo de Equipos', 'Detalles de la capacitación en manejo de equipos.');

-- Insertando registros en la tabla Visitas
INSERT INTO Visitas (cliente_id, fecha_visita, detalle, profesional_id) VALUES (1, '2024-09-10', 'Visita de inspección', 1);
INSERT INTO Visitas (cliente_id, fecha_visita, detalle, profesional_id) VALUES (2, '2024-09-11', 'Visita de evaluación', 2);
INSERT INTO Visitas (cliente_id, fecha_visita, detalle, profesional_id) VALUES (3, '2024-09-12', 'Visita de seguimiento', 3);

-- Insertando registros en la tabla Chequeos
INSERT INTO Chequeos (visita_id, detalle, estado) VALUES (1, 'Chequeo de seguridad general', 'Pendiente');
INSERT INTO Chequeos (visita_id, detalle, estado) VALUES (2, 'Chequeo de equipos', 'Completado');
INSERT INTO Chequeos (visita_id, detalle, estado) VALUES (3, 'Chequeo de cumplimiento de normativas', 'Pendiente');

-- Insertando registros en la tabla Pagos
INSERT INTO Pagos (cliente_id, monto, fecha_pago) VALUES (1, 150.00, '2024-09-10');
INSERT INTO Pagos (cliente_id, monto, fecha_pago) VALUES (2, 200.00, '2024-09-11');
INSERT INTO Pagos (cliente_id, monto, fecha_pago) VALUES (3, 250.00, '2024-09-12');

-- Insertando registros en la tabla Asesorias
INSERT INTO Asesorias (nombre, detalle, profesional_id) VALUES ('Asesoría en Seguridad', 'Asesoría en temas de seguridad.', 1);
INSERT INTO Asesorias (nombre, detalle, profesional_id) VALUES ('Asesoría en Gestión de Riesgos', 'Asesoría en gestión de riesgos.', 2);
INSERT INTO Asesorias (nombre, detalle, profesional_id) VALUES ('Asesoría en Salud Ocupacional', 'Asesoría en salud ocupacional.', 3);

-- Insertando registros en la tabla Accidentes
INSERT INTO Accidentes (cliente_id, fecha_accidente, detalle) VALUES (1, '2024-09-10', 'Accidente de trabajo leve.');
INSERT INTO Accidentes (cliente_id, fecha_accidente, detalle) VALUES (2, '2024-09-11', 'Accidente con equipo.');
INSERT INTO Accidentes (cliente_id, fecha_accidente, detalle) VALUES (3, '2024-09-12', 'Accidente en área de producción.');

-- Insertando registros en la tabla Asistentes
INSERT INTO Asistentes (capacitacion_id, usuario_id) VALUES (1, 1);
INSERT INTO Asistentes (capacitacion_id, usuario_id) VALUES (2, 2);
INSERT INTO Asistentes (capacitacion_id, usuario_id) VALUES (3, 3);