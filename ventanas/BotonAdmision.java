package ventanas;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del módulo de Admisiones.
 * Permite acceder a las opciones de registrar una nueva admisión
 * o consultar las admisiones ya existentes.
 */
public class BotonAdmision extends JFrame {

    public BotonAdmision() {

        // Configuración básica de la ventana
        setTitle("Gestión de Sesiones");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new GridLayout(4, 1, 10, 10)); // Distribuye los botones en forma vertical

        // Botón para abrir la ventana de registro de admisión
        JButton btnRegistrar = new JButton("Registrar Admisión");

        // Botón para abrir la ventana de consulta de admisiones
        JButton btnModificar = new JButton("Consultar Admisión");

        // Se agregan los botones a la interfaz
        add(btnRegistrar);
        add(btnModificar);

        // --- Acciones de los botones ---

        // Abre la ventana para registrar una nueva admisión
        btnRegistrar.addActionListener(e -> new RegistroAdmision().setVisible(true));

        // Abre la ventana para consultar o visualizar admisiones existentes
        btnModificar.addActionListener(e -> new ConsultarAdmisiones().setVisible(true));
    }
}
