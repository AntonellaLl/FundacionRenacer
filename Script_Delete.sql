-- ============================
-- TABLA: PACIENTE
-- ============================
DELETE FROM Paciente WHERE Id_Paciente = 1;
DELETE FROM Paciente WHERE Obra_Social = 'Galeno';

-- ============================
-- TABLA: PROFESIONAL
-- ============================
DELETE FROM Profesional WHERE Id_Profesional = 2;
DELETE FROM Profesional WHERE Especialidad = 'Psiquiatría';

-- ============================
-- TABLA: CONSULTORIO
-- ============================
DELETE FROM Consultorio WHERE Id_Consultorio = 3;
DELETE FROM Consultorio WHERE Numero = '102';

-- ============================
-- TABLA: SESION
-- ============================
DELETE FROM Sesion WHERE Id_Sesion = 1;
DELETE FROM Sesion WHERE Estado = 'Cancelada';

-- ============================
-- TABLA: ADMISION
-- ============================
DELETE FROM Admision WHERE Id_Admision = 2;
DELETE FROM Admision WHERE Nombre_Profesional = 'Laura García';

-- ============================
-- TABLA: USUARIO
-- ============================
DELETE FROM Usuario WHERE Id_Usuario = 3;
DELETE FROM Usuario WHERE Nombre_Usuario = 'laura';
