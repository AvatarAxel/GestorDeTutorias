/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.pojo.Estudiante;
import gestortutorias.modelo.pojo.Tutor;
import gestortutorias.util.CONSTANTES;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ConexionBD;

/**
 *
 * @author LENOVO
 */
public class TutorDAO {
    
    
    public static Tutor buscarTutor(int idRol){
        Tutor tutorBuscado = new Tutor();
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
                            tutorBuscado.setCodigoRespuesta(CONSTANTES.CODIGO_OPERECION_CORRECTA);
                }else{
                    tutorBuscado.setCodigoRespuesta(CONSTANTES.CODIGO_CREDENCIALES_INCORRECTAS);
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
    
    public static ArrayList<Tutor> cargarTutores(){
        ArrayList<Tutor> tutores = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
         if(conexionBD != null){
        String consulta = "select * from (" +
        "select COUNT(R.nombre) as total, R.idRol, R.nombre, R.apellidoPaterno, "+ 
        "R.apellidoMaterno, R.correoElectronicoInstitucional, R.correoElectronicoPersonal, R.tipoRol From roles R " +
        "left join estudiantes E ON E.idRol = R.idRol  group by R.nombre) roles where total < 20 AND tipoRol != \"Profesor\";";
        try{
            PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
            ResultSet resultadoConsulta = configurarConsulta.executeQuery();
            
            while(resultadoConsulta.next()){
                Tutor tutorTemp = new Tutor();
                tutorTemp.setIdRol(resultadoConsulta.getInt("idRol"));
                tutorTemp.setNombre(resultadoConsulta.getString("nombre"));          
                tutorTemp.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                tutorTemp.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
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

    public static Tutor iniciarSesion(String correo, String password) {
        Tutor tutorLogin = new Tutor();
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
                    tutorLogin.setCodigoRespuesta(CONSTANTES.CODIGO_OPERECION_CORRECTA);
                }else{
                    tutorLogin.setCodigoRespuesta(CONSTANTES.CODIGO_CREDENCIALES_INCORRECTAS);
                }
                conexionBD.close();
            }catch(SQLException e) {
                tutorLogin.setCodigoRespuesta(CONSTANTES.CODIGO_ERROR_CONEXIONDB);  
                e.printStackTrace();
           }
        }else{
          tutorLogin.setCodigoRespuesta(CONSTANTES.CODIGO_ERROR_CONEXIONDB);
       }
        return tutorLogin;
    }
}
