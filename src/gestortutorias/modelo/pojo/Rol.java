 /* Autor: Andrea Alejandra Vargas Pucheta, Axel Saturnino Mendoza Axel, Jesus Onofre Rodriguez Cortes, Obet Jair Hernández González
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 10/06/2022
 * Descripción: Realiazar los Set/Get de la clase Rol 
 */
package gestortutorias.modelo.pojo;

public class Rol {
  
    private Integer idRol;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correoElectronicoInstitucional;
    private String correoElectronicoPersonal;
    private String tipoRol;
    private String nombreUsuario;
    private String contrasenia;
    private String nombreCompletoRol;
    private Integer totalTutorados;
    private String tipoDocente;
    private Integer codigoRespuesta;

    public Rol() {
    }

    public Rol(Integer idRol, String nombre, String apellidoPaterno, String apellidoMaterno, String correoElectronicoInstitucional, String correoElectronicoPersonal, String tipoRol, String nombreUsuario, String contrasenia, String nombreCompletoRol, Integer totalTutorados, String tipoDocente,Integer codigoRespuesta) {
        this.idRol = idRol;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correoElectronicoInstitucional = correoElectronicoInstitucional;
        this.correoElectronicoPersonal = correoElectronicoPersonal;
        this.tipoRol = tipoRol;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
        this.nombreCompletoRol = nombreCompletoRol;
        this.totalTutorados = totalTutorados;
        this.tipoDocente = tipoDocente;
        this.codigoRespuesta = codigoRespuesta;
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

    public Integer getTotalTutorados() {
        return totalTutorados;
    }

    public void setTotalTutorados(Integer totalTutorados) {
        this.totalTutorados = totalTutorados;
    }

    public String getTipoDocente() {
        return tipoDocente;
    }

    public void setTipoDocente(String tipoDocente) {
        this.tipoDocente = tipoDocente;
    }

    public Integer getCodigoRespuesta() {
        return codigoRespuesta;
    }

    public void setCodigoRespuesta(Integer codigoRespuesta) {
        this.codigoRespuesta = codigoRespuesta;
    }
    
    
    @Override
    public String toString() {
        return nombreCompletoRol;
    }

}
