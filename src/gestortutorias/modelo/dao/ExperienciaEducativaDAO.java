/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.ExperienciaEducativa;
import gestortutorias.modelo.pojo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author je_zu
 */
public class ExperienciaEducativaDAO {
    
    public static ArrayList obtenerInformacionExperienciasEducativas(){
        ArrayList<ExperienciaEducativa> experienciasEducativasBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        String consulta = "SELECT idExperienciaEducativa, materias.nombre, roles.idRol,concat_ws(' ', roles.nombre, roles.apellidoPaterno, roles.apellidoMaterno) AS nombreProfesor,nrc, seccion, salon, experiencia_educativa.idPeriodoEscolar FROM experiencia_educativa INNER JOIN periodo_escolar ON experiencia_educativa.IdPeriodoEscolar = periodo_escolar.IdPeriodoEscolar INNER JOIN materias ON experiencia_educativa.idExperienciaEducativa = materias.idMateria INNER JOIN roles ON roles.idRol = experiencia_educativa.idRol;";
        
        if(conexionBD != null){
            try {
               PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
               ResultSet resultadoConsulta = configurarConsulta.executeQuery();
               while(resultadoConsulta.next()){
                   ExperienciaEducativa experienciaEducativaTemp = new ExperienciaEducativa();
                   experienciaEducativaTemp.setIdExperienciaEducativa(resultadoConsulta.getInt("idExperienciaEducativa"));
                   experienciaEducativaTemp.setNombre(resultadoConsulta.getString("nombre"));
                   experienciaEducativaTemp.setIdRol(resultadoConsulta.getInt("idRol"));
                   experienciaEducativaTemp.setNombreProfesor(resultadoConsulta.getString("nombreProfesor"));
                   experienciaEducativaTemp.setNrc(resultadoConsulta.getInt("nrc"));
                   experienciaEducativaTemp.setSeccion(resultadoConsulta.getInt("seccion"));
                   experienciaEducativaTemp.setSalon(resultadoConsulta.getString("salon"));
                   experienciaEducativaTemp.setIdPeriodoEscolar(resultadoConsulta.getInt("idPeriodoEscolar"));
                   experienciasEducativasBD.add(experienciaEducativaTemp);
               }
               conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            experienciasEducativasBD = null;
        }
        return experienciasEducativasBD;
    }
    
    public static ArrayList obtenerInformacionExperienciasEducativasFiltradas(Integer idPeriodoEscolar){
        ArrayList<ExperienciaEducativa> experienciasEducativasBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        String consulta = "SELECT idExperienciaEducativa, materias.nombre, roles.idRol,concat_ws(' ', roles.nombre, roles.apellidoPaterno, roles.apellidoMaterno) AS nombreProfesor,nrc, seccion, salon, experiencia_educativa.idPeriodoEscolar FROM experiencia_educativa INNER JOIN periodo_escolar ON experiencia_educativa.IdPeriodoEscolar = periodo_escolar.IdPeriodoEscolar INNER JOIN materias ON experiencia_educativa.idExperienciaEducativa = materias.idMateria INNER JOIN roles ON roles.idRol = experiencia_educativa.idRol where experiencia_educativa.idPeriodoEscolar = ?;";
        
        if(conexionBD != null){
            try {
               PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
               configurarConsulta.setInt(1, idPeriodoEscolar);
               ResultSet resultadoConsulta = configurarConsulta.executeQuery();
               while(resultadoConsulta.next()){
                   ExperienciaEducativa experienciaEducativaTemp = new ExperienciaEducativa();
                   experienciaEducativaTemp.setIdExperienciaEducativa(resultadoConsulta.getInt("idExperienciaEducativa"));
                   experienciaEducativaTemp.setNombre(resultadoConsulta.getString("nombre"));
                   experienciaEducativaTemp.setIdRol(resultadoConsulta.getInt("idRol"));
                   experienciaEducativaTemp.setNombreProfesor(resultadoConsulta.getString("nombreProfesor"));
                   experienciaEducativaTemp.setNrc(resultadoConsulta.getInt("nrc"));
                   experienciaEducativaTemp.setSeccion(resultadoConsulta.getInt("seccion"));
                   experienciaEducativaTemp.setSalon(resultadoConsulta.getString("salon"));
                   experienciaEducativaTemp.setIdPeriodoEscolar(resultadoConsulta.getInt("idPeriodoEscolar"));
                   experienciasEducativasBD.add(experienciaEducativaTemp);
               }
               conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            experienciasEducativasBD = null;
        }
        return experienciasEducativasBD;
    }
    
    
}
