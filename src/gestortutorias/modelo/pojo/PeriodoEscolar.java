 /* Autor: Andrea Alejandra Vargas Pucheta, Jesus Onofre Rodríguez Cortes, Axel Saturnino Mendoza Domingo
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 14/06/2022
 * Descripción: Realiazar los Set/Get de la clase PeriodoEscolar
 */
package gestortutorias.modelo.pojo;

public class PeriodoEscolar {
    
    private Integer idPeriodoEscolar;
    private Integer clave;
    private String fechaInicio;
    private String fechaFin;
    private String fechaCompleta;

    public PeriodoEscolar() {
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

    public String getFechaCompleta() {
        return fechaCompleta;
    }

    public void setFechaCompleta(String fechaCompleta) {
        this.fechaCompleta = fechaCompleta;
    }

    @Override
    public String toString() {
        return  fechaCompleta;
    }
}
