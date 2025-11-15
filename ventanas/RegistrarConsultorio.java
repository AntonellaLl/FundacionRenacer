package ventanas;

import persistencia.ConsultorioDAO;
import persistencia.ConsultorioDAOImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RegistrarConsultorio extends JFrame {
    private JTextField txtNumero, txtHorario;
    private DefaultListModel<String> modeloLista;
    private java.util.List<Consultorio> consultorio;
    private ConsultorioDAO dao = new ConsultorioDAOImpl();

    public RegistrarConsultorio() {
        setTitle("Registro de Consultorio - Fundación Renacer");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        consultorio = new ArrayList<>();
        modeloLista = new DefaultListModel<>();

        JPanel panelCampos = new JPanel(new GridLayout(0, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelCampos.add(new JLabel("Numero:"));
        txtNumero = new JTextField();
        panelCampos.add(txtNumero);

        panelCampos.add(new JLabel("Horario:"));
        txtHorario = new JTextField();
        panelCampos.add(txtHorario);


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


        btnGuardar.addActionListener(e -> guardarConsultorio());
        btnLimpiar.addActionListener(e -> limpiarCampos());
    }

    private void guardarConsultorio() {
        String numero = txtNumero.getText();
        String horario = txtHorario.getText();


        

        if (numero.isEmpty() || horario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete los campos obligatorios");
            return;
        }

        Consultorio p = new Consultorio(numero, horario);
        consultorio.add(p);
        dao.insertar(p);
        modeloLista.addElement(p.toString());

        JOptionPane.showMessageDialog(null, "✅ Consultorio registrado correctamente");
    }

    private void limpiarCampos() {
        txtNumero.setText("");
        txtHorario.setText("");
    }
}
