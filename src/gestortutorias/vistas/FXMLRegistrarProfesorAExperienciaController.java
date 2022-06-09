/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 25/05/2022
 * Fecha de modificación: 
 * Descripción: Registrar experiencia educativa a un profesor
 */
package gestortutorias.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class FXMLRegistrarProfesorAExperienciaController implements Initializable {

    @FXML
    private ComboBox<?> cbProfesor;
    @FXML
    private ComboBox<?> cbExperienciaEducatica;
    @FXML
    private Label lbPeriodo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clicBtnRegistrarProfesor(ActionEvent event) {
    }

    @FXML
    private void clicBtnRegistrar(ActionEvent event) {
    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
    }
    
}
