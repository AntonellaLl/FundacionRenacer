package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Fundación Renacer - Sistema de Gestión");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JButton btnPacientes = new JButton("Registrar Pacientes");
        JButton btnProfesionales = new JButton("Registrar Profesionales");
        JButton btnSesiones = new JButton("Programar Sesiones");
        JButton btnSalir = new JButton("Salir");

        add(btnPacientes);
        add(btnProfesionales);
        add(btnSesiones);
        add(btnSalir);

        btnPacientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new VentanaPaciente().setVisible(true);
            }
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}
