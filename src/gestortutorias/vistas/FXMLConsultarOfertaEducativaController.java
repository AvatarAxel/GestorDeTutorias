/*
 * Autor: Jesus Onofre Rodriguez Cortes
 * Fecha de creación: 09/06/2022
 * Fecha de modificación: 14/06/2022
 * Descripción: Consultar la oferta educativa del CU03
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
import javafx.application.Platform;
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

public class FXMLConsultarOfertaEducativaController implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarTabla();
        cargarInformacionExperienciasEducativas();
        cargarInformacionPeriodosEscolares();
        
        cbPeriodoEscolar.valueProperty().addListener(new ChangeListener<PeriodoEscolar>(){
            
            @Override
            public void changed(ObservableValue<? extends PeriodoEscolar> observable, PeriodoEscolar oldValue, PeriodoEscolar newValue) {
                if(newValue != null){
                    cargarInformacionExperieciasEducativasFiltradas(newValue.getIdPeriodoEscolar());
                }
            }
            
        });
    }

    private void configurarTabla() {
        tcNombreExperienciasEducativas.setCellValueFactory(new PropertyValueFactory("nombreMateria"));
        tcNRC.setCellValueFactory(new PropertyValueFactory("nrc"));
        tcNombreProfesor.setCellValueFactory(new PropertyValueFactory("nombreProfesorCompleto"));
        tcSeccion.setCellValueFactory(new PropertyValueFactory("seccion"));
        tcSalon.setCellValueFactory(new PropertyValueFactory("salon"));
        infoExperienciaEducativas = FXCollections.observableArrayList();

    }

    private void cargarInformacionExperienciasEducativas() {
        ArrayList<ExperienciaEducativa> resultadoConsulta = ExperienciaEducativaDAO.obtenerInformacionExperienciasEducativas();

        if (resultadoConsulta != null) {
            if (!resultadoConsulta.isEmpty()) {
                infoExperienciaEducativas.clear();
                infoExperienciaEducativas.addAll(resultadoConsulta);
                tbExperienciasEducativas.setItems(infoExperienciaEducativas);
            } else {
                Utilidades.mostrarAlerta("Error 508", "Registros no existentes", Alert.AlertType.NONE);
                Platform.runLater(() -> {
                    cerrarVentana();
                });
            }
        } else {
            Utilidades.mostrarAlerta("Error 501", "No hay conexion con la base de datos. Intentelo mas tarde", Alert.AlertType.ERROR);
            Platform.runLater(() -> {
                cerrarVentana();
            });
        }
    }

    private void cargarInformacionPeriodosEscolares() {
        ArrayList<PeriodoEscolar> periodoEscolaresBD = PeriodoEscolarDAO.obtenerInformacionPeriodosEscolares();

        if (periodoEscolaresBD != null) {
            if(!periodoEscolaresBD.isEmpty()){
                listaPeriodosEscolares = FXCollections.observableArrayList();
                listaPeriodosEscolares.addAll(periodoEscolaresBD);
                cbPeriodoEscolar.setItems(listaPeriodosEscolares);
            }else{
                Utilidades.mostrarAlerta("Error 508", "Registros no existentes", Alert.AlertType.NONE);
                Platform.runLater(() -> {
                    cerrarVentana();
                });
            }
        } else {
            Utilidades.mostrarAlerta("Error 501", "No hay conexion con la base de datos. Intentelo mas tarde", Alert.AlertType.ERROR);
            Platform.runLater(() -> {
                    cerrarVentana();
                });
        }
    }
    
    private void cargarInformacionExperieciasEducativasFiltradas(Integer idPeriodoEscolar){
        ArrayList<ExperienciaEducativa> experienciasEducativasFiltradas = ExperienciaEducativaDAO.obtenerInformacionExperienciasEducativasFiltradas(idPeriodoEscolar);
        if (experienciasEducativasFiltradas != null) {
            infoExperienciaEducativas = FXCollections.observableArrayList();
            infoExperienciaEducativas.addAll(experienciasEducativasFiltradas);
            tbExperienciasEducativas.setItems(infoExperienciaEducativas);
        } else {
            Utilidades.mostrarAlerta("Error 501", "No hay conexion con la base de datos. Intentelo mas tarde", Alert.AlertType.ERROR);
            cerrarVentana();
            Platform.runLater(() -> {
                    cerrarVentana();
                });
        }
        
    }

    @FXML
    private void btnSalir(ActionEvent event) {
        Optional<ButtonType> respuestaDialogo = Utilidades.mostrarAlertaConfirmacion("Salir", "¿Está seguro de salir? ", Alert.AlertType.CONFIRMATION);
        if(respuestaDialogo.get() == ButtonType.OK){
            Platform.runLater(() -> {
                    cerrarVentana();
                });
        }
    }

    private void cerrarVentana() {
        Stage escenario = (Stage) cbPeriodoEscolar.getScene().getWindow();
        escenario.close();
    }
}
