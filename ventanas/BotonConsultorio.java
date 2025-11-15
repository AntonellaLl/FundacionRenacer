package ventanas;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del módulo de Consultorios.
 * Permite acceder a la opción de registrar un nuevo consultorio.
 */
public class BotonConsultorio extends JFrame {

    public BotonConsultorio() {

        // Configuración general de la ventana
        setTitle("Gestión de Consultorios");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new GridLayout(4, 1, 10, 10)); // Distribuye los elementos en columnas/filas

        // Botón para abrir la ventana de registro de consultorios
        JButton btnRegistrar = new JButton("Registrar Consultorio");

        // Se agrega el botón a la interfaz
        add(btnRegistrar);

        // --- Acciones del botón ---

        // Abre la ventana para registrar un consultorio nuevo
        btnRegistrar.addActionListener(e -> new RegistrarConsultorio().setVisible(true));
    }
}
