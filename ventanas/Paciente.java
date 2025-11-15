package ventanas;

public  class Paciente {
    private String nombre;
    private String apellido;
    private String dni;
    private String obraSocial;
    private String diagnostico;
    private String fecha_nacimiento;

    public Paciente(String nombre, String apellido, String dni, String obraSocial, String diagnostico, String fecha_nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.obraSocial = obraSocial;
        this.diagnostico = diagnostico;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getDni() { return dni; }
    public String getObraSocial() { return obraSocial; }
    public String getDiagnostico() { return diagnostico; }
    public String getFecha_Nacimiento() { return fecha_nacimiento; }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - DNI: " + dni;
    }
}
 
    

