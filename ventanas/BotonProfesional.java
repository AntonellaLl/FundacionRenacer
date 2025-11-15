package ventanas;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del módulo de Profesionales.
 * Funciona como un menú donde el usuario puede registrar,
 * modificar, eliminar o listar profesionales del sistema.
 */
public class BotonProfesional extends JFrame {

    public BotonProfesional() {

        // Configuración básica de la ventana
        setTitle("Gestión de Profesional");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        setLayout(new GridLayout(4, 1, 10, 10)); // Distribución vertical de los botones

        // --- Botones del menú de acciones ---

        // Abre el formulario para registrar un nuevo profesional
        JButton btnRegistrar = new JButton("Registrar Profesional");

        // Permite modificar los datos de un profesional existente
        JButton btnModificar = new JButton("Modificar Profesional");

        // Abre la ventana para eliminar un profesional del sistema
        JButton btnEliminar = new JButton("Eliminar Profesional");

        // Muestra una lista de todos los profesionales registrados
        JButton btnListar = new JButton("Listar Profesional");

        // Agregar botones a la interfaz
        add(btnRegistrar);
        add(btnModificar);
        add(btnEliminar);
        add(btnListar);

        // --- Acciones de los botones ---

        // Abre ventana de registro de profesional
        btnRegistrar.addActionListener(e -> new VentanaProfesional().setVisible(true));

        // Abre ventana para buscar y modificar un profesional
        btnModificar.addActionListener(e -> new ModificarProfesional().setVisible(true));

        // Abre ventana para eliminar profesionales
        btnEliminar.addActionListener(e -> new EliminarProfesional().setVisible(true));

        // Abre ventana que lista todos los profesionales registrados
        btnListar.addActionListener(e -> new ConsultaProfesional().setVisible(true));
    }
}
