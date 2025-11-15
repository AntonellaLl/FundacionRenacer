package ventanas;

import persistencia.ProfesionalDAO;
import persistencia.ProfesionalDAOImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Ventana destinada a mostrar una lista de profesionales registrados en el sistema.
 * Utiliza una JTable para visualizar los datos obtenidos desde la capa de persistencia.
 */
public class ConsultaProfesional extends JFrame {

    private JTable tabla; // Tabla donde se mostrarán los datos
    private ProfesionalDAO dao = new ProfesionalDAOImpl(); // Acceso a la base de datos

    public ConsultaProfesional() {

        // Configuración básica de la ventana
        setTitle("Consulta de Profesionales");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // --- Definición de columnas de la tabla ---
        String[] columnas = {
                "Nombre",
                "Apellido",
                "DNI",
                "Fecha de Nacimiento",
                "Matrícula",
                "Especialidad"
        };

        // Modelo que manejará los datos mostrados en la JTable
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // Se obtienen los profesionales desde la base de datos
        List<RegistrarProfesional> lista = dao.listar();

        // Se agregan las filas al modelo usando los datos del objeto Profesional
        for (RegistrarProfesional p : lista) {
            modelo.addRow(new Object[]{
                    p.getNombre(),
                    p.getApellido(),
                    p.getDni(),
                    p.getFechaNacimiento(),
                    p.getMatricula(),
                    p.getEspecialidad()
            });
        }

        // Se crea la tabla con el modelo previamente cargado
        tabla = new JTable(modelo);

        // Se agrega la tabla dentro de un JScrollPane para permitir desplazamiento
        add(new JScrollPane(tabla), BorderLayout.CENTER);

        // --- Panel inferior con el botón "Volver" ---
        JPanel panelBotones = new JPanel();
        JButton btnVolver = new JButton("Volver al menú principal");
        panelBotones.add(btnVolver);
        add(panelBotones, BorderLayout.SOUTH);

        // --- Acción del botón "Volver" ---
        btnVolver.addActionListener(e -> {
            dispose(); // Cierra la ventana actual
            new VentanaPrincipal().setVisible(true); // Vuelve al menú principal
        });
    }
}
