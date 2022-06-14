/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortutorias.vistas;

import gestortutorias.modelo.dao.ExperienciaEducativaDAO;
import gestortutorias.modelo.dao.PeriodoEscolarDAO;
import gestortutorias.modelo.pojo.ExperienciaEducativa;
import gestortutorias.modelo.pojo.PeriodoEscolar;
import gestortutorias.util.Utilidades;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author je_zu
 */
public class FXMLOfertaEducativaController implements Initializable {

    @FXML
    private ComboBox<PeriodoEscolar> cbPeriodoEscolar;
    @FXML
    private TableView<ExperienciaEducativa> tbExperienciasEducativas;
    @FXML
    private TableColumn tcNombreExperienciasEducativas;
    @FXML
    private TableColumn tcNRC;
    @FXML
    private TableColumn tcNombreProfesor;
    @FXML
    private TableColumn tcSeccion;
    @FXML
    private TableColumn tcSalon;

    private ObservableList<ExperienciaEducativa> infoExperienciaEducativas;
    private ObservableList<PeriodoEscolar> listaPeriodosEscolares;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarInformacionExperienciasEducativas();
        cargarInformacionPeriodosEscolares();
        
        cbPeriodoEscolar.valueProperty().addListener(new ChangeListener<PeriodoEscolar>(){
            
            @Override
            public void changed(ObservableValue<? extends PeriodoEscolar> observable, PeriodoEscolar oldValue, PeriodoEscolar newValue) {
                if(newValue != null){
                    cargarInformacionExperieciasEducativasFiltradas(newValue.getIdPeriodo());
                }
            }
            
        });
    }

    private void configurarTabla() {
        tcNombreExperienciasEducativas.setCellValueFactory(new PropertyValueFactory("nombre"));
        tcNRC.setCellValueFactory(new PropertyValueFactory("nrc"));
        tcNombreProfesor.setCellValueFactory(new PropertyValueFactory("nombreProfesor"));
        tcSeccion.setCellValueFactory(new PropertyValueFactory("seccion"));
        tcSalon.setCellValueFactory(new PropertyValueFactory("salon"));

        infoExperienciaEducativas = FXCollections.observableArrayList();

    }

    private void cargarInformacionExperienciasEducativas() {
        ArrayList<ExperienciaEducativa> resultadoConsulta = ExperienciaEducativaDAO.obtenerInformacionExperienciasEducativas();

        if (resultadoConsulta != null) {
            infoExperienciaEducativas.clear();
            infoExperienciaEducativas.addAll(resultadoConsulta);
            tbExperienciasEducativas.setItems(infoExperienciaEducativas);

        } else {
            Utilidades.mostrarAlerta("Error", "No hay conexion con la base de datos. Intentelo de nuevo mas tarde", Alert.AlertType.ERROR);
        }
    }

    private void cargarInformacionPeriodosEscolares() {
        ArrayList<PeriodoEscolar> periodoEscolaresBD = PeriodoEscolarDAO.obtenerInformacionPeriodoEscolar();

        if (periodoEscolaresBD != null) {
            listaPeriodosEscolares = FXCollections.observableArrayList();
            listaPeriodosEscolares.addAll(periodoEscolaresBD);
            cbPeriodoEscolar.setItems(listaPeriodosEscolares);
        } else {
            Utilidades.mostrarAlerta("Error", "No hay conexion con la base de datos. Intentelo de nuevo mas tarde", Alert.AlertType.ERROR);
        }
    }
    
    private void cargarInformacionExperieciasEducativasFiltradas(Integer idPeriodoEscolar){
        ArrayList<ExperienciaEducativa> experienciasEducativasFiltradas = ExperienciaEducativaDAO.obtenerInformacionExperienciasEducativasFiltradas(idPeriodoEscolar);
        if (experienciasEducativasFiltradas != null) {
            infoExperienciaEducativas = FXCollections.observableArrayList();
            infoExperienciaEducativas.addAll(experienciasEducativasFiltradas);
            tbExperienciasEducativas.setItems(infoExperienciaEducativas);
        } else {
            Utilidades.mostrarAlerta("Error", "No hay conexion con la base de datos. Intentelo de nuevo mas tarde", Alert.AlertType.ERROR);
        }
        
    }

    @FXML
    private void btnSalir(ActionEvent event) {
        Optional<ButtonType> respuestaDialogo = Utilidades.mostrarAlertaConfirmacion("Salir", "¿Está seguro de salir? ", Alert.AlertType.CONFIRMATION);
        if(respuestaDialogo.get() == ButtonType.OK){
            cerrarVentana();
        }
    }

    private void cerrarVentana() {
        Stage escenario = (Stage) cbPeriodoEscolar.getScene().getWindow();
        escenario.close();
    }
}
