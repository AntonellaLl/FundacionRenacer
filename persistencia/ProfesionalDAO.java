package persistencia;

import ventanas.RegistrarProfesional;
import java.util.List;

public interface ProfesionalDAO {
    void registrar(RegistrarProfesional profesional);
    List<RegistrarProfesional> listar();

    public RegistrarProfesional buscarPorDni(String dni);
    public void actualizar(RegistrarProfesional p);
    boolean eliminar(String dni);

}
