package persistencia;

import ventanas.Admisiones;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class AdmisionesDAOImpl implements AdmisionesDAO {

    @Override
    public void insertar(Admisiones p) {
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "INSERT INTO admision (Nombre_Profesional, Nombre_Potencial_Paciente, Fecha, Hora) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getProfesional());
            ps.setString(2, p.getPaciente());
            ps.setString(3, p.getFecha());
            ps.setString(4, p.getHora()); 

            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar la Admision: " + e.getMessage());
        }
    }

    @Override
    public List<Admisiones> listar() {
        List<Admisiones> lista = new ArrayList<>();
        try (Connection conn = ConexionBD.conectar()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM admision");
            while (rs.next()) {
                lista.add(new Admisiones(
                    rs.getString("Nombre_Profesional"),
                    rs.getString("Nombre_Potencial_Paciente"),
                    rs.getString("Fecha"),
                    rs.getString("Hora")
                    

                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Admisiones: " + e.getMessage());
        }
        return lista;
    }

   

}
