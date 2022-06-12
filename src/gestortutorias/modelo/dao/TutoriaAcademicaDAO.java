/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 10/06/2022
 * Fecha de modificación: 11/06/2022
 * Descripción: Obtener información de la base de datos de la Reporte De Tutoria Academica
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
    
    public static ArrayList<TutoriaAcademica> obtenerInformacionTutoriaAcademicas(int idRol, int idPeriodoEscolar){
        ArrayList<TutoriaAcademica> tutoriaAcademicaBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        String consulta = "SELECT tutoria.idTutoriaAcademica, tutoria.numeroDeSesion, tutoria.fechaTutoria, reporte.idReporteTutoria\n" +
                "FROM tutoria_academica tutoria\n" +
                "INNER JOIN periodo_escolar periodo ON tutoria.idPeriodoEscolar = periodo.idPeriodoEscolar\n" +
                "INNER JOIN reporte_tutoria_academica reporte ON tutoria.idTutoriaAcademica = reporte.idTutoriaAcademica\n" +
                "WHERE  reporte.idRol = ?  and periodo.idPeriodoEscolar = ?;";
        if(conexionBD != null){
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                configurarConsulta.setInt(1, idRol);
                configurarConsulta.setInt(2, idPeriodoEscolar);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    TutoriaAcademica tutoriaAcademicaTemp = new TutoriaAcademica();
                    tutoriaAcademicaTemp.setIdTutoriaAcademica(resultadoConsulta.getInt("idTutoriaAcademica"));
                    tutoriaAcademicaTemp.setNumeroDeSesion(resultadoConsulta.getInt("numeroDeSesion"));
                    tutoriaAcademicaTemp.setFechaTutoria(resultadoConsulta.getString("fechaTutoria"));
                    tutoriaAcademicaTemp.setIdReporteTutoria(resultadoConsulta.getInt("idReporteTutoria"));
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
