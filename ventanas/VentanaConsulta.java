package ventanas;

import persistencia.PacienteDAO;
import persistencia.PacienteDAOImpl;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaConsulta extends JFrame {
    private JTable tabla;
    private PacienteDAO dao = new PacienteDAOImpl();

    public VentanaConsulta() {
        setTitle("Consulta de Pacientes");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"Nombre", "Apellido", "DNI", "Obra Social", "Diagnóstico"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        List<Paciente> lista = dao.listar();
        for (Paciente p : lista) {
            modelo.addRow(new Object[]{
                p.getNombre(), p.getApellido(), p.getDni(), p.getObraSocial(), p.getDiagnostico()
            });
        }

        tabla = new JTable(modelo);
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // --- Panel inferior con botón "Volver" ---
        JPanel panelBotones = new JPanel();
        JButton btnVolver = new JButton("Volver al menú principal");
        panelBotones.add(btnVolver);
        add(panelBotones, BorderLayout.SOUTH);

        // --- Acción del botón "Volver" ---
        btnVolver.addActionListener(e -> {
            dispose(); // Cierra la ventana actual
            new BotonPaciente().setVisible(true); // Abre el menú principal
        });
    }
}
