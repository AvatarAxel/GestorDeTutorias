package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.Estudiante;
import gestortutorias.util.Constantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EstudianteDAO {
    
    public static ArrayList<Estudiante> obtenerInformacionEstudiante(){
        ArrayList<Estudiante> estudianteBD = new ArrayList<>();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            String consulta = "select idEstudiante, nombre, apellidoPaterno, apellidoMaterno from estudiantes where idRol is NULL;";
            try{
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    Estudiante estudianteTemp = new Estudiante();
                    estudianteTemp.setIdEstudiante(resultadoConsulta.getInt("idEstudiante"));
                    estudianteTemp.setNombreCompletoEstudiante(resultadoConsulta.getString("nombre")+" "+resultadoConsulta.getString("apellidoPaterno")+" "+resultadoConsulta.getString("apellidoMaterno"));
                    estudianteBD.add(estudianteTemp);
                }
                conexionBD.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
            estudianteBD = null;
        }
        return estudianteBD;
    }
 
    public static int asignarTutor(int idRol, int idEstudiante){
        int respuesta;
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            try {
                String sentencia = "update estudiantes set idRol = ? where idEstudiante = ?;";
                PreparedStatement configurarSentencia = conexionBD.prepareStatement(sentencia);
                configurarSentencia.setInt(1, idRol);
                configurarSentencia.setInt(2, idEstudiante);
                int filasAfectadas = configurarSentencia.executeUpdate();
                respuesta = (filasAfectadas == 1) ? Constantes.CODIGO_OPERECION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;
                conexionBD.close();
            }catch (SQLException e){
                e.printStackTrace();
                respuesta = Constantes.CODIGO_ERROR_CONEXIONDB;
            }
        }else{
            respuesta = Constantes.CODIGO_ERROR_CONEXIONDB;
        }
        return respuesta;
    }
    
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
                estudianteTemp.setNombreCompletoEstudiante(resultadoConsulta.getString("nombre")+" "+resultadoConsulta.getString("apellidoPaterno")+" "+resultadoConsulta.getString("apellidoMaterno"));
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
                respuesta = (filasAfectadas == 1) ? Constantes.CODIGO_OPERECION_CORRECTA : Constantes.CODIGO_OPERACION_DML_FALLIDA;
              conexionBD.close();
            }catch (SQLException e){               
                e.printStackTrace();
                respuesta = Constantes.CODIGO_ERROR_CONEXIONDB;
            }
        }else{                      
            respuesta = Constantes.CODIGO_ERROR_CONEXIONDB;     
        }
        return respuesta;
    }    
        
}
