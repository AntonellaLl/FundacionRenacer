package ventanas;

/**
 * Clase que representa una admisión o turno potencial
 * entre un profesional y un posible paciente.
 * Esta clase funciona como modelo de datos.
 */
public class Admisiones {

    // Nombre del profesional que atenderá al paciente
    private String nombre_profesional;

    // Nombre del paciente potencial que solicita la admisión
    private String nombre_potencial_paciente;

    // Fecha de la admisión
    private String fecha;

    // Hora de la admisión
    private String hora;

    /**
     * Constructor que inicializa todos los campos de la admisión.
     *
     * @param nombre_profesional Nombre del profesional asignado
     * @param nombre_potencial_paciente Nombre del paciente potencial
     * @param fecha Fecha del turno o admisión
     * @param hora Hora del turno o admisión
     */
    public Admisiones (String nombre_profesional, String nombre_potencial_paciente, String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
        this.nombre_profesional = nombre_profesional;
        this.nombre_potencial_paciente = nombre_potencial_paciente;
    }

    // --- Métodos getters para acceder a los atributos ---

    public String getFecha() { return fecha; }

    public String getHora() { return hora; }

    public String getPaciente() { return nombre_potencial_paciente; }

    public String getProfesional() { return nombre_profesional; }

    /**
     * Representación en texto de la admisión
     */
    @Override
    public String toString() {
        return fecha + " " + hora + " - Paciente: " + nombre_potencial_paciente;
    }
}
