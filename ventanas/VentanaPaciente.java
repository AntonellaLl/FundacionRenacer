package ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class VentanaPaciente extends JFrame {
    private JTextField txtNombre, txtApellido, txtDni, txtObra, txtDiag;
    private DefaultListModel<String> modeloLista;
    private java.util.List<Paciente> pacientes;

    public VentanaPaciente() {
        setTitle("Registro de Pacientes - Fundación Renacer");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        pacientes = new ArrayList<>();
        modeloLista = new DefaultListModel<>();

        JPanel panelCampos = new JPanel(new GridLayout(6, 2, 5, 5));
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

        panelCampos.add(new JLabel("Obra Social:"));
        txtObra = new JTextField();
        panelCampos.add(txtObra);

        panelCampos.add(new JLabel("Diagnóstico:"));
        txtDiag = new JTextField();
        panelCampos.add(txtDiag);

        JButton btnGuardar = new JButton("Guardar");
        panelCampos.add(btnGuardar);

        JButton btnLimpiar = new JButton("Limpiar");
        panelCampos.add(btnLimpiar);

        JList<String> lista = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(lista);

        add(panelCampos, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // Acción Guardar
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String dni = txtDni.getText();
                String obra = txtObra.getText();
                String diag = txtDiag.getText();

                if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Complete los campos obligatorios");
                    return;
                }

                Paciente p = new Paciente(nombre, apellido, dni, obra, diag);
                pacientes.add(p);
                modeloLista.addElement(p.toString());

                JOptionPane.showMessageDialog(null, "✅ Paciente registrado correctamente");
            }
        });

        // Acción Limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNombre.setText("");
                txtApellido.setText("");
                txtDni.setText("");
                txtObra.setText("");
                txtDiag.setText("");
            }
        });
    }
}
