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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author aavp0
 */
public class FXMLReporteDeTutoriaController implements Initializable {

    @FXML
    private TableColumn<?, ?> colEstudiantes;
    @FXML
    private TableColumn<?, ?> colAsistencia;
    @FXML
    private TableColumn<?, ?> colEnRiesgo;
    @FXML
    private TableColumn<?, ?> colEE;
    @FXML
    private TableColumn<?, ?> colProfesor;
    @FXML
    private TableColumn<?, ?> colProblema;
    @FXML
    private TableColumn<?, ?> colCantAlumno;
    @FXML
    private Label lbComentariosGenerales;
    @FXML
    private Label lbTutor;
    @FXML
    private Label lbPeriodo;
    @FXML
    private Label lbNoSesion;
    @FXML
    private Label lbFechaEntrega;
    @FXML
    private Label lbFechaTutoria;
    @FXML
    private Label lbProgramaEducativo;
    @FXML
    private Label lbTotalAlumnos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSalir(ActionEvent event) {
    }
    
}
 