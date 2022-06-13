/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 11/06/2022
 * Fecha de modificación: 
 * Descripción: Realiazar los Set/Get de la clase Problematica academica
*/
package gestortutorias.modelo.pojo;

public class ProblematicaAcademica {
    private String nombreExperienciaEducativa;
    private String nombreProfesor;
    private String apellidoPaternoProfesor;
    private String apellidoMaternoProfesor;
        private String nombreCompleto;
    private String descripcionProblematica;
    private Integer numeroDeEstudiantesAfectados;
    
    public ProblematicaAcademica() {
    }

    public ProblematicaAcademica(String nombreExperienciaEducativa, String nombreProfesor, String apellidoPaternoProfesor, String apellidoMaternoProfesor, String nombreCompleto, String descripcionProblematica, Integer numeroDeEstudiantesAfectados) {
        this.nombreExperienciaEducativa = nombreExperienciaEducativa;
        this.nombreProfesor = nombreProfesor;
        this.apellidoPaternoProfesor = apellidoPaternoProfesor;
        this.apellidoMaternoProfesor = apellidoMaternoProfesor;
        this.nombreCompleto = nombreCompleto;
        this.descripcionProblematica = descripcionProblematica;
        this.numeroDeEstudiantesAfectados = numeroDeEstudiantesAfectados;
    }

    public String getNombreExperienciaEducativa() {
        return nombreExperienciaEducativa;
    }

    public void setNombreExperienciaEducativa(String nombreExperienciaEducativa) {
        this.nombreExperienciaEducativa = nombreExperienciaEducativa;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getApellidoPaternoProfesor() {
        return apellidoPaternoProfesor;
    }

    public void setApellidoPaternoProfesor(String apellidoPaternoProfesor) {
        this.apellidoPaternoProfesor = apellidoPaternoProfesor;
    }

    public String getApellidoMaternoProfesor() {
        return apellidoMaternoProfesor;
    }

    public void setApellidoMaternoProfesor(String apellidoMaternoProfesor) {
        this.apellidoMaternoProfesor = apellidoMaternoProfesor;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDescripcionProblematica() {
        return descripcionProblematica;
    }

    public void setDescripcionProblematica(String descripcionProblematica) {
        this.descripcionProblematica = descripcionProblematica;
    }

    public Integer getNumeroDeEstudiantesAfectados() {
        return numeroDeEstudiantesAfectados;
    }

    public void setNumeroDeEstudiantesAfectados(Integer numeroDeEstudiantesAfectados) {
        this.numeroDeEstudiantesAfectados = numeroDeEstudiantesAfectados;
    }
}
