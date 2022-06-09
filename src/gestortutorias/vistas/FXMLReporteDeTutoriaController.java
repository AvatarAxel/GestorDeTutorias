/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 25/05/2022
 * Fecha de modificación: 
 * Descripción: Consultar Reporte Por Tutor Academico del CU09
 */
package gestortutorias.vistas;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;


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

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnSalir(ActionEvent event) {
    }
    
}
 