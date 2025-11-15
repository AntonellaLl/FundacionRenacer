package ventanas;

import persistencia.ProfesionalDAO;
import persistencia.ProfesionalDAOImpl;
import javax.swing.*;
import java.awt.*;

/**
 * Ventana que permite buscar un profesional mediante su DNI
 * y eliminarlo de la base de datos. Muestra sus datos antes de confirmar.
 */
public class EliminarProfesional extends JFrame {

    // Campos de búsqueda y visualización de datos
    private JTextField txtBuscarDni, txtDni, txtNombre, txtApellido, txtFechaNacimiento, txtMatricula, txtEspecialidad;

    // Botones principales
    private JButton btnBuscar, btnEliminar, btnCancelar;

    // Acceso a datos (DAO)
    private ProfesionalDAO dao = new ProfesionalDAOImpl();

    // Profesional encontrado
    private RegistrarProfesional profesionalActual = null;

    public EliminarProfesional() {

        // --- Configuración de la ventana ---
        setTitle("Eliminar Profesional - Fundación Renacer");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // --- Panel que contiene todos los campos ---
        JPanel panelCampos = new JPanel(new GridLayout(0, 2, 5, 5));
        panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- Campo para ingresar el DNI a buscar ---
        panelCampos.add(new JLabel("DNI del profesional a buscar:"));
        txtBuscarDni = new JTextField();
        panelCampos.add(txtBuscarDni);

        // Botón de búsqueda
        btnBuscar = new JButton("Buscar");
        panelCampos.add(btnBuscar);
        panelCampos.add(new JLabel("")); // espacio vacío para completar grilla

        // --- Campos con la información del profesional (solo lectura) ---
        panelCampos.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        txtNombre.setEditable(false);
        panelCampos.add(txtNombre);

        panelCampos.add(new JLabel("Apellido:"));
        txtApellido = new JTextField();
        txtApellido.setEditable(false);
        panelCampos.add(txtApellido);

        panelCampos.add(new JLabel("DNI:"));
        txtDni = new JTextField();
        txtDni.setEditable(false);
        panelCampos.add(txtDni);

        panelCampos.add(new JLabel("Fecha de Nacimiento:"));
        txtFechaNacimiento = new JTextField();
        txtFechaNacimiento.setEditable(false);
        panelCampos.add(txtFechaNacimiento);

        panelCampos.add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        txtMatricula.setEditable(false);
        panelCampos.add(txtMatricula);

        panelCampos.add(new JLabel("Especialidad:"));
        txtEspecialidad = new JTextField();
        txtEspecialidad.setEditable(false);
        panelCampos.add(txtEspecialidad);

        // --- Panel inferior con botones ---
        JPanel panelBotones = new JPanel();
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setEnabled(false); // Solo se habilita cuando se encuentra un profesional
        btnCancelar = new JButton("Cancelar");

        panelBotones.add(btnEliminar);
        panelBotones.add(btnCancelar);

        // Agregar todo a la ventana
        add(panelCampos, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // --- Acciones de los botones ---
        btnBuscar.addActionListener(e -> buscarProfesional());
        btnEliminar.addActionListener(e -> eliminarProfesional());
        btnCancelar.addActionListener(e -> dispose());
    }

    /**
     * Busca un profesional en la base de datos usando el DNI ingresado.
     * Si lo encuentra, completa los campos con su información.
     */
    private void buscarProfesional() {
        String dni = txtBuscarDni.getText().trim();

        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI para buscar");
            return;
        }

        // Buscar en la BD
        profesionalActual = ((ProfesionalDAOImpl) dao).buscarPorDni(dni);

        if (profesionalActual != null) {
            // Mostrar datos encontrados
            txtNombre.setText(profesionalActual.getNombre());
            txtApellido.setText(profesionalActual.getApellido());
            txtDni.setText(profesionalActual.getDni());
            txtFechaNacimiento.setText(profesionalActual.getFechaNacimiento());
            txtMatricula.setText(profesionalActual.getMatricula());
            txtEspecialidad.setText(profesionalActual.getEspecialidad());

            btnEliminar.setEnabled(true);

        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un profesional con ese DNI");
            limpiarCampos();
        }
    }

    /**
     * Elimina el profesional actualmente cargado,
     * previa confirmación del usuario.
     */
    private void eliminarProfesional() {
        if (profesionalActual == null) return;

        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Está seguro que desea eliminar al profesional?\n" +
                        profesionalActual.getNombre() + " " + profesionalActual.getApellido(),
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {

            dao.eliminar(profesionalActual.getDni()); // Eliminación en la BD

            JOptionPane.showMessageDialog(this, "✅ Profesional eliminado correctamente");

            limpiarCampos();
            profesionalActual = null;
            btnEliminar.setEnabled(false);
        }
    }

    /**
     * Limpia todos los campos mostrados en pantalla.
     */
    private void limpiarCampos() {
        txtBuscarDni.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDni.setText("");
        txtFechaNacimiento.setText("");
        txtMatricula.setText("");
        txtEspecialidad.setText("");
    }
}
