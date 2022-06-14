package gestortutorias.vistas;

import gestortutorias.modelo.dao.EstudianteDAO;
import gestortutorias.modelo.dao.RolDAO;
import gestortutorias.modelo.pojo.Estudiante;
import gestortutorias.modelo.pojo.Rol;
import gestortutorias.util.Utilidades;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
            listaTutor.clear();
            listaTutor.addAll(resultadoConsulta);
            cbTutor.setItems(listaTutor);
        }else{
            Utilidades.mostrarAlerta("Noo", "Mensaje", Alert.AlertType.ERROR);
        }
    }
    
    private void cargarInformacionEstudiante(){
        ArrayList<Estudiante> resultadoConsulta = EstudianteDAO.obtenerInformacionEstudiante();
        if(resultadoConsulta != null){
            listaEstudiante.clear();
            listaEstudiante.addAll(resultadoConsulta);
            cbEstudiante.setItems(listaEstudiante);
        }else{
            Utilidades.mostrarAlerta("Noo", "Mensaje", Alert.AlertType.ERROR);
        }
    }   
    
    private void cargarInformacionTotalTutorados(){
       if(listaTutor.size() > 0){           
           for(int i = 0; i<listaTutor.size(); i++){               
               int idRol = listaTutor.get(i).getIdRol();
               int totalTutorados = RolDAO.obtenerTotalTutorados(idRol);
               //TODO
               if(totalTutorados >= 5)
                   listaTutor.remove(i);
                   
               else                   
                   listaTutor.get(i).setTotalTutorados(totalTutorados);
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
        //TODO
        EstudianteDAO.asignarTutor(idRol, idEstudiante);
    }
    
    private void cerrarVentana() {
        Stage escenario = (Stage)cbTutor.getScene().getWindow();
        escenario.close();
    }

    @FXML
    private void clicBtnSalir(ActionEvent event) {
        cerrarVentana();      
    }
    
    @FXML
    private void clicBtnAsignar(ActionEvent event) {
        int validaRol = cbTutor.getSelectionModel().getSelectedIndex();
        int validaEstudiante = cbEstudiante.getSelectionModel().getSelectedIndex();
        if(validaRol != -1 && validaEstudiante != -1){
            int idRol = cbTutor.getSelectionModel().getSelectedItem().getIdRol();
            int idEstudiante = cbEstudiante.getSelectionModel().getSelectedItem().getIdEstudiante(); 
            asignarTutorAEstudiante(idRol, idEstudiante);
            cargarInformacionTotalTutorados(); 
            cargarInformacionEstudiante();
            cbTutor.getSelectionModel().clearSelection();
        }else{
            Utilidades.mostrarAlerta("Error 403", 
                    "No se seleccionó una opción. Seleccione una", Alert.AlertType.WARNING);
        }          
    }    
    
}
