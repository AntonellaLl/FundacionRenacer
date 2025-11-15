package ventanas;

public class RegistrarProfesional {
    private int idProfesional;
    private String nombre;
    private String apellido;
    private String dni;
    private String fechaNacimiento;
    private String matricula;
    private String especialidad;

    public RegistrarProfesional() {}

    public RegistrarProfesional(int idProfesional, String nombre, String apellido, String dni,
        String fechaNacimiento, String matricula, String especialidad) {
        this.idProfesional = idProfesional;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    // Getters y setters
    public int getIdProfesional() { return idProfesional; }
    public void setIdProfesional(int idProfesional) { this.idProfesional = idProfesional; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getMatricula() { return matricula; }
    public void setMatricula(String matricula) { this.matricula = matricula; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}
