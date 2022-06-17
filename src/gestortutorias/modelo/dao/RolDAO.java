/* Autor: Andrea Alejandra Vargas Pucheta, Jesus Onofre Rodriguez Cortes, Axel Saturnino Mendoza Domingo, Obet Jair Hernández González
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 14/06/2022
 * Descripción:Obtener información de la base de datos del Rol
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.Rol;
import gestortutorias.util.Constantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RolDAO {
    
    public static int insertarRol (Rol rolTutor){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        
        if(conexionBD != null){
            try {
                String sentencia = "INSERT INTO roles (nombre, apellidoPaterno, apellidoMaterno, correoElectronicoInstitucional, correoElectronicoPersonal, tipoRol, nombreUsuario, contrasenia, tipoDocente ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(sentencia);
                configurarConsulta.setString(1, rolTutor.getNombre());
                configurarConsulta.setString(2, rolTutor.getApellidoPaterno());
                configurarConsulta.setString(3, rolTutor.getApellidoMaterno());
                configurarConsulta.setString(4, rolTutor.getCorreoElectronicoInstitucional());
                configurarConsulta.setString(5, rolTutor.getCorreoElectronicoInstitucional());
                configurarConsulta.setString(6, rolTutor.getTipoRol());
                configurarConsulta.setString(7, rolTutor.getNombreUsuario());
                configurarConsulta.setString(8, rolTutor.getContrasenia());
                configurarConsulta.setString(9, rolTutor.getTipoDocente());
                int filasAfectadas = configurarConsulta.executeUpdate();
                respuesta = (filasAfectadas == 1) ? Constantes.CODIGO_OPERECION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;
                conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                respuesta = Constantes.CODIGO_ERROR_CONEXIONDB;
            }
        }else{
            respuesta = Constantes.CODIGO_ERROR_CONEXIONDB;
        }
        return respuesta;
    }
    
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
    
    public static int obtenerTotalTutorados(int idRol){
        int totalTutorados = 0;
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
            totalTutorados = 0;
        }   
        return totalTutorados;
    }
    
    public static Rol obtenerInformacionRolesTutor(String correoElectronicoInstitucional, String correoElectronicoPersonal) {
        Rol rolTutorBD = new Rol();
        rolTutorBD.setCorreoElectronicoInstitucional("");
        rolTutorBD.setCorreoElectronicoPersonal("");
        Connection conexionBD = ConexionBD.abrirConexionBD();
        String consulta = "select * from roles where correoElectronicoInstitucional = ? OR correoElectronicoPersonal = ?";
        if (conexionBD != null) {
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                configurarConsulta.setString(1, correoElectronicoInstitucional);
                configurarConsulta.setString(2, correoElectronicoPersonal);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while (resultadoConsulta.next()) {
                    rolTutorBD.setCorreoElectronicoInstitucional(resultadoConsulta.getString("correoElectronicoInstitucional"));
                    rolTutorBD.setCorreoElectronicoPersonal(resultadoConsulta.getString("correoElectronicoPersonal"));
                }
                conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rolTutorBD;
    }
    
    public static Rol buscarTutor(int idRol){
        Rol tutorBuscado = new Rol();
        Connection conexionBD = ConexionBD.abrirConexionBD();
       
        if(conexionBD != null){
        String consulta = "Select * from roles where idRol = ?";
        try{
            PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
            configurarConsulta.setInt(1, idRol);
            ResultSet resultadoConsulta = configurarConsulta.executeQuery();      
            if(resultadoConsulta.next()){
                    tutorBuscado.setIdRol(resultadoConsulta.getInt("idRol"));
                    tutorBuscado.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                    tutorBuscado.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                    tutorBuscado.setNombre(resultadoConsulta.getString("nombre"));
                    tutorBuscado.setNombreCompletoRol(resultadoConsulta.getString("nombre")+" "+
                        resultadoConsulta.getString("apellidoPaterno")+" "+resultadoConsulta.getString("apellidoMaterno")); 
                    tutorBuscado.setCodigoRespuesta(Constantes.CODIGO_OPERECION_CORRECTA);
                }else{
                    tutorBuscado.setCodigoRespuesta(Constantes.CODIGO_CREDENCIALES_INCORRECTAS);
                }
            conexionBD.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        }else{
           tutorBuscado = null;
        }
        return tutorBuscado;
    }
    
    public static ArrayList<Rol> cargarTutores(){
        ArrayList<Rol> tutores = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
         if(conexionBD != null){
        String consulta = "select * from (" +
        "select COUNT(R.nombre) as total, R.idRol, R.nombre, R.apellidoPaterno, "+ 
        "R.apellidoMaterno, R.correoElectronicoInstitucional, R.correoElectronicoPersonal, R.tipoRol From roles R " +
        "left join estudiantes E ON E.idRol = R.idRol  group by R.idRol) roles where total < 30 AND tipoRol != \"Profesor\";";
        try{
            PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
            ResultSet resultadoConsulta = configurarConsulta.executeQuery();
            
            while(resultadoConsulta.next()){
                Rol tutorTemp = new Rol();
                tutorTemp.setIdRol(resultadoConsulta.getInt("idRol"));
                tutorTemp.setNombre(resultadoConsulta.getString("nombre"));          
                tutorTemp.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                tutorTemp.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                tutorTemp.setNombreCompletoRol(tutorTemp.getNombre() +" "+ tutorTemp.getApellidoPaterno() +" "+ tutorTemp.getApellidoMaterno());
                tutorTemp.setCorreoElectronicoInstitucional(resultadoConsulta.getString("correoElectronicoInstitucional"));
                tutorTemp.setCorreoElectronicoPersonal(resultadoConsulta.getString("correoElectronicoPersonal"));         
                tutores.add(tutorTemp);
           }
            conexionBD.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        }else{
           tutores = null;
        }
        return tutores;
    }

    public static Rol iniciarSesion(String correo, String password) {
        Rol tutorLogin = new Rol();
       Connection conexionBD = ConexionBD.abrirConexionBD();
       if(conexionBD != null){
            try {
                String consulta = "SELECT * FROM roles WHERE nombreUsuario = ? AND contrasenia = ?  AND tipoRol != \"Profesor\";";
                PreparedStatement prepararConsulta = conexionBD.prepareStatement(consulta);
                prepararConsulta.setString(1, correo);
                prepararConsulta.setString(2, password);
                ResultSet resultadoConsulta = prepararConsulta.executeQuery();
                if(resultadoConsulta.next()){
                    tutorLogin.setTipoRol(resultadoConsulta.getString("tipoRol"));
                    tutorLogin.setCodigoRespuesta(Constantes.CODIGO_OPERECION_CORRECTA);
                }else{
                    tutorLogin.setCodigoRespuesta(Constantes.CODIGO_CREDENCIALES_INCORRECTAS);
                }
                conexionBD.close();
            }catch(SQLException e) {
                tutorLogin.setCodigoRespuesta(Constantes.CODIGO_ERROR_CONEXIONDB);  
                e.printStackTrace();
           }
        }else{
          tutorLogin.setCodigoRespuesta(Constantes.CODIGO_ERROR_CONEXIONDB);
       }
        return tutorLogin;
    }

}
