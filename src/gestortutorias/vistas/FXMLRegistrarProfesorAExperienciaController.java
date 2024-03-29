/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 25/05/2022
 * Fecha de modificación: 09/06/2022
 * Descripción: Registrar experiencia educativa a un profesor
 */
package gestortutorias.vistas;

import gestortutorias.modelo.dao.ExperienciaEducativaDAO;
import gestortutorias.modelo.dao.PeriodoEscolarDAO;
import gestortutorias.modelo.dao.RolDAO;
import gestortutorias.modelo.pojo.ExperienciaEducativa;
import gestortutorias.modelo.pojo.PeriodoEscolar;
import gestortutorias.modelo.pojo.Rol;
import gestortutorias.util.Constantes;
import gestortutorias.util.Utilidades;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLRegistrarProfesorAExperienciaController implements Initializable {

    @FXML
    private ComboBox<Rol> cbProfesor;
    @FXML
    private ComboBox<ExperienciaEducativa> cbExperienciaEducatica;
    @FXML
    private Label lbPeriodo;
    
    private ObservableList<Rol> infoRol = FXCollections.observableArrayList();
    private ObservableList<ExperienciaEducativa> infoExperienciaEducativa = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarInformacionRol();
        cargarInformacionExperienciaEducativa();
        cargarInformacionPeriodoEscolar();
    } 
    
    private void cargarInformacionRol(){
        ArrayList<Rol> resultadoConsulta = RolDAO.obtenerInformacionProfesor();
        if(resultadoConsulta != null){
            infoRol.addAll(resultadoConsulta);
            cbProfesor.setItems(infoRol);
        }else{
            Utilidades.mostrarAlerta("Error 501", 
                "No hay conexión con la base de datos.Inténtelo más tarde", Alert.AlertType.ERROR);
                Platform.runLater(() -> {
                    cerrarVentana();
                });
        }
    }
    
    private void cargarInformacionExperienciaEducativa() {
        ArrayList<ExperienciaEducativa> resultadoConsulta = ExperienciaEducativaDAO.obtenerInformacionExperienciaEducativa();
        if (resultadoConsulta != null) {
            if (!resultadoConsulta.isEmpty()) {
                infoExperienciaEducativa.addAll(resultadoConsulta);
                cbExperienciaEducatica.setItems(infoExperienciaEducativa);
            } else {
                Utilidades.mostrarAlerta("Error 508", "Registro no existente", Alert.AlertType.INFORMATION);
                Platform.runLater(() -> {
                    cerrarVentana();
                });
            }
        } else {
            Utilidades.mostrarAlerta("Error 501",
                    "No hay conexión con la base de datos. Inténtelo más tarde", Alert.AlertType.ERROR);
            Platform.runLater(() -> {
                cerrarVentana();
            });
        }

    }
     
    private void cargarInformacionPeriodoEscolar() {
        PeriodoEscolar resultadoConsulta = PeriodoEscolarDAO.obtenerInformacionPeriodoEscolar();
        if (resultadoConsulta != null) {
            lbPeriodo.setText(resultadoConsulta.getFechaCompleta());
        } else {
            Utilidades.mostrarAlerta("Error 501",
                    "No hay conexión con la base de datos. Inténtelo más tarde", Alert.AlertType.ERROR);
            Platform.runLater(() -> {
                cerrarVentana();
            });
        }
    }
    
    //Asignar una experiencia educativa a un profesor
    private void registrarExperienciaARol(ExperienciaEducativa experienciaEducativaRegistro, Rol rolSeleccionado){
        int codigoRepuesta = ExperienciaEducativaDAO.asignarExperienciaARol(experienciaEducativaRegistro.getIdExperienciaEducativa(), rolSeleccionado.getIdRol());
        switch(codigoRepuesta){
            case Constantes.CODIGO_OPERECION_CORRECTA:
                Utilidades.mostrarAlerta("Registrado", "Registrado con éxito",Alert.AlertType.INFORMATION);
                Platform.runLater(() -> {
                    cerrarVentana();
                });
                    break;
            case Constantes.CODIGO_ERROR_CONEXIONDB:
                Utilidades.mostrarAlerta("Error 501", 
                    "No hay conexión con la base de datos. Inténtelo más tarde", Alert.AlertType.ERROR);
                    Platform.runLater(() -> {
                    cerrarVentana();
                });
                    break;
        }
    }

    @FXML
    private void clicBtnRegistrar(ActionEvent event) {
        int validaRol = cbProfesor.getSelectionModel().getSelectedIndex();
        int validaExperiencia = cbExperienciaEducatica.getSelectionModel().getSelectedIndex();
        if(validaRol != -1 && validaExperiencia != -1){
            ExperienciaEducativa experienciaSeleccionada = cbExperienciaEducatica.getSelectionModel().getSelectedItem(); 
            Rol rolSeleccionado = cbProfesor.getSelectionModel().getSelectedItem();
            Optional<ButtonType> repuestaDialogo = Utilidades.mostrarAlertaConfirmacion("Confirmamación", 
                    "¿Confirmar y guardar?", Alert.AlertType.CONFIRMATION);
            if(repuestaDialogo.get() == ButtonType.OK){
                registrarExperienciaARol(experienciaSeleccionada, rolSeleccionado);
            }
        }else{
            Utilidades.mostrarAlerta("Error 403", 
                    "No se seleccionó una opción. Seleccione una", Alert.AlertType.WARNING);
        }     
    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
        Optional<ButtonType> repuestaDialogo = Utilidades.mostrarAlertaConfirmacion("Cancelar", 
                    "¿Estás seguro de cancelar?", Alert.AlertType.CONFIRMATION);
            if(repuestaDialogo.get() == ButtonType.OK){
                Platform.runLater(() -> {
                    cerrarVentana();
                });
            }
    }
    
    private void cerrarVentana(){
        Stage escenario = (Stage) cbExperienciaEducatica.getScene().getWindow();
        escenario.close();
    }
    
    //Funcion de registrar a un profesor que no este dado de alta
    @FXML
    private void clicBtnRegistrarProfesor(ActionEvent event) {
        //TODO
    }
}
