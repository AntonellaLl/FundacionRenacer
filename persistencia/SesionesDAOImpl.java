package persistencia;

import ventanas.Sesiones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SesionesDAOImpl implements SesionesDAO {

    @Override
    public void insertar(Sesiones p) {
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "INSERT INTO sesion (Fecha, Hora, Paciente, Profesional, Consultorio, Estado) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getFecha());
            ps.setString(2, p.getHora());
            ps.setString(3, p.getPaciente());
            ps.setString(4, p.getProfesional()); 
            ps.setString(5, p.getConsultorio());
            ps.setString(6, p.getEstado());

            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la sesion: " + e.getMessage());
        }
    }

    @Override
    public List<Sesiones> listar() {
        List<Sesiones> lista = new ArrayList<>();
        try (Connection conn = ConexionBD.conectar()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM sesion");
            while (rs.next()) {
                lista.add(new Sesiones(
                    rs.getString("Fecha"),
                    rs.getString("Hora"),
                    rs.getString("Paciente"),
                    rs.getString("Profesional"),
                    rs.getString("Consultorio"),
                    rs.getString("Estado")

                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Sesiones: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void actualizar(Sesiones p) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizar'");
    }

    @Override
    public boolean eliminar(String dni) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminar'");
    }

}
