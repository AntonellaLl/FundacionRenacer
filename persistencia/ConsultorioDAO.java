package persistencia;

import java.util.List;


import ventanas.Consultorio;


  public interface ConsultorioDAO {
    void insertar(Consultorio p);
    List<Consultorio> listar();
}
    
