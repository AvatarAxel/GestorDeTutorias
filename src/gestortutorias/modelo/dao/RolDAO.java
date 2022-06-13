package gestortutorias.modelo.dao;

import gestortutorias.modelo.ConexionBD;
import gestortutorias.modelo.pojo.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RolDAO {
    
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
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }else{
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
    
}
