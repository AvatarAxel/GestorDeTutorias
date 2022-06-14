package gestortutorias.modelo.pojo;

public class Estudiante {
    private Integer idEstudiante;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String nombreCompletoEstudiante;

    public Estudiante() {
    }

    public Estudiante(Integer idEStudiante, String nombre, String apellidoMaterno, String apellidoPaterno, String nombreCompletoEstudiante) {
        this.idEstudiante = idEStudiante;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.nombreCompletoEstudiante = nombreCompletoEstudiante;
    }

    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEStudiante) {
        this.idEstudiante = idEStudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getNombreCompletoEstudiante() {
        return nombreCompletoEstudiante;
    }

    public void setNombreCompletoEstudiante(String nombreCompletoEstudiante) {
        this.nombreCompletoEstudiante = nombreCompletoEstudiante;
    }

    @Override
    public String toString() {
        return nombreCompletoEstudiante;
    } 
   
}
