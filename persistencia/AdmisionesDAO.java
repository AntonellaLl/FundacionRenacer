package persistencia;

import java.util.List;

import ventanas.Admisiones;


    public interface AdmisionesDAO {
    void insertar(Admisiones p);
    List<Admisiones> listar();
}
    
