package ventanas;

import persistencia.PacienteDAO;
import persistencia.PacienteDAOImpl;

import javax.swing.*;
import java.awt.*;

// Ventana que permite buscar un paciente por DNI y actualizar sus datos
public class ActualizarPaciente extends JFrame {

    // Campos de texto y botones de la interfaz
    private JTextField txtDniBuscar, txtNombre, txtApellido, txtObra, txtDiag;
    private JButton btnBuscar, btnActualizar, btnVolver;

    // DAO para interactuar con la base de datos
    private PacienteDAO dao = new PacienteDAOImpl();

    // Paciente actualmente seleccionado para actualizar
    private Paciente pacienteActual;

    public ActualizarPaciente() {

        // Configuración básica de la ventana
        setTitle("Actualizar Datos del Paciente");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // PANEL PRINCIPAL CON LOS CAMPOS
        JPanel panelCampos = new JPanel(new GridLayout(6, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- Campo para buscar por DNI ---
        panelCampos.add(new JLabel("Buscar por DNI:"));
        txtDniBuscar = new JTextField();
        panelCampos.add(txtDniBuscar);

        // Botón de búsqueda
        btnBuscar = new JButton("Buscar");
        panelCampos.add(btnBuscar);

        // Espacio en blanco para mantener el orden de la grilla
        panelCampos.add(new JLabel(""));

        // --- Campos de datos del paciente ---
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        panelCampos.add(txtApellido);

        panelCampos.add(new JLabel("Obra Social:"));
        txtObra = new JTextField();
        panelCampos.add(txtObra);

        panelCampos.add(new JLabel("Diagnóstico:"));
        txtDiag = new JTextField();
        panelCampos.add(txtDiag);

        // Agrega el panel al centro de la ventana
        add(panelCampos, BorderLayout.CENTER);

        // PANEL INFERIOR CON BOTONES
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnActualizar = new JButton("Actualizar");
        btnVolver = new JButton("Volver");
        panelBotones.add(btnActualizar);
        panelBotones.add(btnVolver);

        add(panelBotones, BorderLayout.SOUTH);

        // --- Acciones de los botones ---
        btnBuscar.addActionListener(e -> buscarPaciente());       // Busca un paciente por DNI
        btnActualizar.addActionListener(e -> actualizarPaciente()); // Actualiza sus datos
        btnVolver.addActionListener(e -> {
            dispose();                       // Cierra esta ventana
            new VentanaPrincipal().setVisible(true); // Vuelve al menú principal
        });
    }

    // Método para buscar un paciente en la base de datos por DNI
    private void buscarPaciente() {
        String dni = txtDniBuscar.getText().trim();

        // Validación de campo vacío
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI para buscar.");
            return;
        }

        // Recorre todos los pacientes obtenidos del DAO
        for (Paciente p : dao.listar()) {
            if (p.getDni().equals(dni)) {

                // Guarda el paciente encontrado
                pacienteActual = p;

                // Completa los campos con los datos del paciente
                txtNombre.setText(p.getNombre());
                txtApellido.setText(p.getApellido());
                txtObra.setText(p.getObraSocial());
                txtDiag.setText(p.getDiagnostico());

                JOptionPane.showMessageDialog(this, "Paciente encontrado.");
                return;
            }
        }

        // Si no coinciden DNI
        JOptionPane.showMessageDialog(this, "No se encontró un paciente con ese DNI.");
    }

    // Método para actualizar los datos del paciente encontrado
    private void actualizarPaciente() {

        // Verifica si se realizó una búsqueda antes
        if (pacienteActual == null) {
            JOptionPane.showMessageDialog(this, "Primero busque un paciente.");
            return;
        }

        // Crea un nuevo objeto Paciente con los datos actualizados
        pacienteActual = new Paciente(
            txtNombre.getText(),
            txtApellido.getText(),
            pacienteActual.getDni(), // El DNI no se modifica
            txtObra.getText(),
            txtDiag.getText(),
            pacienteActual.getFecha_Nacimiento()
        );

        // Llama al método del DAO para actualizar en BD
        dao.actualizar(pacienteActual);

        JOptionPane.showMessageDialog(this, "✅ Datos actualizados correctamente.");
        
        // Limpia los campos para una nueva búsqueda
        limpiarCampos();
    }

    // Limpia los campos de texto y reinicia el paciente actual
    private void limpiarCampos() {
        txtDniBuscar.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtObra.setText("");
        txtDiag.setText("");
        pacienteActual = null;
    }

    // Método principal para ejecutar la ventana
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ActualizarPaciente().setVisible(true));
    }
}
