package persistencia;
import java.util.List;
import ventanas.Sesiones;

    public interface SesionesDAO {
    void insertar(Sesiones p);
    List<Sesiones> listar();
    void actualizar(Sesiones p);
    boolean eliminar(String dni);
}
    

