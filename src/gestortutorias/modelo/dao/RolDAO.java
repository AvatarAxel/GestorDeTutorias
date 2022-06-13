/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author je_zu
 */
public class RolDAO {
    public static int insertarRol (Rol rolTutor){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        
        if(conexionBD != null){
            try {
                String sentencia = "INSERT INTO roles (nombre, apelligoPaterno, apellidoMaterno, correoElectronicoInstitucional, correoElectronicoPersonal, tipoRol, nombreUsuario, contrasenia, tipoDocente ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(sentencia);
                configurarConsulta.setString(1, rolTutor.getNombre());
                configurarConsulta.setString(2, rolTutor.getApellidoPaterno());
                configurarConsulta.setString(3, rolTutor.getApellidoMaterno());
                configurarConsulta.setString(4, rolTutor.getCorreoElectronicoInstitucional());
                configurarConsulta.setString(5, rolTutor.getCorreElectronicoPersonal());
                configurarConsulta.setString(6, rolTutor.getTipoRol());
                configurarConsulta.setString(7, rolTutor.getNombreUsuario());
                configurarConsulta.setString(8, rolTutor.getContrasena());
                configurarConsulta.setString(9, rolTutor.getTipoDocente());
                int filasAfectadas = configurarConsulta.executeUpdate();
                respuesta = (filasAfectadas == 1) ? Constantes.CODIGO_OPERACION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;
                conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                respuesta = Constantes.COODIGO_ERROR_CONEXIONBD;
            }
        }else{
            respuesta = Constantes.COODIGO_ERROR_CONEXIONBD;
        }
        return respuesta;
    }
    
    public static Rol obtenerInformacionRolesTutor(String correoElectronicoInstitucional){
        Rol rolTutorBD = new Rol();
        rolTutorBD.setCorreoElectronicoInstitucional("");
        Connection conexionBD = ConexionBD.abrirConexionBD();git 
        String consulta = "select * from roles where correoElectronicoInstitucional = ?";
        
        if(conexionBD != null){
            try {
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                configurarConsulta.setString(1, correoElectronicoInstitucional);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    rolTutorBD.setCorreoElectronicoInstitucional(resultadoConsulta.getString("correoElectronicoInstitucional"));
                }
                conexionBD.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rolTutorBD;
    }
}
