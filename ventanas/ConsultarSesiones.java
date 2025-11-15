package ventanas;

import persistencia.SesionesDAO;
import persistencia.SesionesDAOImpl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultarSesiones extends JFrame {

    private JTable tabla;  // Tabla donde se mostrarán las sesiones
    private SesionesDAO dao = new SesionesDAOImpl(); // Objeto DAO para acceder a la base de datos

    public ConsultarSesiones() {

        // --- Configuración básica de la ventana ---
        setTitle("Consulta de Sesiones");   // Título de la ventana
        setSize(700, 450);          // Dimensiones de la ventana
        setLocationRelativeTo(null);           // Centrada en pantalla
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // Cierra solo esta ventana

        // --- Columnas que se mostrarán en la tabla ---
        String[] columnas = {"Fecha", "Hora", "Paciente", "Profesional", "Consultorio", "Estado"};

        // Modelo de tabla: permite agregar dinamicamente filas según los datos cargados
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

        // --- Obtención de los datos desde la base de datos ---
        List<Sesiones> lista = dao.listar();

        // Recorremos la lista y agregamos cada sesión como una fila en la tabla
        for (Sesiones p : lista) {
            modelo.addRow(new Object[]{
                p.getFecha(),
                p.getHora(),
                p.getPaciente(),
                p.getProfesional(),
                p.getConsultorio(),
                p.getEstado()
            });
        }

        // --- Crear la tabla y agregarla dentro de un ScrollPane ---
        tabla = new JTable(modelo);                 // Tabla con el modelo ya cargado
        add(new JScrollPane(tabla), BorderLayout.CENTER); // La agregamos al centro del layout

        // --- Panel inferior con el botón "Volver" ---
        JPanel panelBotones = new JPanel();          // Panel para ubicar botones
        JButton btnVolver = new JButton("Volver al menú principal");
        panelBotones.add(btnVolver);                // Agregamos el botón al panel
        add(panelBotones, BorderLayout.SOUTH);       // Lo ubicamos abajo de la ventana

        // --- Acción del botón "Volver" ---
        btnVolver.addActionListener(e -> {
            dispose();                               // Cierra esta ventana
            new VentanaPrincipal().setVisible(true); // Abre la pantalla principal
        });
    }
}
