package ventanas;

import javax.swing.*;
import java.sql.*;
import persistencia.ConexionBD;

public class RegistroUsuario extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;
    private JButton btnGuardar, btnVolver;

    public RegistroUsuario() {
        setTitle("Registrar Usuario");
        setSize(350, 220);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblTitulo = new JLabel("Crear nueva cuenta");
        lblTitulo.setBounds(110, 10, 200, 25);
        add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 50, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 50, 150, 25);
        add(txtUsuario);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(30, 90, 80, 25);
        add(lblContraseña);

        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(120, 90, 150, 25);
        add(txtContraseña);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 140, 100, 25);
        add(btnGuardar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(170, 140, 100, 25);
        add(btnVolver);

        btnGuardar.addActionListener(e -> registrarUsuario());
        btnVolver.addActionListener(e -> {
            dispose();
            new Login().setVisible(true);
        });
    }

    private void registrarUsuario() {
        String usuario = txtUsuario.getText();
        String contraseña = String.valueOf(txtContraseña.getPassword());

        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return;
        }

        try (Connection con = ConexionBD.conectar()) {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO usuario (Nombre_Usuario, Contraseña) VALUES (?, ?)");
            ps.setString(1, usuario);
            ps.setString(2, contraseña);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Usuario registrado con éxito");
            dispose();
            new Login().setVisible(true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + e.getMessage());
        }
    }
}

