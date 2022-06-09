/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 
 * Descripción: Realiazar los Set/Get de la clase experiencia_educativa
 */
package gestortutorias.modelo.pojo;


public class ExperienciaEducativa {
    
    private Integer idExperienciaEducativa;
    //private Integer nrc;
    //private Integer seccion;
    //private String modalidad;
    //private String salon;
    //private Integer idProblematica;
    private Integer idMateria;
        private String nombreMateria;
        private String descripcionMateria;
    private Integer idRol;
        private String nombreRol;
        private String apelligoPaternoRol;
        private String apellidoMaternoRol;
        private String correoElectronicoInstitucionalRol;
        private String correoElectronicoPersonalRol;

    public ExperienciaEducativa() {
    }

    public ExperienciaEducativa(Integer idExperienciaEducativa, Integer idMateria, String nombreMateria, String descripcionMateria, Integer idRol, String nombreRol, String apelligoPaternoRol, String apellidoMaternoRol, String correoElectronicoInstitucionalRol, String correoElectronicoPersonalRol) {
        this.idExperienciaEducativa = idExperienciaEducativa;
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.descripcionMateria = descripcionMateria;
        this.idRol = idRol;
        this.nombreRol = nombreRol;
        this.apelligoPaternoRol = apelligoPaternoRol;
        this.apellidoMaternoRol = apellidoMaternoRol;
        this.correoElectronicoInstitucionalRol = correoElectronicoInstitucionalRol;
        this.correoElectronicoPersonalRol = correoElectronicoPersonalRol;
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

    public String getApelligoPaternoRol() {
        return apelligoPaternoRol;
    }

    public void setApelligoPaternoRol(String apelligoPaternoRol) {
        this.apelligoPaternoRol = apelligoPaternoRol;
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
    
}
