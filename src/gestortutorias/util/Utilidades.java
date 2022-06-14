<<<<<<< HEAD
package gestortutorias.util;


=======
/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 09/06/2022
 * Descripción: Son las ventanas emergentes a utilizar
 */
package gestortutorias.util;

>>>>>>> 250ac05d66657c54d9192e88ed6223dd656f22c5
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Utilidades {
    public static void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipoAlerta){
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
<<<<<<< HEAD
=======
     
    //Ventana emergentes con los botones de "Aceptar" y "Cancelar"
>>>>>>> 250ac05d66657c54d9192e88ed6223dd656f22c5
    public static Optional<ButtonType> mostrarAlertaConfirmacion(String titulo, String mensaje, Alert.AlertType tipoAlerta){
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        return alerta.showAndWait();
<<<<<<< HEAD
    }    
}
=======
    }
}
>>>>>>> 250ac05d66657c54d9192e88ed6223dd656f22c5
