<<<<<<< HEAD
=======
/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 10/06/2022
 * Descripción:Obtener información de la base de datos del Rol
 */
>>>>>>> 250ac05d66657c54d9192e88ed6223dd656f22c5
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RolDAO {
    
<<<<<<< HEAD
    public static ArrayList<Rol> obtenerInformacionTutor(){
        ArrayList<Rol> rolBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            String consulta = "select idRol, nombre, apellidoPaterno, apellidoMaterno from roles where tipoRol = 'Tutor';";
            try{
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    Rol rolTemp = new Rol();
                    rolTemp.setIdRol(resultadoConsulta.getInt("idRol"));
                    rolTemp.setNombreCompletoRol(resultadoConsulta.getString("nombre")+" "+resultadoConsulta.getString("apellidoPaterno")+" "+resultadoConsulta.getString("apellidoMaterno"));
                    rolBD.add(rolTemp);
                }
                conexionBD.close();
=======
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
>>>>>>> 250ac05d66657c54d9192e88ed6223dd656f22c5
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
<<<<<<< HEAD
            rolBD = null;
        }
        return rolBD;
    } 
    
    public static int obtenerTotalTutorados(int idRol){
        int totalTutorados = -1;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        String consulta = "select count(*) as totalTutorados FROM estudiantes WHERE idRol = ?;";
        if(conexionBD != null){
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                configurarConsulta.setInt(1, idRol);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    totalTutorados = resultadoConsulta.getInt("totalTutorados");
                }
                conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }else{
            totalTutorados = -1;
        }   
        return totalTutorados;
    }
    
=======
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
>>>>>>> 250ac05d66657c54d9192e88ed6223dd656f22c5
}
