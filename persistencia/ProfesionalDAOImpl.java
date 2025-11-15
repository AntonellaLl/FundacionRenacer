package persistencia;

import ventanas.RegistrarProfesional;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfesionalDAOImpl implements ProfesionalDAO {

    @Override
    public void registrar(RegistrarProfesional p) {
        String sql = "INSERT INTO profesionales (Nombre, Apellido, DNI, Fecha_Nacimiento, Matricula, Especialidad) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionBD.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getDni());
            ps.setString(4, p.getFechaNacimiento());
            ps.setString(5, p.getMatricula());
            ps.setString(6, p.getEspecialidad());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<RegistrarProfesional> listar() {
        List<RegistrarProfesional> lista = new ArrayList<>();
        String sql = "SELECT * FROM profesionales";
        try (Connection con = ConexionBD.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                RegistrarProfesional p = new RegistrarProfesional(
                    rs.getInt("ID_Profesional"),
                    rs.getString("Nombre"),
                    rs.getString("Apellido"),
                    rs.getString("DNI"),
                    rs.getString("Fecha_Nacimiento"),
                    rs.getString("Matricula"),
                    rs.getString("Especialidad")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public RegistrarProfesional buscarPorDni(String dni) {
    RegistrarProfesional p = null;
    String sql = "SELECT * FROM profesionales WHERE DNI = ?";
    try (Connection con = ConexionBD.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            p = new RegistrarProfesional(
                rs.getInt("ID_Profesional"),
                rs.getString("Nombre"),
                rs.getString("Apellido"),
                rs.getString("DNI"),
                rs.getString("Fecha_Nacimiento"),
                rs.getString("Matricula"),
                rs.getString("Especialidad")
            );
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return p;
}

    @Override
    public void actualizar (RegistrarProfesional p) {
        String sql = "UPDATE profesionales SET Nombre=?, Apellido=?, Fecha_Nacimiento=?, Matricula=?, Especialidad=? WHERE DNI=?";
        try (Connection con = ConexionBD.conectar();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getFechaNacimiento());
            ps.setString(4, p.getMatricula());
            ps.setString(5, p.getEspecialidad());
            ps.setString(6, p.getDni());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        
    }
    @Override
    public boolean eliminar(String dni) {
        String sql = "DELETE FROM profesionales WHERE dni = ?";
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

}
