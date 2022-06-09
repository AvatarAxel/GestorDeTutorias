/*
 * Autor: Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 25/05/2022
 * Fecha de modificación: 
 * Descripción: Registrar experiencia educativa a un profesor
 */
package gestortutorias.vistas;

import gestortutorias.modelo.dao.RolDAO;
import gestortutorias.modelo.pojo.Rol;
import gestortutorias.util.Utilidades;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class FXMLRegistrarProfesorAExperienciaController implements Initializable {

    @FXML
    private ComboBox<Rol> cbProfesor;
    @FXML
    private ComboBox<?> cbExperienciaEducatica;
    @FXML
    private Label lbPeriodo;
    
    private ObservableList<Rol> infoRol = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarInformacionRol();
    } 
    
    private void cargarInformacionRol(){
        ArrayList<Rol> resultadoConsuta = RolDAO.obtenerInformacionRoles();
        if(resultadoConsuta != null){
            infoRol.addAll(resultadoConsuta);
            cbProfesor.setItems(infoRol);
            //Utilidades.mostrarAlerta("EL PEDO ES EN..", "Por el momento no hay conexion", Alert.AlertType.ERROR);
        }else{
            Utilidades.mostrarAlerta("Error de conexion", "Por el momento no hay conexion", Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void clicBtnRegistrarProfesor(ActionEvent event) {
    }

    @FXML
    private void clicBtnRegistrar(ActionEvent event) {
    }

    @FXML
    private void clicBtnCancelar(ActionEvent event) {
    }
    
}
