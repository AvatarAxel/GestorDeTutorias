/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 09/06/2022
 * Descripción: Obtener información de la base de datos de la Reporte De Experiencia Educativa 
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.ExperienciaEducativa;
import gestortutorias.util.Constantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExperienciaEducativaDAO {
    
    //Recuperar información útil de las ExperienciaEducativas
    public static ArrayList<ExperienciaEducativa> obtenerInformacionExperienciaEducativa(){
        ArrayList<ExperienciaEducativa> experienciaEducativaBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){         
            try{
                String consulta = "SELECT idExperienciaEducativa, materias.nombre FROM experiencia_educativa\n"+
                    "INNER JOIN materias on experiencia_educativa.idMateria = materias.idMateria  "
                        + "WHERE idRol is NULL;";                
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);            
                ResultSet resultadoConsulta = prepararConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    ExperienciaEducativa experienciaEducativaTemp = new  ExperienciaEducativa();
                    experienciaEducativaTemp.setIdExperienciaEducativa(resultadoConsulta.getInt("idExperienciaEducativa"));
                    experienciaEducativaTemp.setNombreMateria(resultadoConsulta.getString("nombre"));
                    experienciaEducativaBD.add(experienciaEducativaTemp);
                }
                conexionBD.close();        
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
            experienciaEducativaBD = null;
        }
        return experienciaEducativaBD;
    }
    
    //Crear la asignación entre el idExperienciaEducativa de la clase experiencia_educativa 
    //con idRol de la clase roles
    public static int asignarExperienciaARol(int idExpericiaEducatica, int idRol){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try {
                String sentencia = "UPDATE experiencia_educativa SET idRol = ? WHERE idExperienciaEducativa=?;";
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(sentencia);
                configurarConsulta.setInt(1,idRol);
                configurarConsulta.setInt(2,idExpericiaEducatica);
                int filasAfectadas = configurarConsulta.executeUpdate();
                respuesta = (filasAfectadas == 1) ? Constantes.CODIGO_OPERECION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;
                conexionBD.close();
            }catch (SQLException e){
                e.printStackTrace();
                respuesta = Constantes.CODIGO_ERROR_CONEXIONDB;
            }
        }else{
            respuesta = Constantes.CODIGO_OPERECION_CORRECTA;
        }
        return respuesta;
    }
   
}
