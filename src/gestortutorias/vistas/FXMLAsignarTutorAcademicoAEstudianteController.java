/*
 * Autor: Mendoza Domingo Axel Saturnino
 * Fecha de creación: 11/06/2022
 * Fecha de modificación: 15/06/2022
 * Descripción: Asignar Tutor Academico a Estudiante
 */
package gestortutorias.vistas;

import gestortutorias.modelo.dao.EstudianteDAO;
import gestortutorias.modelo.dao.RolDAO;
import gestortutorias.modelo.pojo.Estudiante;
import gestortutorias.modelo.pojo.Rol;
import gestortutorias.util.Constantes;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLAsignarTutorAcademicoAEstudianteController implements Initializable {

    @FXML
    private Label lbTotalTutorados;
    @FXML
    private ComboBox<Rol> cbTutor;
    @FXML
    private ComboBox<Estudiante> cbEstudiante;
    
    private ObservableList <Rol> listaTutor = FXCollections.observableArrayList();
    private ObservableList <Estudiante> listaEstudiante = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarInformacionTutor();
        cargarInformacionEstudiante();
        cargarInformacionTotalTutorados();
        mostrarTotalTutorados();
    }    
    
    private void cargarInformacionTutor(){
        ArrayList<Rol> resultadoConsulta = RolDAO.obtenerInformacionTutor();
        if(resultadoConsulta != null){
            if(!resultadoConsulta.isEmpty()){
                listaTutor.clear();
                listaTutor.addAll(resultadoConsulta);
                cbTutor.setItems(listaTutor);
            }else{
                Utilidades.mostrarAlerta("Error 507", "Registro ya existente", Alert.AlertType.INFORMATION);
                cerrarVentana();
            }            
        }else{
            Utilidades.mostrarAlerta("Error 501", "No hay conexion con la base de datos. Intentelo de nuevo mas tarde", Alert.AlertType.ERROR);
            cerrarVentana();
        }
    }
    
    private void cargarInformacionEstudiante(){
        ArrayList<Estudiante> resultadoConsulta = EstudianteDAO.obtenerInformacionEstudiante();
        if(resultadoConsulta != null){
            if(!resultadoConsulta.isEmpty()){
                listaEstudiante.clear();
                listaEstudiante.addAll(resultadoConsulta);
                cbEstudiante.setItems(listaEstudiante);
            }else{
                Utilidades.mostrarAlerta("Error 507", "Registro ya existente", Alert.AlertType.INFORMATION);
                cerrarVentana();
            }              
        }else{
            Utilidades.mostrarAlerta("Error 501", "No hay conexion con la base de datos. Intentelo de nuevo mas tarde", Alert.AlertType.ERROR);
            cerrarVentana();
        }
    }
    
    private void cargarInformacionTotalTutorados(){
       if(listaTutor.size() > 0){           
           for(int i = 0; i<listaTutor.size(); i++){               
               int idRol = listaTutor.get(i).getIdRol();
               int totalTutorados = RolDAO.obtenerTotalTutorados(idRol);
               if(totalTutorados >= 30){
                   listaTutor.remove(i);
                   i--;
               }    
               else{                   
                   listaTutor.get(i).setTotalTutorados(totalTutorados);
               }    
            }
        }
    }
      
    private void mostrarTotalTutorados(){
        cbTutor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Rol>() {
            @Override
            public void changed(ObservableValue<? extends Rol> observable, Rol oldValue, Rol newValue) {
                if(!cbTutor.getSelectionModel().isEmpty()){
                    int totalTutorados = cbTutor.getSelectionModel().getSelectedItem().getTotalTutorados();
                    lbTotalTutorados.setText(totalTutorados+"");
                }else{
                    lbTotalTutorados.setText("");
                }
            }
        });
    }
    
    private void asignarTutorAEstudiante(int idRol, int idEstudiante){
        int codigoRespuesta = EstudianteDAO.asignarTutor(idRol, idEstudiante);
        switch(codigoRespuesta){
            case Constantes.CODIGO_OPERECION_CORRECTA:
                Utilidades.mostrarAlerta("Guardado", "Registro realizado con éxito", Alert.AlertType.INFORMATION);                
                cerrarVentana();
                break;
            case Constantes.CODIGO_ERROR_CONEXIONDB:
                Utilidades.mostrarAlerta("Error 501", "No hay conexion con la base de datos. Intentelo de nuevo mas tarde", Alert.AlertType.ERROR);
                cerrarVentana();                
                break;
            default:
                break;
        }        
    }
    
    @FXML
    private void clicBtnAsignar(ActionEvent event) {
        int validaRol = cbTutor.getSelectionModel().getSelectedIndex();
        int validaEstudiante = cbEstudiante.getSelectionModel().getSelectedIndex();
        if(validaRol != -1 && validaEstudiante != -1){
            Optional<ButtonType> repuestaDialogo = Utilidades.mostrarAlertaConfirmacion("Confirmamación", 
                    "¿Confirmar y guardar?", Alert.AlertType.CONFIRMATION);
            if(repuestaDialogo.get() == ButtonType.OK){
                int idRol = cbTutor.getSelectionModel().getSelectedItem().getIdRol();
                int idEstudiante = cbEstudiante.getSelectionModel().getSelectedItem().getIdEstudiante(); 
                asignarTutorAEstudiante(idRol, idEstudiante);                
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
                cerrarVentana();
            }           
    }
    
    private void cerrarVentana() {
        Stage escenario = (Stage)cbTutor.getScene().getWindow();
        escenario.close();
    }    
    
}
