package ventanas;

// Importación de librerías necesarias para la interfaz gráfica y manejo de eventos
import javax.swing.*;
import java.sql.*;

// Importa tu clase de conexión a la base de datos
import persistencia.ConexionBD; 

public class Login extends JFrame {

    // Campos de texto para que el usuario ingrese su usuario y contraseña
    private JTextField txtUsuario;
    private JPasswordField txtContraseña;

    // Botones para iniciar sesión y registrar un nuevo usuario
    private JButton btnIngresar, btnRegistrar;

    public Login() {
        // Título de la ventana
        setTitle("Login - Fundación Renacer");

        // Tamaño de la ventana
        setSize(350, 220);

        // Acción al cerrar: salir del programa
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Sin layout automático para usar posiciones absolutas
        setLayout(null);

        // Centrar ventana en la pantalla
        setLocationRelativeTo(null);

        // Etiqueta de título
        JLabel lblTitulo = new JLabel("Iniciar Sesión");
        lblTitulo.setBounds(120, 10, 150, 25);
        add(lblTitulo);

        // Etiqueta de usuario
        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 50, 80, 25);
        add(lblUsuario);

        // Campo donde el usuario escribe el nombre de usuario
        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 50, 150, 25);
        add(txtUsuario);

        // Etiqueta de contraseña
        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(30, 90, 80, 25);
        add(lblContraseña);

        // Campo para ingresar la contraseña
        txtContraseña = new JPasswordField();
        txtContraseña.setBounds(120, 90, 150, 25);
        add(txtContraseña);

        // Botón para iniciar sesión
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(50, 140, 100, 25);
        add(btnIngresar);

        // Botón para abrir la ventana de registro
        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(170, 140, 100, 25);
        add(btnRegistrar);

        // Acción del botón ingresar → validar usuario contra la base de datos
        btnIngresar.addActionListener(e -> validarUsuario());

        // Acción del botón registrar → abrir ventana de registro
        btnRegistrar.addActionListener(e -> {
            dispose(); // Cierra la ventana actual
            new RegistroUsuario().setVisible(true); // Abre la ventana de registro
        });
    }

    // Método para validar usuario y contraseña contra la base de datos
    private void validarUsuario() {
        String usuario = txtUsuario.getText();
        String contraseña = String.valueOf(txtContraseña.getPassword());

        // Verifica que no haya campos vacíos
        if (usuario.isEmpty() || contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            return;
        }

        // Manejo de conexión y consulta SQL usando try-with-resources
        try (Connection con = ConexionBD.conectar()) {

            // Consulta SQL para buscar un usuario con ese usuario y contraseña
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM usuario WHERE Nombre_Usuario=? AND Contraseña=?");

            // Se envían los parámetros a la consulta
            ps.setString(1, usuario);
            ps.setString(2, contraseña);

            // Ejecuta la consulta
            ResultSet rs = ps.executeQuery();

            // Si encuentra un usuario válido
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Bienvenido, " + usuario);
                dispose(); // Cierra la ventana de login
                new VentanaPrincipal().setVisible(true); // Abre la pantalla principal
            } else {
                // Si no coincide, muestra error
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
            }

        } catch (SQLException e) {
            // Si hubo un problema al conectarse
            JOptionPane.showMessageDialog(null, 
                "Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    // Método principal que inicia la aplicación mostrando la ventana de login
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
