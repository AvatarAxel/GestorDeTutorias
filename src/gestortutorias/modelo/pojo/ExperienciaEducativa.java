 /*Autor: Andrea Alejandra Vargas Pucheta, Jesus Onofre Rodríguez Cortes, Axel Saturnino Mendoza Domingo
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 12/06/2022
 * Descripción: Realiazar los Set/Get de la clase ExperienciaEducativa
 */
package gestortutorias.modelo.pojo;

public class ExperienciaEducativa {
    
        private Integer idExperienciaEducativa;
        private Integer idMateria;
        private String nombreMateria;
        private String descripcionMateria;
        private Integer idRol;
        private String nombreRol;
        private String apellidoPaternoRol;
        private String apellidoMaternoRol;
        private String correoElectronicoInstitucionalRol;
        private String correoElectronicoPersonalRol;
        private Integer nrc;
        private Integer seccion;
        private String salon;
        private String nombreProfesorCompleto;
        private Integer idPeriodoEscolar;

    public ExperienciaEducativa() {
    }

    public ExperienciaEducativa(Integer idExperienciaEducativa, Integer idMateria, String nombreMateria, String descripcionMateria, Integer idRol, String nombreRol, String apellidoPaternoRol, String apellidoMaternoRol, String correoElectronicoInstitucionalRol, String correoElectronicoPersonalRol, Integer nrc, Integer seccion, String salon, String nombreProfesorCompleto, Integer idPeriodoEscolar) {
        this.idExperienciaEducativa = idExperienciaEducativa;
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.descripcionMateria = descripcionMateria;
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.apellidoPaternoRol = apellidoPaternoRol;
        this.apellidoMaternoRol = apellidoMaternoRol;
        this.correoElectronicoInstitucionalRol = correoElectronicoInstitucionalRol;
        this.correoElectronicoPersonalRol = correoElectronicoPersonalRol;
        this.nrc = nrc;
        this.seccion = seccion;
        this.salon = salon;
        this.nombreProfesorCompleto = nombreProfesorCompleto;
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public Integer getIdExperienciaEducativa() {
        return idExperienciaEducativa;
    }

    public void setIdExperienciaEducativa(Integer idExperienciaEducativa) {
        this.idExperienciaEducativa = idExperienciaEducativa;
    }

    public Integer getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Integer idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public String getDescripcionMateria() {
        return descripcionMateria;
    }

    public void setDescripcionMateria(String descripcionMateria) {
        this.descripcionMateria = descripcionMateria;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getApellidoPaternoRol() {
        return apellidoPaternoRol;
    }

    public void setApellidoPaternoRol(String apellidoPaternoRol) {
        this.apellidoPaternoRol = apellidoPaternoRol;
    }

    public String getApellidoMaternoRol() {
        return apellidoMaternoRol;
    }

    public void setApellidoMaternoRol(String apellidoMaternoRol) {
        this.apellidoMaternoRol = apellidoMaternoRol;
    }

    public String getCorreoElectronicoInstitucionalRol() {
        return correoElectronicoInstitucionalRol;
    }

    public void setCorreoElectronicoInstitucionalRol(String correoElectronicoInstitucionalRol) {
        this.correoElectronicoInstitucionalRol = correoElectronicoInstitucionalRol;
    }

    public String getCorreoElectronicoPersonalRol() {
        return correoElectronicoPersonalRol;
    }

    public void setCorreoElectronicoPersonalRol(String correoElectronicoPersonalRol) {
        this.correoElectronicoPersonalRol = correoElectronicoPersonalRol;
    }

    public Integer getNrc() {
        return nrc;
    }

    public void setNrc(Integer nrc) {
        this.nrc = nrc;
    }

    public Integer getSeccion() {
        return seccion;
    }

    public void setSeccion(Integer seccion) {
        this.seccion = seccion;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    public String getNombreProfesorCompleto() {
        return nombreProfesorCompleto;
    }

    public void setNombreProfesorCompleto(String nombreProfesorCompleto) {
        this.nombreProfesorCompleto = nombreProfesorCompleto;
    }

    public Integer getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(Integer idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    @Override
    public String toString() {
        return nombreMateria;
    }
    
}