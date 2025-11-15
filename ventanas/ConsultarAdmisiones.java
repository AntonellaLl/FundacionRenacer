package ventanas;

import persistencia.AdmisionesDAO;
import persistencia.AdmisionesDAOImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultarAdmisiones extends JFrame {
    private JTable tabla;
    private AdmisionesDAO dao = new AdmisionesDAOImpl();

    public ConsultarAdmisiones() {
        setTitle("Consulta de Admisiones");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columnas = {"Fecha", "Hora", "Paciente", "Profesional"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        List<Admisiones> lista = dao.listar();
        for (Admisiones p : lista) {
            modelo.addRow(new Object[]{
                p.getFecha(), p.getHora(), p.getPaciente(), p.getProfesional()
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
            new VentanaPrincipal().setVisible(true); // Abre el menú principal
        });
    }
}


