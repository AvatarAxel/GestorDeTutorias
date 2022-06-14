/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 11/06/2022
 * Fecha de modificación: 
 * Descripción: Obtener información de la base de datos de la Reporte De Tutoria Academica
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.ReporteDeTutoriaAcademica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReporteDeTutoriaAcademicaDAO {
    
    public static ReporteDeTutoriaAcademica obtenerInformacionReporte(int idReporteTutoria){
        ReporteDeTutoriaAcademica reporteDeTutoriaTemp = new ReporteDeTutoriaAcademica();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        String consulta = "SELECT tutoria.numeroDeSesion, tutoria.fechaTutoria, reporte.idReporteTutoria, \n" +
            "reporte.comentariosGenerales, reporte.programaEducativo, reporte.objetivos, \n" +
            "rol.nombre, rol.apellidoPaterno, rol.apellidoMaterno,\n" +
            "reporte.fechaDeEntrega, reporte.numeroDeEstudiantesQueAsistieron FROM tutoria_academica tutoria\n" +
            "INNER JOIN periodo_escolar periodo ON tutoria.idPeriodoEscolar = periodo.idPeriodoEscolar\n" +
            "INNER JOIN reporte_tutoria_academica reporte ON tutoria.idTutoriaAcademica = reporte.idTutoriaAcademica\n" +
            "INNER JOIN roles rol ON reporte.idRol = rol.idRol\n" +
            "WHERE   reporte.idReporteTutoria = ?;";
        if(conexionBD != null){
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                configurarConsulta.setInt(1, idReporteTutoria);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    reporteDeTutoriaTemp.setNumeroDeSesion(resultadoConsulta.getInt("numeroDeSesion"));
                    reporteDeTutoriaTemp.setFechaTutoria(resultadoConsulta.getString("fechaTutoria"));
                    reporteDeTutoriaTemp.setIdReporteTutoria(resultadoConsulta.getInt("idReporteTutoria"));
                    reporteDeTutoriaTemp.setComentariosGenerales(resultadoConsulta.getString("comentariosGenerales"));
                    reporteDeTutoriaTemp.setProgramaEducativo(resultadoConsulta.getString("programaEducativo"));
                    reporteDeTutoriaTemp.setObjetivos(resultadoConsulta.getString("objetivos"));
                    reporteDeTutoriaTemp.setNombreCompletoTutor(resultadoConsulta.getString("nombre")+" "+
                            resultadoConsulta.getString("apellidoPaterno")+" "+resultadoConsulta.getString("apellidoMaterno"));
                    reporteDeTutoriaTemp.setFechaDeEntrega(resultadoConsulta.getString("fechadeEntrega"));
                    reporteDeTutoriaTemp.setNumeroDeEstudiantesQueAsistieron(resultadoConsulta.getInt("numeroDeEstudiantesQueAsistieron"));
       
                }
                conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            reporteDeTutoriaTemp = null;
        }        
        return reporteDeTutoriaTemp;
    }   
}
