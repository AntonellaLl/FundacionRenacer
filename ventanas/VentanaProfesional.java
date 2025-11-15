package ventanas;

import ventanas.RegistrarProfesional;
import persistencia.ProfesionalDAOImpl;

import javax.swing.*;
import java.awt.*;

// Ventana para registrar un profesional dentro del sistema
public class VentanaProfesional extends JFrame {

    // Campos de entrada
    private JTextField txtNombre, txtApellido, txtDni, txtFechaNacimiento, txtMatricula, txtEspecialidad;

    // DAO para manejar la persistencia de profesionales
    private ProfesionalDAOImpl dao = new ProfesionalDAOImpl();

    public VentanaProfesional() {
        setTitle("Registrar Profesional");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout con 8 filas y 2 columnas
        setLayout(new GridLayout(8, 2, 10, 10));

        // Campos del formulario
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("DNI:"));
        txtDni = new JTextField();
        add(txtDni);

        add(new JLabel("Fecha de Nacimiento:"));
        txtFechaNacimiento = new JTextField();
        add(txtFechaNacimiento);

        add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        add(txtMatricula);

        add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        add(txtEspecialidad);

        // Botones
        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");
        add(btnGuardar);
        add(btnCancelar);

        // Eventos
        btnGuardar.addActionListener(e -> guardarProfesional());
        btnCancelar.addActionListener(e -> dispose());
    }

    // Método para guardar datos del profesional
    private void guardarProfesional() {
        // Crear objeto con los datos ingresados
        RegistrarProfesional p = new RegistrarProfesional();
        p.setNombre(txtNombre.getText());
        p.setApellido(txtApellido.getText());
        p.setDni(txtDni.getText());
        p.setFechaNacimiento(txtFechaNacimiento.getText());
        p.setMatricula(txtMatricula.getText());
        p.setEspecialidad(txtEspecialidad.getText());

        // Guardar en BD utilizando el DAO
        dao.registrar(p);

        // Confirmación
        JOptionPane.showMessageDialog(this, "Profesional registrado con éxito.");

        // Limpia los campos para una nueva carga
        limpiarCampos();
    }

    // Vaciar campos del formulario
    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtFechaNacimiento.setText("");
        txtMatricula.setText("");
        txtEspecialidad.setText("");
    }
}
