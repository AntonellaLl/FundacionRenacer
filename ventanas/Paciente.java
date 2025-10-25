package ventanas;

public  class Paciente {
    private String nombre;
    private String apellido;
    private String dni;
    private String obraSocial;
    private String diagnostico;

    public Paciente(String nombre, String apellido, String dni, String obraSocial, String diagnostico) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.obraSocial = obraSocial;
        this.diagnostico = diagnostico;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDni() { return dni; }
    public String getObraSocial() { return obraSocial; }
    public String getDiagnostico() { return diagnostico; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - DNI: " + dni;
    }
}
 
    

