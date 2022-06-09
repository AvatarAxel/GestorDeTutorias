/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 
 * Descripción: Realiazar las consultas que se necesitan para la GUI
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.ExperienciaEducativa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ExperienciaEducativaDAO {
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
                    experienciaEducativaTemp.setNombreMateria(resultadoConsulta.getString("nombreMateria"));
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
   
}
