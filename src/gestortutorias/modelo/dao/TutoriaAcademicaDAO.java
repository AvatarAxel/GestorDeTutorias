/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 10/06/2022
 * Fecha de modificación: 
 * Descripción: Recuperar información de la clase Tutoria Academico
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.TutoriaAcademica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TutoriaAcademicaDAO {
    
    public static ArrayList<TutoriaAcademica> obtenerInformacionTutoriaAcademicas(){
        ArrayList<TutoriaAcademica> tutoriaAcademicaBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        String consulta = "SELECT idTutoriaAcademica, numeroDeSesion, fechaTutoria FROM tutoria_academica;";
        if(conexionBD != null){
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    TutoriaAcademica tutoriaAcademicaTemp = new TutoriaAcademica();
                    tutoriaAcademicaTemp.setIdTutoriaAcademica(resultadoConsulta.getInt("idTutoriaAcademica"));
                    tutoriaAcademicaTemp.setNumeroDeSesion(resultadoConsulta.getInt("numeroDeSesion"));
                    tutoriaAcademicaTemp.setFechaTutoria(resultadoConsulta.getString("fechaTutoria"));
                    tutoriaAcademicaBD.add(tutoriaAcademicaTemp);
                }
                conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            tutoriaAcademicaBD = null;
        }
        
        return tutoriaAcademicaBD;
    }
    
}
