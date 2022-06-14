/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 09/06/2022
 * Descripción: Son las ventanas emergentes a utilizar
 */
package gestortutorias.util;

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
     
    //Ventana emergentes con los botones de "Aceptar" y "Cancelar"
    public static Optional<ButtonType> mostrarAlertaConfirmacion(String titulo, String mensaje, Alert.AlertType tipoAlerta){
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        return alerta.showAndWait();
    }
}
