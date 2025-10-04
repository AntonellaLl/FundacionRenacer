-- ============================
-- TABLA: PACIENTE
-- ============================
SELECT * FROM Paciente;
SELECT * FROM Paciente WHERE Obra_Social = 'OSDE';
SELECT * FROM Paciente WHERE Diagnostico LIKE '%Depresión%';

-- ============================
-- TABLA: PROFESIONAL
-- ============================
SELECT * FROM Profesional;
SELECT * FROM Profesional WHERE Especialidad = 'Psicología';
SELECT * FROM Profesional WHERE Fecha_Nacimiento < '1990-01-01';

-- ============================
-- TABLA: CONSULTORIO
-- ============================
SELECT * FROM Consultorio;
SELECT * FROM Consultorio WHERE Horarios LIKE '%8:00%';

-- ============================
-- TABLA: SESION
-- ============================
SELECT * FROM Sesion;
SELECT * FROM Sesion WHERE Estado = 'Confirmada';
SELECT * FROM Sesion WHERE Profesional = 'Mariana Pérez';

-- ============================
-- TABLA: ADMISION
-- ============================
SELECT * FROM Admision;
SELECT * FROM Admision WHERE Nombre_Profesional = 'Carlos Rossi';
SELECT * FROM Admision WHERE Fecha = '2025-10-06';

-- ============================
-- TABLA: USUARIO
-- ============================
SELECT * FROM Usuario;
SELECT * FROM Usuario WHERE Nombre_Usuario = 'mariana';
SELECT * FROM Usuario WHERE Contraseña LIKE '%2025%';
