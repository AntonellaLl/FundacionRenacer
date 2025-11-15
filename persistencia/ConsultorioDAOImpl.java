package persistencia;

import ventanas.Admisiones;
import ventanas.Consultorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ConsultorioDAOImpl implements ConsultorioDAO {

    @Override
    public void insertar(Consultorio p) {
        try (Connection conn = ConexionBD.conectar()) {
            String sql = "INSERT INTO consultorio (Numero, Horarios) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNumero());
            ps.setString(2, p.getHorario());
    
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al registrar consultorio: " + e.getMessage());
        }
    }

    @Override
    public List<Consultorio> listar() {
        List<Consultorio> lista = new ArrayList<>();
        try (Connection conn = ConexionBD.conectar()) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM consultorio");
            while (rs.next()) {
                lista.add(new Consultorio(
                    rs.getString("Numero"),
                    rs.getString("Horario")
                 
                    

                ));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al listar Consultorios: " + e.getMessage());
        }
        return lista;
    }

   

}
