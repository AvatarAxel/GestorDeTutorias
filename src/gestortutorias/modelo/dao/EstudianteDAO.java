/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestortutorias.modelo.dao;

import gestortutorias.modelo.pojo.Estudiante;
import gestortutorias.util.CONSTANTES;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.ConexionBD;

/**
 *
 * @author blackcat
 */
public class EstudianteDAO {
    
    public static ArrayList<Estudiante> busquedaEstudiantes (String busqueda){
        ArrayList<Estudiante> estudiantesBuscados = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
        String consulta = "Select * "
                + "From estudiantes where nombre like \""+busqueda+"%\" "
                + "or apellidoMaterno like \""+busqueda+"%\" "
                + "or apellidoPaterno like \""+busqueda+"%\" "
                + "or matricula like \""+busqueda+"%\";";
        try{
            PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
            //configurarConsulta.setString(0, busqueda);
            ResultSet resultadoConsulta = configurarConsulta.executeQuery();
            while(resultadoConsulta.next()){
                Estudiante estudianteTemp = new Estudiante();
                estudianteTemp.setIdEstudiante(resultadoConsulta.getInt("idEstudiante"));
                estudianteTemp.setNombre(resultadoConsulta.getString("nombre"));
                estudianteTemp.setApellidoPaterno(resultadoConsulta.getString("apellidoPaterno"));
                estudianteTemp.setApellidoMaterno(resultadoConsulta.getString("apellidoMaterno"));
                estudianteTemp.setCorreoElectronicoInstitucional(resultadoConsulta.getString("correoElectronicoInstitucional"));
                estudianteTemp.setCorreoElectronicoPersonal(resultadoConsulta.getString("correoElectronicoPersonal"));
                estudianteTemp.setMatricula(resultadoConsulta.getString("matricula"));
                estudianteTemp.setIdRol(resultadoConsulta.getInt("idRol"));
                estudiantesBuscados.add(estudianteTemp);
           }
            conexionBD.close();
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        }else{
           estudiantesBuscados = null;
        }
        return estudiantesBuscados;
    }

    public static int modificarTutor(Estudiante tutorado) {
        int respuesta = 0;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try {
                String sentencia = "UPDATE estudiantes SET idRol = ? WHERE idEstudiante = ?;";     
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(sentencia); 
                configurarConsulta.setInt(1, tutorado.getIdRol());
                configurarConsulta.setInt(2, tutorado.getIdEstudiante());
                int filasAfectadas = configurarConsulta.executeUpdate();   
                respuesta = (filasAfectadas == 1) ? CONSTANTES.CODIGO_OPERECION_CORRECTA : CONSTANTES.CODIGO_OPERACION_DML_FALLIDA;
                respuesta = 1;
              conexionBD.close();
            }catch (SQLException e){               
                e.printStackTrace();
                respuesta = CONSTANTES.CODIGO_ERROR_CONEXIONDB;
                respuesta = 0;
            }
        }else{          
            respuesta = 0;
            respuesta = CONSTANTES.CODIGO_ERROR_CONEXIONDB;     
        }
        return respuesta;
    }
}
