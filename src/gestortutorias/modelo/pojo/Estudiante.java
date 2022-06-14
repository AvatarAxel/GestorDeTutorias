/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestortutorias.modelo.pojo;

/**
 *
 * @author blackcat
 */
public class Estudiante {

    int idEstudiante, idRol;
    float promedio;
    String nombre,apellidoPaterno,apellidoMaterno, correoElectronicoPersonal, correoElectronicoInstitucional, matricula;
    Integer codigoRespuesta;
   
    public Estudiante() {
    }

    public Estudiante(int idEstudiante, int idRol, float promedio, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronicoPersonal, String correoElectronicoInstitucional, String matricula, Integer codigoRespuesta) {
        this.idEstudiante = idEstudiante;
        this.idRol = idRol;
        this.promedio = promedio;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronicoPersonal = correoElectronicoPersonal;
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
        this.matricula = matricula;
        this.codigoRespuesta = codigoRespuesta;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

   
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        this.correoElectronicoPersonal = correoElectronicoPersonal;
    }

    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }

    public void setCodigoRespuesta(Integer codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public String getCorreoElectronicoPersonal() {
        return correoElectronicoPersonal;
    }

    public String getCorreoElectronicoInstitucional() {
        return correoElectronicoInstitucional;
    }

    public Integer getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public int getIdRol() {
        return idRol;
    }

    public float getPromedio() {
        return promedio;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return  nombre +" " + apellidoPaterno + " "+ apellidoMaterno;
    }

    
   
   
    
    
}
