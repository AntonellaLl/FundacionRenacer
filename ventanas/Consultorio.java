package ventanas;

/**
 * Clase que representa un Consultorio dentro del sistema.
 * Contiene los datos básicos necesarios para identificarlo y su horario de uso.
 */
public class Consultorio {

    // --- Atributos del consultorio ---
    private String numero;   // Número o identificación del consultorio
    private String horario;  // Horario en el que está disponible

    /**
     * Constructor que permite inicializar un consultorio con su número y horario.
     *
     * @param numero  Número del consultorio
     * @param horario Horario de atención o disponibilidad
     */
    public Consultorio(String numero, String horario) {
        this.numero = numero;
        this.horario = horario;
    }

    // --- Métodos getter para acceder a los atributos ---

    /** Devuelve el número del consultorio */
    public String getNumero() {
        return numero;
    }

    /** Devuelve el horario del consultorio */
    public String getHorario() {
        return horario;
    }

    /**
     * Representación en texto del consultorio.
     */
    @Override
    public String toString() {
        return "Numero de consultorio: " + numero + " Horarios: " + horario;
    }
}
