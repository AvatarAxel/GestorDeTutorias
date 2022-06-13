/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 11/06/2022
 * Fecha de modificación: 12/06/2022
 * Descripción: Obtener información de la base de datos de la Problemtica Academica
 */
package gestortutorias.modelo.dao;
 
import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.ProblematicaAcademica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProblematicaAcademicaDAO {
    
    public static ArrayList<ProblematicaAcademica> obtenerInformacionProblematicaAcademica(int idReporteTutoria){
        ArrayList<ProblematicaAcademica> problematicaAcademicaBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        String consulta = "SELECT materia.nombre, rol.nombre, rol.apellidoPaterno,\n" +
                "rol.apellidoMaterno, problematica.descripcion, problematica.numeroDeEstudiantesAfectados \n" +
                "FROM experiencia_educativa experiencia\n" +
                "INNER JOIN materias materia ON experiencia.idMateria = materia.idMateria\n" +
                "INNER JOIN roles rol ON experiencia.idRol = rol.idRol\n" +
                "INNER JOIN problematica_academica problematica ON experiencia.idProblematica = problematica.idProblematica\n" +
                "WHERE problematica.idReporteTutoria = ?";
        if(conexionBD != null){
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                configurarConsulta.setInt(1, idReporteTutoria);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    ProblematicaAcademica problematicaAcademicaTemp = new ProblematicaAcademica();
                    problematicaAcademicaTemp.setNombreExperienciaEducativa(resultadoConsulta.getString("nombre"));
                    problematicaAcademicaTemp.setNombreCompleto(resultadoConsulta.getString("rol.nombre")+" "+
                            resultadoConsulta.getString("apellidoPaterno")+" "+resultadoConsulta.getString("apellidoMaterno"));
                    problematicaAcademicaTemp.setDescripcionProblematica(resultadoConsulta.getString("descripcion"));
                    problematicaAcademicaTemp.setNumeroDeEstudiantesAfectados(resultadoConsulta.getInt("numeroDeEstudiantesAfectados"));
                    problematicaAcademicaBD.add(problematicaAcademicaTemp);
                }
                conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace(); 
            }
        }else{
            problematicaAcademicaBD = null;
        }
        return problematicaAcademicaBD;
    } 
}
