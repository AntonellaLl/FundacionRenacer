package ventanas;

public  class Sesiones {
    private String fecha;
    private String hora;
    private String paciente;
    private String profesional;
    private String consultorio;
    private String estado;
   

    public Sesiones (String fecha, String hora, String paciente, String profesional, String consultorio,String estado) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.profesional = profesional;
        this.consultorio = consultorio;
        this.estado = estado;
    }

    public String getFecha() { return fecha; }
    public String getHora() { return hora; }
    public String getPaciente() { return paciente; }
    public String getProfesional() { return profesional; }
    public String getConsultorio() { return consultorio; }
    public String getEstado() { return estado; }



    @Override
    public String toString() {
        return fecha + " " + hora + " - Paciente: " + paciente;
    }
}
 
    

