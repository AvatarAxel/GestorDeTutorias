package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.Estudiante;
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
            String consulta = "select idEstudiante, nombre, apellidoPaterno, apellidoMaterno, matricula from estudiantes where idRol is NULL;";
            try{
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    Estudiante estudianteTemp = new Estudiante();
                    estudianteTemp.setIdEStudiante(resultadoConsulta.getInt("idEstudiante"));
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
    
}
