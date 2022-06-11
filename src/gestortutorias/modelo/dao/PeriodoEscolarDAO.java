/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 09/06/2022
 * Descripción: Realializar las busquedad de la clase PeriodoEscolar
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.PeriodoEscolar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeriodoEscolarDAO { 
    
    //Recupera de la base de datos el último registro del Periodo Escolar
    public static PeriodoEscolar obtenerInformacionPeriodoEscolar(){
        PeriodoEscolar periodoEscolarBD = new PeriodoEscolar();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){         
            try{
                String consulta = "SELECT idPeriodoEscolar ,fechaInicio, fechaFin FROM periodo_escolar "
                        + "WHERE idPeriodoEscolar = (SELECT MAX(idPeriodoEscolar) FROM periodo_escolar);";                
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);            
                ResultSet resultadoConsulta = prepararConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    periodoEscolarBD.setIdPeriodoEscolar(resultadoConsulta.getInt("idPeriodoEscolar"));
                    periodoEscolarBD.setFechaCompleta(resultadoConsulta.getString("fechaInicio") + "-"+ 
                            resultadoConsulta.getString("fechaFin"));
      
                }
                conexionBD.close();        
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
            periodoEscolarBD = null;
        }
        return periodoEscolarBD;
    }
    
    public static ArrayList<PeriodoEscolar> obtenerInformacionDeTodosLosPeriodoEscolar(){
        ArrayList<PeriodoEscolar> periodoEscolarBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){         
            try{
                String consulta = "SELECT idPeriodoEscolar ,fechaInicio, fechaFin FROM periodo_escolar;";                
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);            
                ResultSet resultadoConsulta = prepararConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    PeriodoEscolar periodoEscolarTemp = new PeriodoEscolar();
                    periodoEscolarTemp.setIdPeriodoEscolar(resultadoConsulta.getInt("idPeriodoEscolar"));
                    periodoEscolarTemp.setFechaCompleta(resultadoConsulta.getString("fechaInicio")+"-"+
                            resultadoConsulta.getString("fechaFin"));
                    periodoEscolarBD.add(periodoEscolarTemp);
                }
                conexionBD.close();        
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
            periodoEscolarBD = null;
        }
        return periodoEscolarBD;
    }
    
}
 