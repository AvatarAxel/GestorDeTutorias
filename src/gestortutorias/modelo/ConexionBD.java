/*
 * Autor: Andrea Alejandra Vargas Pucheta, Jesus Onofre Rodríguez cortes, Axel Saturnino Mendoza Domingo
 * Fecha de creación: 25/05/2022
 * Fecha de modificación: 
 * Descripción: Conexión con la Base de datos de MySQL Workbench
 */

package gestortutorias.modelo;
import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionBD {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE = "gestiondetutorias";
    private static final String HOSTNAME = "localhost";
    private static final String PORT = "3306";
    private static final String URL_CONEXION = "jdbc:mysql://"+HOSTNAME+":"+PORT+"/"+DATABASE+"?serverTimezone=UTC";

    private static final String USERNAME = "root";
    private static final String PASSWORD = "210502160618";

    public static Connection abrirConexionBD(){
        Connection conexionBD = null;
        try{
            Class.forName(DRIVER);
            conexionBD = DriverManager.getConnection(URL_CONEXION, USERNAME, PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conexionBD;
    }

}

