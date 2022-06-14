<<<<<<< HEAD
package gestortutorias.modelo;

=======
/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 25/05/2022
 * Fecha de modificación: 
 * Descripción: Coenxión con la Base de datos de MySQL Workbench
 */

package gestortutorias.modelo;
>>>>>>> 250ac05d66657c54d9192e88ed6223dd656f22c5
import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionBD {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE = "gestionDeTutorias";
    private static final String HOSTNAME = "localhost";
    private static final String PORT = "3306";
    private static final String URL_CONEXION = "jdbc:mysql://"+HOSTNAME+":"+PORT+"/"+DATABASE+"?serverTimezone=UTC";

<<<<<<< HEAD
    private static final String USERNAME = "AxelSM";
    private static final String PASSWORD = "4L4v3r6AUNPwrR4nger";
=======
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Pucheta29";
>>>>>>> 250ac05d66657c54d9192e88ed6223dd656f22c5

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
