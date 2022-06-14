/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 10/06/2022
 * Fecha de modificación: 11/06/2022
 * Descripción: Tener los Set/Get de la clase TuroiaAcademica
 */
package gestortutorias.modelo.pojo;

public class TutoriaAcademica {
    private Integer idTutoriaAcademica;
    private Integer numeroDeSesion;
    private String fechaTutoria;
    private Integer idPeriodoEscolar;
    private Integer fechaInicio;
    private Integer fechaFin;
    private Integer idReporteTutoria;
    private Integer idRolDeReporte;

    public TutoriaAcademica() {
    }

    public TutoriaAcademica(Integer idTutoriaAcademica, Integer numeroDeSesion, String fechaTutoria, Integer idPeriodoEscolar, Integer fechaInicio, Integer fechaFin, Integer idReporteTutoria, Integer idRolDeReporte) {
        this.idTutoriaAcademica = idTutoriaAcademica;
        this.numeroDeSesion = numeroDeSesion;
        this.fechaTutoria = fechaTutoria;
        this.idPeriodoEscolar = idPeriodoEscolar;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.idReporteTutoria = idReporteTutoria;
        this.idRolDeReporte = idRolDeReporte;
    }

    public Integer getIdTutoriaAcademica() {
        return idTutoriaAcademica;
    }

    public void setIdTutoriaAcademica(Integer idTutoriaAcademica) {
        this.idTutoriaAcademica = idTutoriaAcademica;
    }

    public Integer getNumeroDeSesion() {
        return numeroDeSesion;
    }

    public void setNumeroDeSesion(Integer numeroDeSesion) {
        this.numeroDeSesion = numeroDeSesion;
    }

    public String getFechaTutoria() {
        return fechaTutoria;
    }

    public void setFechaTutoria(String fechaTutoria) {
        this.fechaTutoria = fechaTutoria;
    }

    public Integer getIdPeriodoEscolar() {
        return idPeriodoEscolar;
    }

    public void setIdPeriodoEscolar(Integer idPeriodoEscolar) {
        this.idPeriodoEscolar = idPeriodoEscolar;
    }

    public Integer getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Integer fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Integer fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Integer getIdReporteTutoria() {
        return idReporteTutoria;
    }

    public void setIdReporteTutoria(Integer idReporteTutoria) {
        this.idReporteTutoria = idReporteTutoria;
    }

    public Integer getIdRolDeReporte() {
        return idRolDeReporte;
    }

    public void setIdRolDeReporte(Integer idRolDeReporte) {
        this.idRolDeReporte = idRolDeReporte;
    } 
}
