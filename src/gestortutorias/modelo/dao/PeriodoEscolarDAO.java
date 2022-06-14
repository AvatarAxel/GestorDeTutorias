/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.PeriodoEscolar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author je_zu
 */
public class PeriodoEscolarDAO {
   
    public static ArrayList obtenerInformacionPeriodoEscolar(){
        ArrayList<PeriodoEscolar> periodosEscolaresBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        String consulta = "select idPeriodoEscolar, clave, fechaInicio, fechaFin from periodo_escolar;";
        
        if(conexionBD != null){
            try {
               PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
               ResultSet resultadoConsulta = configurarConsulta.executeQuery();
               
               while(resultadoConsulta.next()){
                   PeriodoEscolar periodoEscolarTemp = new PeriodoEscolar();
                   periodoEscolarTemp.setIdPeriodo(resultadoConsulta.getInt("idPeriodoEscolar"));
                   periodoEscolarTemp.setClave(resultadoConsulta.getInt("clave"));
                   periodoEscolarTemp.setFechaInicio(resultadoConsulta.getString("fechaInicio"));
                   periodoEscolarTemp.setFechaFin(resultadoConsulta.getString("fechaFin"));
                   periodosEscolaresBD.add(periodoEscolarTemp);
               }
               conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            periodosEscolaresBD = null;
        }
        
        return periodosEscolaresBD;
    }
    
}
