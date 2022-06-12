/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 10/06/2022
 * Descripción:Obtener información de la base de datos del Rol
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RolDAO {
    
    public static ArrayList<Rol> obtenerInformacionProfesor(){
        ArrayList<Rol> rolesBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){         
            try{
                String consulta = "SELECT idRol, nombre, apellidoPaterno, apellidoMaterno FROM roles;";                
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);            
                ResultSet resultadoConsulta = prepararConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    Rol rolTemp = new Rol();
                    rolTemp.setIdRol(resultadoConsulta.getInt("idRol"));
                    rolTemp.setNombreCompletoRol(resultadoConsulta.getString("nombre")+" "+
                            resultadoConsulta.getString("apellidoPaterno")+" "+resultadoConsulta.getString("apellidoMaterno"));
                    rolesBD.add(rolTemp);
                }
                conexionBD.close();        
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
            rolesBD = null;
        }
        return rolesBD;
    }
    
    //Obtener la información exclusivamente de aquellos que son Tutores
    public static ArrayList<Rol> obtenerInformacionTutor(){
        ArrayList<Rol> rolesBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){         
            try{
                String consulta = "SELECT idRol, nombre, apellidoPaterno, apellidoMaterno FROM roles WHERE tipoRol = 'Tutor';";                
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);            
                ResultSet resultadoConsulta = prepararConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    Rol rolTemp = new Rol();
                    rolTemp.setIdRol(resultadoConsulta.getInt("idRol"));
                    rolTemp.setNombreCompletoRol(resultadoConsulta.getString("nombre")+" "+
                            resultadoConsulta.getString("apellidoPaterno")+" "+resultadoConsulta.getString("apellidoMaterno"));
                    rolesBD.add(rolTemp);
                }
                conexionBD.close();        
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
            rolesBD = null;
        }
        return rolesBD;
    }   
}
