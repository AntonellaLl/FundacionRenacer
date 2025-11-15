package ventanas;

import persistencia.PacienteDAO;
import persistencia.PacienteDAOImpl;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana que permite buscar un paciente por DNI y eliminarlo de la base de datos.
 * Muestra sus datos antes de confirmar la eliminación.
 */
public class EliminarPaciente extends JFrame {

    // Campos de texto para mostrar los datos del paciente
    private JTextField txtDni, txtNombre, txtApellido, txtObra, txtDiag, txtFecha;

    // Botones principales
    private JButton btnBuscar, btnEliminar, btnCancelar;

    // Objeto de acceso a datos (DAO)
    private PacienteDAO dao = new PacienteDAOImpl();

    // Paciente actualmente encontrado mediante la búsqueda
    private Paciente pacienteActual = null;

    public EliminarPaciente() {

        // --- Configuración general de la ventana ---
        setTitle("Eliminar Paciente - Fundación Renacer");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Panel para los campos de información ---
        JPanel panelCampos = new JPanel(new GridLayout(0, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- Campo DNI y botón de búsqueda ---
        panelCampos.add(new JLabel("DNI del paciente:"));
        txtDni = new JTextField();
        panelCampos.add(txtDni);

        btnBuscar = new JButton("Buscar");
        panelCampos.add(btnBuscar);
        panelCampos.add(new JLabel("")); // espacio vacío para acomodar la grilla

        // --- Campos de datos del paciente (solo lectura) ---
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        txtApellido.setEditable(false);
        panelCampos.add(txtApellido);

        panelCampos.add(new JLabel("Obra Social:"));
        txtObra = new JTextField();
        txtObra.setEditable(false);
        panelCampos.add(txtObra);

        panelCampos.add(new JLabel("Diagnóstico:"));
        txtDiag = new JTextField();
        txtDiag.setEditable(false);
        panelCampos.add(txtDiag);

        panelCampos.add(new JLabel("Fecha Nacimiento:"));
        txtFecha = new JTextField();
        txtFecha.setEditable(false);
        panelCampos.add(txtFecha);

        // --- Panel inferior con botones Eliminar y Cancelar ---
        JPanel panelBotones = new JPanel();
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false); // Se habilita solo si se encuentra un paciente
        btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnEliminar);
        panelBotones.add(btnCancelar);

        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // --- Acciones de los botones ---
        btnBuscar.addActionListener(e -> buscarPaciente());
        btnEliminar.addActionListener(e -> eliminarPaciente());
        btnCancelar.addActionListener(e -> dispose());

        // --- Botón para volver al menú principal ---
        JPanel panelBoton = new JPanel();
        JButton btnVolver = new JButton("Volver al menú principal");
        panelBoton.add(btnVolver);
        add(panelBoton, BorderLayout.SOUTH);

        btnVolver.addActionListener(e -> {
            dispose();                // Cierra esta ventana
            new BotonPaciente().setVisible(true); // Vuelve al menú Pacientes
        });
    }

    /**
     * Busca un paciente por DNI en la base de datos.
     * Si lo encuentra, muestra sus datos en pantalla.
     */
    private void buscarPaciente() {
        String dni = txtDni.getText().trim();

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI para buscar");
            return;
        }

        // Buscar el paciente en la BD
        pacienteActual = ((PacienteDAOImpl) dao).buscarPorDni(dni);

        if (pacienteActual != null) {
            // Mostrar datos del paciente encontrado
            txtNombre.setText(pacienteActual.getNombre());
            txtApellido.setText(pacienteActual.getApellido());
            txtObra.setText(pacienteActual.getObraSocial());
            txtDiag.setText(pacienteActual.getDiagnostico());
            txtFecha.setText(pacienteActual.getFecha_Nacimiento());

            btnEliminar.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un paciente con ese DNI");
            limpiarCampos();
        }
    }

    /**
     * Elimina el paciente actualmente buscado,
     * solicitando al usuario confirmación.
     */
    private void eliminarPaciente() {
        if (pacienteActual == null) return;

        // Confirmación
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar al paciente?\n" +
                        pacienteActual.getNombre() + " " + pacienteActual.getApellido(),
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            dao.eliminar(pacienteActual.getDni());  // Eliminación en la BD

            JOptionPane.showMessageDialog(this, "✅ Paciente eliminado correctamente");

            limpiarCampos();
            pacienteActual = null;
            btnEliminar.setEnabled(false);
        }
    }

    /**
     * Limpia los campos de información del paciente.
     */
    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtObra.setText("");
        txtDiag.setText("");
        txtFecha.setText("");
    }
}
