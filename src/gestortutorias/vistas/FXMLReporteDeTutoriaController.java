/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 25/05/2022
 * Fecha de modificación: 
 * Descripción: Consultar Reporte Por Tutor Academico del CU09
 */
package gestortutorias.vistas; 

import gestortutorias.modelo.dao.PeriodoEscolarDAO;
import gestortutorias.modelo.dao.ProblematicaAcademicaDAO;
import gestortutorias.modelo.dao.ReporteDeTutoriaAcademicaDAO;
import gestortutorias.modelo.pojo.PeriodoEscolar;
import gestortutorias.modelo.pojo.ProblematicaAcademica;
import gestortutorias.modelo.pojo.ReporteDeTutoriaAcademica;
import gestortutorias.util.Utilidades;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
 

public class FXMLReporteDeTutoriaController implements Initializable {

    @FXML
    private TableColumn colEE;
    @FXML
    private TableColumn colProfesor;
    @FXML
    private TableColumn colProblema;
    @FXML
    private TableColumn colAlumnoTotales;
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
    private Label lbTotalAlumnos;
    @FXML
    private Label lbObjetivos;
    @FXML
    private TableView<ProblematicaAcademica> tbProblematicaAcademica;
    
    
    ReporteDeTutoriaAcademica reporteDeTutoriaAcademica = new ReporteDeTutoriaAcademica();
    private ObservableList<ProblematicaAcademica> infoProblematicaAcademica = FXCollections.observableArrayList();
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTablas();
        cargarInformacionPeriodoEscolar();
        
    }    

    private void cargarInformacionPeriodoEscolar(){
        PeriodoEscolar resultadoConsulta = PeriodoEscolarDAO.obtenerInformacionPeriodoEscolar();
        if(resultadoConsulta != null){
            lbPeriodo.setText(resultadoConsulta.getFechaCompleta());
        }else{
            Utilidades.mostrarAlerta("Error 501", 
                "No hay conexión con la base de datos. Inténtelo más tarde", Alert.AlertType.ERROR);
                cerrarVentana();
        } 
    }
    
    private void cargarInformacionReporteTutoria(int idReporteTutoriaAcademica){
        ReporteDeTutoriaAcademica resultadoConsulta = ReporteDeTutoriaAcademicaDAO.obtenerInformacionReporte(idReporteTutoriaAcademica);
        if(resultadoConsulta != null){
            lbComentariosGenerales.setText(resultadoConsulta.getComentariosGenerales());
            lbFechaEntrega.setText(resultadoConsulta.getFechaDeEntrega());
            lbFechaTutoria.setText(resultadoConsulta.getFechaTutoria());
            lbNoSesion.setText(resultadoConsulta.getNumeroDeSesion()+"");
            lbObjetivos.setText(resultadoConsulta.getObjetivos());
            lbTotalAlumnos.setText(resultadoConsulta.getNumeroDeEstudiantesQueAsistieron()+"");
            lbTutor.setText(resultadoConsulta.getNombreCompletoTutor());
        }else{
            Utilidades.mostrarAlerta("Error 501", 
                "No hay conexión con la base de datos. Inténtelo más tarde", Alert.AlertType.ERROR);
                cerrarVentana();
        } 
    }

    private void cargarInformacionProblematicaAcademica(int idReporteTutoriaAcademica){
        ArrayList<ProblematicaAcademica> resultadoConsulta = ProblematicaAcademicaDAO.obtenerInformacionProblematicaAcademica(idReporteTutoriaAcademica);
        if(resultadoConsulta != null){
            if(!resultadoConsulta.isEmpty()){
                configurarColumnasTablas();
                infoProblematicaAcademica.addAll(resultadoConsulta);
                tbProblematicaAcademica.setItems(infoProblematicaAcademica);
            }else{
                System.out.println("No hay registros aun");
            }
        }else{
            Utilidades.mostrarAlerta("Error 501", 
                "No hay conexión con la base de datos.Inténtelo más tarde", Alert.AlertType.ERROR);
                cerrarVentana();
        }
    }

     private void configurarColumnasTablas(){
        colEE.setCellValueFactory(new PropertyValueFactory("nombreExperienciaEducativa"));
        colProfesor.setCellValueFactory(new PropertyValueFactory("nombreCompleto"));
        colProblema.setCellValueFactory(new PropertyValueFactory("descripcionProblematica"));
        colAlumnoTotales.setCellValueFactory(new PropertyValueFactory("numeroDeEstudiantesAfectados"));
    }
     
    public void recibirIdReporte(int idReporteDeTutoriaAcademica){
        cargarInformacionReporteTutoria(idReporteDeTutoriaAcademica);
        cargarInformacionProblematicaAcademica(idReporteDeTutoriaAcademica);
    }
    
    @FXML
    private void btnSalir(ActionEvent event) {
        Optional<ButtonType> repuestaDialogo = Utilidades.mostrarAlertaConfirmacion("Salir", 
                    "¿Está seguro de salir?", Alert.AlertType.CONFIRMATION);
            if(repuestaDialogo.get() == ButtonType.OK){
                cerrarVentana();
            }
    }
 
    private void cerrarVentana(){
        Stage escenario = (Stage) lbFechaEntrega.getScene().getWindow();
        escenario.close();
    }
    
}
 