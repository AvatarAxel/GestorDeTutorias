/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 
 * Descripción: Realiazar los Set/Get de la clase Rol
 */
package gestortutorias.modelo.pojo;


public class Rol {
    
    private Integer idRol;
    private String nombre;
    private String apelligoPaterno;
    private String apellidoMaterno;
    private String correoElectronicoInstitucional;
    private String correoElectronicoPersonal;
    private String tipoRol;
    private String nombreUsuario;
    private String contrasenia;
    private String nombreCompletoRol;

    public Rol() {
    }

    public Rol(Integer idRol, String nombre, String apelligoPaterno, String apellidoMaterno, String correoElectronicoInstitucional, String correoElectronicoPersonal, String tipoRol, String nombreUsuario, String contrasenia, String nombreCompletoRol) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.apelligoPaterno = apelligoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
        this.correoElectronicoPersonal = correoElectronicoPersonal;
        this.tipoRol = tipoRol;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombreCompletoRol = nombreCompletoRol;
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

    public String getApelligoPaterno() {
        return apelligoPaterno;
    }

    public void setApelligoPaterno(String apelligoPaterno) {
        this.apelligoPaterno = apelligoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreoElectronicoInstitucional() {
        return correoElectronicoInstitucional;
    }

    public void setCorreoElectronicoInstitucional(String correoElectronicoInstitucional) {
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
    }

    public String getCorreoElectronicoPersonal() {
        return correoElectronicoPersonal;
    }

    public void setCorreoElectronicoPersonal(String correoElectronicoPersonal) {
        this.correoElectronicoPersonal = correoElectronicoPersonal;
    }

    public String getTipoRol() {
        return tipoRol;
    }

    public void setTipoRol(String tipoRol) {
        this.tipoRol = tipoRol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getNombreCompletoRol() {
        return nombreCompletoRol;
    }

    public void setNombreCompletoRol(String nombreCompletoRol) {
        this.nombreCompletoRol = nombreCompletoRol;
    }

    @Override
    public String toString() {
        return nombreCompletoRol;
    }
}
