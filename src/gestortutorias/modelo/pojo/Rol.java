/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortutorias.modelo.pojo;

/**
 *
 * @author je_zu
 */
public class Rol {
    Integer idRol;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;
    String correElectronicoPersonal;
    String correoElectronicoInstitucional;
    String tipoRol;
    String tipoDocente;
    String contrasena;
    String nombreUsuario;
    Integer validarUsuario;

    public Rol() {
    }
    
    public Rol(Integer idRol, String nombre, String apellidoPaterno, String apellidoMaterno, String correElectronicoPersonal, String correoElectronicoInstitucional, String tipoRol, String tipoDocente, String contrasena, String tipoUsuario) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correElectronicoPersonal = correElectronicoPersonal;
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
        this.tipoRol = tipoRol;
        this.tipoDocente = tipoDocente;
        this.contrasena = contrasena;
        this.nombreUsuario = tipoUsuario;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreElectronicoPersonal() {
        return correElectronicoPersonal;
    }

    public void setCorreElectronicoPersonal(String correElectronicoPersonal) {
        this.correElectronicoPersonal = correElectronicoPersonal;
    }

    public String getCorreoElectronicoInstitucional() {
        return correoElectronicoInstitucional;
    }

    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getTipoDocente() {
        return tipoDocente;
    }

    public void setTipoDocente(String tipoDocente) {
        this.tipoDocente = tipoDocente;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
    
}
