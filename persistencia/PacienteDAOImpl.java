package persistencia;

import ventanas.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PacienteDAOImpl implements PacienteDAO {

    @Override
    public void insertar(Paciente p) {
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "INSERT INTO pacientes (Nombre, Apellido, DNI, Fecha_Nacimiento, Obra_Social, Diagnostico) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getDni());
            ps.setString(4, p.getFecha_Nacimiento()); // importante: corresponde con Fecha_Nacimiento
            ps.setString(5, p.getObraSocial());
            ps.setString(6, p.getDiagnostico());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al insertar paciente: " + e.getMessage());
        }
    }

    @Override
    public List<Paciente> listar() {
        List<Paciente> lista = new ArrayList<>();
        try (Connection conn = ConexionBD.conectar()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pacientes");
            while (rs.next()) {
                lista.add(new Paciente(
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getString("dni"),
                    rs.getString("obra_social"),
                    rs.getString("diagnostico"),
                    rs.getString("fecha_nacimiento")
                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar pacientes: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void actualizar(Paciente p) {
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "UPDATE pacientes SET nombre=?, apellido=?, obra_social=?, diagnostico=? WHERE dni=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getObraSocial());
            ps.setString(4, p.getDiagnostico());
            ps.setString(5, p.getDni());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar paciente: " + e.getMessage());
        }
    }

    @Override
    public boolean eliminar(String dni) {
        String sql = "DELETE FROM pacientes WHERE dni = ?";
        try (Connection conn = ConexionBD.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dni);
            int filas = ps.executeUpdate();
            return filas > 0;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

    public Paciente buscarPorDni(String dni) {
    Paciente p = null;
    try (Connection conn = ConexionBD.conectar()) {
        String sql = "SELECT * FROM pacientes WHERE dni = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            p = new Paciente(
                rs.getString("nombre"),
                rs.getString("apellido"),
                rs.getString("dni"),
                rs.getString("obra_social"),
                rs.getString("diagnostico"),
                rs.getString("fecha_nacimiento")
            );
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar paciente: " + e.getMessage());
    }
    return p;
}

}
