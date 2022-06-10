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
    public static PeriodoEscolar obtenerInformacionPeriodoEscolar(){
        PeriodoEscolar periodoEscolarBD = new PeriodoEscolar();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){         
            try{
                String consulta = "SELECT idPeriodoEscolar ,fechaInicio, fechaFin FROM periodo_escolar;";                
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
    
}
 