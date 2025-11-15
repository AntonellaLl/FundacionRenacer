package ventanas;

import persistencia.SesionesDAO;
import persistencia.SesionesDAOImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RegistroSesiones extends JFrame {
    private JTextField txtFecha, txtHora, txtPaciente, txtProfesional, txtConsultorio, txtEstado;
    private DefaultListModel<String> modeloLista;
    private java.util.List<Sesiones> sesiones;
    private SesionesDAO dao = new SesionesDAOImpl();

    public RegistroSesiones() {
        setTitle("Registro de Sesiones - Fundación Renacer");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        sesiones = new ArrayList<>();
        modeloLista = new DefaultListModel<>();

        JPanel panelCampos = new JPanel(new GridLayout(0, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelCampos.add(new JLabel("Fecha:"));
        txtFecha = new JTextField();
        panelCampos.add(txtFecha);

        panelCampos.add(new JLabel("Hora:"));
        txtHora = new JTextField();
        panelCampos.add(txtHora);

        panelCampos.add(new JLabel("Paciente:"));
        txtPaciente = new JTextField();
        panelCampos.add(txtPaciente);

        panelCampos.add(new JLabel("Profesional:"));
        txtProfesional = new JTextField();
        panelCampos.add(txtProfesional);

        panelCampos.add(new JLabel("Consultorio:"));
        txtConsultorio = new JTextField();
        panelCampos.add(txtConsultorio);

        panelCampos.add(new JLabel("Estado:"));
        txtEstado = new JTextField();
        panelCampos.add(txtEstado);

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
        String fecha = txtFecha.getText();
        String hora = txtHora.getText();
        String paciente = txtPaciente.getText();
        String profesional = txtProfesional.getText();
        String consultorio = txtConsultorio.getText();
        String estado= txtEstado.getText();
        

        if (fecha.isEmpty() || hora.isEmpty() || paciente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete los campos obligatorios");
            return;
        }

        Sesiones p = new Sesiones(fecha, hora, paciente, profesional, consultorio, estado);
        sesiones.add(p);
        dao.insertar(p);
        modeloLista.addElement(p.toString());

        JOptionPane.showMessageDialog(null, "✅ Sesión registrada correctamente");
    }

    private void limpiarCampos() {
        txtFecha.setText("");
        txtHora.setText("");
        txtPaciente.setText("");
        txtProfesional.setText("");
        txtConsultorio.setText("");
        txtEstado.setText("");
    }
}
