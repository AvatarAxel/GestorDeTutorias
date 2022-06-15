package gestortutorias.modelo.pojo;

public class Estudiante {
    private Integer idEstudiante;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String nombreCompletoEstudiante;
    private String matricula;
    private Integer idRol;
    private String correoElectronicoPersonal;
    private String correoElectronicoInstitucional;

    public Estudiante() {
    }

    public Estudiante(Integer idEStudiante, String nombre, String apellidoMaterno, String apellidoPaterno, String nombreCompletoEstudiante, String matricula, Integer idRol, String correoElectronicoPersonal, String correoElectronicoInstitucional) {
        this.idEstudiante = idEStudiante;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.nombreCompletoEstudiante = nombreCompletoEstudiante;
        this.matricula = matricula;
        this.idRol = idRol;
        this.correoElectronicoPersonal = correoElectronicoPersonal;
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getCorreoElectronicoPersonal() {
        return correoElectronicoPersonal;
    }

    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        this.correoElectronicoPersonal = correoElectronicoPersonal;
    }

    public String getCorreoElectronicoInstitucional() {
        return correoElectronicoInstitucional;
    }

    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }
    
    @Override
    public String toString() {
        return nombreCompletoEstudiante;
    } 
   
}
