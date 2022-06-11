/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 25/05/2022
 * Fecha de modificación: 
 * Descripción: Consultar Reporte Por Tutor Academico del CU09
 */
package gestortutorias.vistas;

import gestortutorias.modelo.dao.PeriodoEscolarDAO;
import gestortutorias.modelo.dao.RolDAO;
import gestortutorias.modelo.pojo.PeriodoEscolar;
import gestortutorias.modelo.pojo.Rol;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
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
    
    private ObservableList<Rol> infoRol = FXCollections.observableArrayList();
    private ObservableList<PeriodoEscolar> infoPeriodoEscolar = FXCollections.observableArrayList();
  
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
     

    @FXML
    private void btnAceptarDatos(ActionEvent event){
        
    }
    
    

    @FXML
    private void btnAceptar(ActionEvent event) {
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
