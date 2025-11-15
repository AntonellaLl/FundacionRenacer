package ventanas;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del módulo de Pacientes.
 * Permite acceder a las funciones de registrar, modificar,
 * eliminar y listar pacientes. Funciona como menú de navegación.
 */
public class BotonPaciente extends JFrame {

    public BotonPaciente() {

        // Configuración de la ventana
        setTitle("Gestión de Pacientes");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar la ventana
        setLayout(new GridLayout(4, 1, 10, 10)); // Distribución vertical

        // --- Botones del menú ---
        
        // Abre la ventana de registro de un nuevo paciente
        JButton btnRegistrar = new JButton("Registrar Paciente");

        // Permite buscar y modificar datos de un paciente existente
        JButton btnModificar = new JButton("Modificar Paciente");

        // Abre la ventana para eliminar pacientes registrados
        JButton btnEliminar = new JButton("Eliminar Paciente");

        // Muestra la lista de todos los pacientes almacenados
        JButton btnListar = new JButton("Listar Pacientes");

        // Agregar botones a la interfaz
        add(btnRegistrar);
        add(btnModificar);
        add(btnEliminar);
        add(btnListar);

        // --- Acciones de los botones ---

        // Abre el formulario para registrar un nuevo paciente
        btnRegistrar.addActionListener(e -> new VentanaPaciente().setVisible(true));

        // Permite buscar un paciente por DNI y luego modificarlo
        btnModificar.addActionListener(e -> new ActualizarPaciente().setVisible(true));

        // Abre la ventana para eliminar un paciente de la base de datos
        btnEliminar.addActionListener(e -> new EliminarPaciente().setVisible(true));

        // Muestra una ventana con la lista de todos los pacientes
        btnListar.addActionListener(e -> new VentanaConsulta().setVisible(true));
    }
}
