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
public class PeriodoEscolar {
    Integer idPeriodo;
    Integer clave;
    String fechaInicio;
    String fechaFin;

    public PeriodoEscolar() {
    }

    public PeriodoEscolar(Integer idPeriodo, Integer clave, String fechaInicio, String fechaFin) {
        this.idPeriodo = idPeriodo;
        this.clave = clave;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Integer getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(Integer idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getClave() {
        return clave;
    }

    public void setClave(Integer clave) {
        this.clave = clave;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return  fechaInicio +" - "+ fechaFin; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}


