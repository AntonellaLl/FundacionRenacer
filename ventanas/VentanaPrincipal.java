package ventanas;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {

        // Título de la ventana principal del sistema
        setTitle("Gestión del Sistema");

        // Tamaño de la ventana
        setSize(500, 400);

        // Centra la ventana en pantalla
        setLocationRelativeTo(null);

        // Cierra la aplicación al tocar "X"
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // GridLayout con 5 filas y 1 columna
        setLayout(new GridLayout(5, 1, 10, 10));

        // ------ BOTONES PRINCIPALES DEL SISTEMA ------
        JButton btnPacientes = new JButton("Pacientes");
        JButton btnProfesional = new JButton("Profesional");
        JButton btnSesiones = new JButton("Sesiones");
        JButton btnAdmisiones = new JButton("Admisiones");
        JButton btnConsultorios = new JButton("Consultorios");

        // Agrega los botones al panel principal
        add(btnPacientes);
        add(btnProfesional);
        add(btnSesiones);
        add(btnAdmisiones);
        add(btnConsultorios);

        // ----- EVENTOS PARA ABRIR OTRAS VENTANAS -----

        // Cada botón abre una nueva ventana con sus opciones
        btnPacientes.addActionListener(e -> new BotonPaciente().setVisible(true));
        btnProfesional.addActionListener(e -> new BotonProfesional().setVisible(true));
        btnSesiones.addActionListener(e -> new BotonSesion().setVisible(true));
        btnAdmisiones.addActionListener(e -> new BotonAdmision().setVisible(true));
        btnConsultorios.addActionListener(e -> new BotonConsultorio().setVisible(true));
    }

    // Método para iniciar esta ventana de forma segura en Swing
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}
