package gestortutorias.modelo.pojo;

import javafx.scene.control.ComboBox;

public class Estudiante {
    private Integer idEStudiante;
    private String nombre;
    private String apellidoMaterno;
    private String apellidoPaterno;
    private String nombreCompletoEstudiante;
    private ComboBox prueba;

    public Estudiante() {
    }

    public Estudiante(Integer idEStudiante, String nombre, String apellidoMaterno, String apellidoPaterno, String nombreCompletoEstudiante, ComboBox prueba) {
        this.prueba = prueba;
        this.idEStudiante = idEStudiante;
        this.nombre = nombre;
        this.apellidoMaterno = apellidoMaterno;
        this.apellidoPaterno = apellidoPaterno;
        this.nombreCompletoEstudiante = nombreCompletoEstudiante;
    }

    public ComboBox getPrueba() {
        return prueba;
    }

    public void setPrueba(ComboBox prueba) {
        this.prueba = prueba;
    }
    
    

    public Integer getIdEStudiante() {
        return idEStudiante;
    }

    public void setIdEStudiante(Integer idEStudiante) {
        this.idEStudiante = idEStudiante;
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
    
}
