-- ============================
-- TABLA: PACIENTE
-- ============================
INSERT INTO Paciente (Nombre, Apellido, DNI, Fecha_Nacimiento, Obra_Social, Diagnostico)
VALUES 
('Lucía', 'Gómez', '40123456', '1995-07-14', 'OSDE', 'Ansiedad generalizada'),
('Juan', 'López', '39222444', '1990-03-22', 'Swiss Medical', 'Estrés laboral'),
('María', 'Fernández', '42345678', '1998-09-10', 'Galeno', 'Depresión leve'),
('Sofía', 'Martínez', '41567234', '1996-05-05', 'OSDE', 'Trastorno del sueño');

-- ============================
-- TABLA: PROFESIONAL
-- ============================
INSERT INTO Profesional (Nombre, Apellido, Matricula, Especialidad, DNI, Fecha_Nacimiento)
VALUES
('Mariana', 'Pérez', 'MP1234', 'Psicología', '30111222', '1988-02-10'),
('Carlos', 'Rossi', 'MP5678', 'Psiquiatría', '28555999', '1980-11-23'),
('Laura', 'García', 'MP9101', 'Terapia Ocupacional', '31222111', '1992-08-30');

-- ============================
-- TABLA: CONSULTORIO
-- ============================
INSERT INTO Consultorio (Numero, Horarios)
VALUES
('101', 'Lunes a Viernes de 9:00 a 17:00'),
('102', 'Lunes, Miércoles y Viernes de 8:00 a 14:00'),
('103', 'Martes y Jueves de 10:00 a 18:00');

-- ============================
-- TABLA: SESION
-- ============================
INSERT INTO Sesion (Fecha, Hora, Paciente, Profesional, Consultorio, Estado)
VALUES
('2025-10-10', '14:00:00', 'Lucía Gómez', 'Mariana Pérez', '101', 'Confirmada'),
('2025-10-11', '15:30:00', 'Juan López', 'Carlos Rossi', '102', 'Pendiente'),
('2025-10-12', '09:00:00', 'María Fernández', 'Laura García', '103', 'Cancelada');

-- ============================
-- TABLA: ADMISION
-- ============================
INSERT INTO Admision (Nombre_Profesional, Nombre_Potencial_Paciente, Fecha, Hora)
VALUES
('Mariana Pérez', 'Ana Torres', '2025-10-04', '10:30:00'),
('Carlos Rossi', 'Pedro Díaz', '2025-10-05', '11:00:00'),
('Laura García', 'Camila Suárez', '2025-10-06', '09:15:00');

-- ============================
-- TABLA: USUARIO
-- ============================
INSERT INTO Usuario (Nombre_Usuario, Contraseña)
VALUES
('admin', '12345'),
('mariana', 'psico2025'),
('carlos', 'psi2025'),
('laura', 'to2025');
