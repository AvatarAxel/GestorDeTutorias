/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortutorias.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author je_zu
 */
public class FXMLRegistroProblematicaAcademicaController implements Initializable {

    @FXML
    private TextField tfTituloProblematica;
    @FXML
    private TextArea tfDescripcionProblematica;
    @FXML
    private ComboBox<?> cbExperienciaEducativa;
    @FXML
    private ComboBox<?> cbProfesor;
    @FXML
    private ComboBox<?> cbNRC;
    @FXML
    private ComboBox<?> cbNumeroDeTutoradosAfectados;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnGuardarProblematicaAcademica(ActionEvent event) {
    }

    @FXML
    private void btnCancelarRegistro(ActionEvent event) {
        
    }
    
}
