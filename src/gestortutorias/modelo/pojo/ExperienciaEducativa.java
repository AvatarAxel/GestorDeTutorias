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
public class ExperienciaEducativa {
    Integer idExperienciaEducativa;
    String nombre;
    Integer nrc;
    Integer seccion;
    String salon;
    Integer idRol;
    String nombreProfesor;
    Integer idPeriodoEscolar;

    public ExperienciaEducativa() {
    }

    public ExperienciaEducativa(Integer idExperienciaEducativa, String nombre, Integer nrc, Integer seccion, String salon, Integer idRol, String nombreProfesor, Integer idPeriodoEscolar) {
        this.idExperienciaEducativa = idExperienciaEducativa;
        this.nombre = nombre;
        this.nrc = nrc;
        this.seccion = seccion;
        this.salon = salon;
        this.idRol = idRol;
        this.nombreProfesor = nombreProfesor;
        this.idPeriodoEscolar = idPeriodoEscolar;
    }


    public Integer getIdExperienciaEducativa() {
        return idExperienciaEducativa;
    }

    public void setIdExperienciaEducativa(Integer idExperienciaEducativa) {
        this.idExperienciaEducativa = idExperienciaEducativa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public Integer getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(Integer idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }
    
    
}
