package ventanas;

import persistencia.PacienteDAO;
import persistencia.PacienteDAOImpl;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaPaciente extends JFrame {
    private JTextField txtNombre, txtApellido, txtDni, txtObra, txtDiag, txtFechaNacimiento;
    private DefaultListModel<String> modeloLista;
    private java.util.List<Paciente> pacientes;
    private PacienteDAO dao = new PacienteDAOImpl();

    public VentanaPaciente() {
        setTitle("Registro de Pacientes - Fundación Renacer");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        pacientes = new ArrayList<>();
        modeloLista = new DefaultListModel<>();

        JPanel panelCampos = new JPanel(new GridLayout(0, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelCampos.add(txtApellido);

        panelCampos.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        panelCampos.add(txtDni);

        panelCampos.add(new JLabel("Fecha de nacimiento:"));
        txtFechaNacimiento = new JTextField();
        panelCampos.add(txtFechaNacimiento);

        panelCampos.add(new JLabel("Obra Social:"));
        txtObra = new JTextField();
        panelCampos.add(txtObra);

        panelCampos.add(new JLabel("Diagnóstico:"));
        txtDiag = new JTextField();
        panelCampos.add(txtDiag);

        JButton btnGuardar = new JButton("Guardar");
        JButton btnLimpiar = new JButton("Limpiar");
        panelCampos.add(btnGuardar);
        panelCampos.add(btnLimpiar);

        // 🔹 Colocamos el formulario completo en el centro
        add(panelCampos, BorderLayout.CENTER);

        // 🔹 La lista de pacientes abajo
        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);
        add(scroll, BorderLayout.SOUTH);


        btnGuardar.addActionListener(e -> guardarPaciente());
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void guardarPaciente() {
        String nombre = txtNombre.getText();
        String apellido = txtApellido.getText();
        String dni = txtDni.getText();
        String fecha_nacimiento = txtFechaNacimiento.getText();
        String obra = txtObra.getText();
        String diag = txtDiag.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete los campos obligatorios");
            return;
        }

        Paciente p = new Paciente(nombre, apellido, dni, obra, diag, fecha_nacimiento);
        pacientes.add(p);
        dao.insertar(p);
        modeloLista.addElement(p.toString());

        JOptionPane.showMessageDialog(null, "✅ Paciente registrado correctamente");
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtFechaNacimiento.setText("");
        txtObra.setText("");
        txtDiag.setText("");
    }
}
