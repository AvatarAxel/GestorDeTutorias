/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestortutorias.modelo.pojo;

/**
 *
 * @author LENOVO
 */
public class Tutor {
   int idRol;
  String nombre,apellidoPaterno,apellidoMaterno,correoElectronicoInstitucional,correoElectronicoPersonal,tipoRol,nombreUsuario,tipoDocente,contrasenia;
  Integer codigoRespuesta;

    public Tutor() {
    }

    public Tutor(int idRol, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronicoInstitucional, String correoElectronicoPersonal, String tipoRol, String nombreUsuario, String tipoDocente, String contrasenia, Integer codigoRespuestal) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
        this.correoElectronicoPersonal = correoElectronicoPersonal;
        this.tipoRol = tipoRol;
        this.nombreUsuario = nombreUsuario;
        this.tipoDocente = tipoDocente;
        this.contrasenia = contrasenia;
        this.codigoRespuesta = codigoRespuesta;
    }

    public int getIdRol() {
        return idRol;
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

    public String getCorreoElectronicoInstitucional() {
        return correoElectronicoInstitucional;
    }

    public String getCorreoElectronicoPersonal() {
        return correoElectronicoPersonal;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getTipoDocente() {
        return tipoDocente;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public Integer getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
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

    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }

    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        this.correoElectronicoPersonal = correoElectronicoPersonal;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setTipoDocente(String tipoDocente) {
        this.tipoDocente = tipoDocente;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public void setCodigoRespuesta(Integer codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }

    @Override
    public String toString() {
        return  nombre + " " + apellidoPaterno + " " + apellidoMaterno;
    }
  
  
}
