package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.Estudiante;
import gestortutorias.modelo.pojo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.ComboBox;

public class RolDAO {
    
    public static ComboBox obtenerInformacionTutor(){
        ComboBox rolBD = new ComboBox();
        Connection conexionBD = ConexionBD.abrirConexionBD();
        if(conexionBD != null){
            String consulta = "select * from roles;";
            try{
                PreparedStatement configurarConsulta = conexionBD.prepareStatement(consulta);
                ResultSet resultadoConsulta = configurarConsulta.executeQuery();
                while(resultadoConsulta.next()){
                    Rol rolTemp = new Rol();
                    rolTemp.setIdRol(resultadoConsulta.getInt("idRol"));
                    rolTemp.setNombreCompletoRol(resultadoConsulta.getString("nombre")+" "+resultadoConsulta.getString("apelligoPaterno")+" "+resultadoConsulta.getString("apellidoMaterno"));
                    rolBD.getItems().add(rolTemp);
                }
                conexionBD.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
            rolBD = null;
        }
        return rolBD;
    } 
    
}
