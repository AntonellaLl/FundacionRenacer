package ventanas;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana principal del módulo de Sesiones.
 * Permite acceder a las opciones para programar nuevas sesiones
 * o consultar las sesiones ya registradas.
 */
public class BotonSesion extends JFrame {

    public BotonSesion() {

        // Configuración general de la ventana
        setTitle("Gestión de Sesiones");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setLayout(new GridLayout(4, 1, 10, 10)); // Distribución vertical del menú

        // --- Botones del menú de acciones ---

        // Abre el formulario para programar una nueva sesión
        JButton btnRegistrar = new JButton("Programar Sesión");

        // Permite consultar sesiones ya registradas en el sistema
        JButton btnModificar = new JButton("Consultar Sesiones");

        // Agregar los botones a la interfaz
        add(btnRegistrar);
        add(btnModificar);

        // --- Acciones de los botones ---

        // Abre la ventana donde se pueden programar nuevas sesiones
        btnRegistrar.addActionListener(e -> new RegistroSesiones().setVisible(true));

        // Abre la ventana que lista y permite buscar sesiones registradas
        btnModificar.addActionListener(e -> new ConsultarSesiones().setVisible(true));
    }
}
