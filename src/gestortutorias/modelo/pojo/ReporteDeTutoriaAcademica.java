/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 11/06/2022
 * Fecha de modificación: 
 * Descripción: Realiazar los Set/Get de la clase Reporte De Tutoria Academica
 */
package gestortutorias.modelo.pojo;

public class ReporteDeTutoriaAcademica {
    private Integer idReporteTutoria;
    private String fechaTutoria;
    private Integer numeroDeSesion;
    private String comentariosGenerales;
    private String programaEducativo;
    private String objetivos;
    private String nombreTutor;
    private String apellidoPaternoTutor;
    private String apellidoMaternoTutor;
       private String nombreCompletoTutor;
    private String fechaDeEntrega;
    private Integer numeroDeEstudiantesQueAsistieron;

    public ReporteDeTutoriaAcademica() {
    }

    public ReporteDeTutoriaAcademica(Integer idReporteTutoria, String fechaTutoria, Integer numeroDeSesion, String comentariosGenerales, String programaEducativo, String objetivos, String nombreTutor, String apellidoPaternoTutor, String apellidoMaternoTutor, String nombreCompletoTutor, String fechaDeEntrega, Integer numeroDeEstudiantesQueAsistieron) {
        this.idReporteTutoria = idReporteTutoria;
        this.fechaTutoria = fechaTutoria;
        this.numeroDeSesion = numeroDeSesion;
        this.comentariosGenerales = comentariosGenerales;
        this.programaEducativo = programaEducativo;
        this.objetivos = objetivos;
        this.nombreTutor = nombreTutor;
        this.apellidoPaternoTutor = apellidoPaternoTutor;
        this.apellidoMaternoTutor = apellidoMaternoTutor;
        this.nombreCompletoTutor = nombreCompletoTutor;
        this.fechaDeEntrega = fechaDeEntrega;
        this.numeroDeEstudiantesQueAsistieron = numeroDeEstudiantesQueAsistieron;
    }

    public Integer getIdReporteTutoria() {
        return idReporteTutoria;
    }

    public void setIdReporteTutoria(Integer idReporteTutoria) {
        this.idReporteTutoria = idReporteTutoria;
    }

    public String getFechaTutoria() {
        return fechaTutoria;
    }

    public void setFechaTutoria(String fechaTutoria) {
        this.fechaTutoria = fechaTutoria;
    }

    public Integer getNumeroDeSesion() {
        return numeroDeSesion;
    }

    public void setNumeroDeSesion(Integer numeroDeSesion) {
        this.numeroDeSesion = numeroDeSesion;
    }

    public String getComentariosGenerales() {
        return comentariosGenerales;
    }

    public void setComentariosGenerales(String comentariosGenerales) {
        this.comentariosGenerales = comentariosGenerales;
    }

    public String getProgramaEducativo() {
        return programaEducativo;
    }

    public void setProgramaEducativo(String programaEducativo) {
        this.programaEducativo = programaEducativo;
    }

    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

    public String getNombreTutor() {
        return nombreTutor;
    }

    public void setNombreTutor(String nombreTutor) {
        this.nombreTutor = nombreTutor;
    }

    public String getApellidoPaternoTutor() {
        return apellidoPaternoTutor;
    }

    public void setApellidoPaternoTutor(String apellidoPaternoTutor) {
        this.apellidoPaternoTutor = apellidoPaternoTutor;
    }

    public String getApellidoMaternoTutor() {
        return apellidoMaternoTutor;
    }

    public void setApellidoMaternoTutor(String apellidoMaternoTutor) {
        this.apellidoMaternoTutor = apellidoMaternoTutor;
    }

    public String getNombreCompletoTutor() {
        return nombreCompletoTutor;
    }

    public void setNombreCompletoTutor(String nombreCompletoTutor) {
        this.nombreCompletoTutor = nombreCompletoTutor;
    }

    public String getFechaDeEntrega() {
        return fechaDeEntrega;
    }

    public void setFechaDeEntrega(String fechaDeEntrega) {
        this.fechaDeEntrega = fechaDeEntrega;
    }

    public Integer getNumeroDeEstudiantesQueAsistieron() {
        return numeroDeEstudiantesQueAsistieron;
    }

    public void setNumeroDeEstudiantesQueAsistieron(Integer numeroDeEstudiantesQueAsistieron) {
        this.numeroDeEstudiantesQueAsistieron = numeroDeEstudiantesQueAsistieron;
    }
}
