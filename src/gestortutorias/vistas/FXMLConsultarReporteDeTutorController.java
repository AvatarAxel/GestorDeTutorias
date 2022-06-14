/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 25/05/2022
 * Fecha de modificación: 11/06/2022
 * Descripción: Consultar Reporte Por Tutor Academico del CU09
 */
package gestortutorias.vistas;

import gestortutorias.modelo.dao.PeriodoEscolarDAO;
import gestortutorias.modelo.dao.RolDAO;
import gestortutorias.modelo.dao.TutoriaAcademicaDAO;
import gestortutorias.modelo.pojo.PeriodoEscolar;
import gestortutorias.modelo.pojo.Rol;
import gestortutorias.modelo.pojo.TutoriaAcademica;
import gestortutorias.util.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class FXMLConsultarReporteDeTutorController implements Initializable {

    @FXML
    private ComboBox<Rol> cbTutorAcademico;
    @FXML
    private ComboBox<PeriodoEscolar> cbPeriodo;
    @FXML
    private TableColumn<?, ?> colFechaTutoria;
    @FXML
    private TableColumn<?, ?> colNoSeccion;
    
    @FXML
    private TableView<TutoriaAcademica> tbTutoriasAcademicas;
    
    private ObservableList<Rol> infoRol = FXCollections.observableArrayList();
    private ObservableList<PeriodoEscolar> infoPeriodoEscolar = FXCollections.observableArrayList();
    private ObservableList<TutoriaAcademica> infoTutoriaAcademica = FXCollections.observableArrayList();
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarInformacionTutor();
        cargarInformacionPeriodoEscolar();
        
    }    
    
    private void cargarInformacionTutor(){
        ArrayList<Rol> resultadoConsulta = RolDAO.obtenerInformacionTutor();
        if(resultadoConsulta != null){
            infoRol.addAll(resultadoConsulta);
            cbTutorAcademico.setItems(infoRol);
        }else{
            Utilidades.mostrarAlerta("Error 501", 
                "No hay conexión con la base de datos.Inténtelo más tarde", Alert.AlertType.ERROR);
                cerrarVentana();
        }
    }
    
    private void cargarInformacionPeriodoEscolar(){
        ArrayList<PeriodoEscolar> resultadoConsulta = PeriodoEscolarDAO.obtenerInformacionDeTodosLosPeriodoEscolar();
        if(resultadoConsulta != null){
            infoPeriodoEscolar.addAll(resultadoConsulta);
            cbPeriodo.setItems(infoPeriodoEscolar);
        }else{
            Utilidades.mostrarAlerta("Error 501", 
                "No hay conexión con la base de datos.Inténtelo más tarde", Alert.AlertType.ERROR);
                cerrarVentana();
        }
    }
    
    private void cargarInformacionTutoriaAcademica(int idRol, int idPeriodoEscolar){
        ArrayList<TutoriaAcademica> resultadoConsulta = TutoriaAcademicaDAO.obtenerInformacionTutoriaAcademicas(idRol,idPeriodoEscolar);
        if(resultadoConsulta != null){
            if(!resultadoConsulta.isEmpty()){
                infoTutoriaAcademica.clear();
                infoTutoriaAcademica.addAll(resultadoConsulta);
                tbTutoriasAcademicas.setItems(infoTutoriaAcademica);
                configurarColumnasTablas();
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
        colFechaTutoria.setCellValueFactory(new PropertyValueFactory("fechaTutoria"));
        colNoSeccion.setCellValueFactory(new PropertyValueFactory("numeroDeSesion"));
    }
    
    //Crear el esenario para arbrir la ventana de Reporte De Tutoria
    private void irReporteDeTutoria(int idReporteTutoria){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLReporteDeTutoria.fxml"));
            Parent root = loader.load();
            FXMLReporteDeTutoriaController controladorReporteTutoria = loader.getController();
            controladorReporteTutoria.recibirIdReporte(idReporteTutoria); 
            Scene escenaReporteTutoria = new Scene(root); 
            Stage escenarioReporteTutoria = new Stage();
            escenarioReporteTutoria.setScene(escenaReporteTutoria);
            escenarioReporteTutoria.initModality(Modality.APPLICATION_MODAL);      
            escenarioReporteTutoria.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
          
    }
    
    @FXML
    private void btnAceptarDatos(ActionEvent event){
        int validaRol = cbTutorAcademico.getSelectionModel().getSelectedIndex();
        int validaPeriodoEscolar = cbPeriodo.getSelectionModel().getSelectedIndex();
        if(validaRol != -1 && validaPeriodoEscolar != -1){
            int idRol = cbTutorAcademico.getSelectionModel().getSelectedItem().getIdRol();
            int idPeriodoEscolar = cbPeriodo.getSelectionModel().getSelectedItem().getIdPeriodoEscolar();
            cargarInformacionTutoriaAcademica(idRol, idPeriodoEscolar);
        }else{
            Utilidades.mostrarAlerta("Error 403", 
                    "No se seleccionó una opción. Seleccione una", Alert.AlertType.WARNING);
        }   
    }

    @FXML
    private void btnAceptar(ActionEvent event) {
        int validaTutoriaAcademica = tbTutoriasAcademicas.getSelectionModel().getSelectedIndex();
        if(validaTutoriaAcademica != -1){
            int idReporteTutoria = tbTutoriasAcademicas.getSelectionModel().getSelectedItem().getIdReporteTutoria();
            irReporteDeTutoria(idReporteTutoria);
        }else{
            Utilidades.mostrarAlerta("Error 403", 
                    "No se seleccionó una opción. Seleccione una", Alert.AlertType.WARNING);
        }

    }

    @FXML
    private void btnCancelar(ActionEvent event) {
            Optional<ButtonType> repuestaDialogo = Utilidades.mostrarAlertaConfirmacion("Cancelar", 
                    "¿Estás seguro de cancelar?", Alert.AlertType.CONFIRMATION);
            if(repuestaDialogo.get() == ButtonType.OK){
                cerrarVentana();
            }
    }
    
    private void cerrarVentana(){
        Stage escenario = (Stage) cbPeriodo.getScene().getWindow();
        escenario.close();
    }
}
