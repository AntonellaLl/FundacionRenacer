package ventanas;

import ventanas.RegistrarProfesional;
import persistencia.ProfesionalDAOImpl;

import javax.swing.*;
import java.awt.*;

public class ModificarProfesional extends JFrame {

    private JTextField txtDniBuscar, txtNombre, txtApellido, txtFechaNacimiento, txtMatricula, txtEspecialidad;
    private JButton btnBuscar, btnActualizar;
    private ProfesionalDAOImpl dao = new ProfesionalDAOImpl();
    private RegistrarProfesional profesionalActual;

    public ModificarProfesional() {
        setTitle("Modificar Datos del Profesional");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));

        add(new JLabel("Ingrese DNI del profesional:"));
        txtDniBuscar = new JTextField();
        add(txtDniBuscar);

        btnBuscar = new JButton("Buscar");
        add(btnBuscar);
        add(new JLabel("")); // Espacio vacío

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        add(txtApellido);

        add(new JLabel("Fecha de Nacimiento:"));
        txtFechaNacimiento = new JTextField();
        add(txtFechaNacimiento);

        add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        add(txtMatricula);

        add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        add(txtEspecialidad);

        btnActualizar = new JButton("Actualizar");
        add(btnActualizar);
        JButton btnCancelar = new JButton("Cancelar");
        add(btnCancelar);

        // Listeners
        btnBuscar.addActionListener(e -> buscarProfesional());
        btnActualizar.addActionListener(e -> actualizarProfesional());
        btnCancelar.addActionListener(e -> dispose());

        // Desactivar campos hasta que se busque un profesional
        habilitarCampos(false);
    }

    private void habilitarCampos(boolean habilitado) {
        txtNombre.setEnabled(habilitado);
        txtApellido.setEnabled(habilitado);
        txtFechaNacimiento.setEnabled(habilitado);
        txtMatricula.setEnabled(habilitado);
        txtEspecialidad.setEnabled(habilitado);
        btnActualizar.setEnabled(habilitado);
    }

    private void buscarProfesional() {
        String dni = txtDniBuscar.getText().trim();
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI para buscar.");
            return;
        }

        profesionalActual = dao.buscarPorDni(dni);
        if (profesionalActual != null) {
            txtNombre.setText(profesionalActual.getNombre());
            txtApellido.setText(profesionalActual.getApellido());
            txtFechaNacimiento.setText(profesionalActual.getFechaNacimiento());
            txtMatricula.setText(profesionalActual.getMatricula());
            txtEspecialidad.setText(profesionalActual.getEspecialidad());
            habilitarCampos(true);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un profesional con ese DNI.");
            limpiarCampos();
            habilitarCampos(false);
        }
    }

    private void actualizarProfesional() {
        if (profesionalActual == null) {
            JOptionPane.showMessageDialog(this, "Primero debe buscar un profesional.");
            return;
        }

        profesionalActual.setNombre(txtNombre.getText());
        profesionalActual.setApellido(txtApellido.getText());
        profesionalActual.setFechaNacimiento(txtFechaNacimiento.getText());
        profesionalActual.setMatricula(txtMatricula.getText());
        profesionalActual.setEspecialidad(txtEspecialidad.getText());

        dao.actualizar(profesionalActual);
        JOptionPane.showMessageDialog(this, "Profesional actualizado correctamente.");
        limpiarCampos();
        habilitarCampos(false);
    }

    private void limpiarCampos() {
        txtDniBuscar.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtFechaNacimiento.setText("");
        txtMatricula.setText("");
        txtEspecialidad.setText("");
    }
}
