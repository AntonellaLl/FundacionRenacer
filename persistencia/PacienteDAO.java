package persistencia;

// Importo la clase Paciente, que representa el modelo de datos del paciente.
// También importo List para manejar colecciones en los métodos.
import ventanas.Paciente;
import java.util.List;

// Esta interfaz define el contrato que deben cumplir todas las clases
// que implementen el acceso a datos (DAO) de Paciente.
// Sirve para separar la lógica del sistema de la lógica de la base de datos,
// aplicando el patrón de diseño DAO.
public interface PacienteDAO {

    // Método para insertar un paciente nuevo en la base de datos.
    // Recibe un objeto Paciente con toda la información cargada.
    void insertar(Paciente p);

    // Método para obtener una lista de todos los pacientes registrados.
    // Devuelve una lista de Paciente.
    List<Paciente> listar();

    // Método para actualizar los datos de un paciente existente.
    // Recibe un objeto Paciente con los valores modificados.
    void actualizar(Paciente p);

    // Método para eliminar un paciente según su DNI.
    // Devuelve true si el paciente fue eliminado correctamente.
    boolean eliminar(String dni);
}
