/*
 * Autor : Obet Jair Hernández González
 * Fecha de creación: 10/06/2022
 * Fecha de modificación: 15/06/2022
 * Descripción: Modificar la asignacion de un tutorado a un tutor academico
 */
package gestortutorias.vistas;

import gestortutorias.modelo.dao.EstudianteDAO;
import gestortutorias.modelo.dao.RolDAO;
import gestortutorias.modelo.pojo.Estudiante;
import gestortutorias.modelo.pojo.Rol;
import gestortutorias.util.Constantes;
import gestortutorias.util.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class FXMLModificarAsignacionTutorAcademicoController implements Initializable {

    @FXML
    private TextField tfBuscador;
    @FXML
    private Label lbMatricula;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private ComboBox<Rol> cbTutores;
    @FXML
    private Label lbCampoVacioBusqueda;

    private ObservableList<Estudiante> listaEstudiantes;
    
    private ObservableList<Rol> listaTutores;
    @FXML
    private ListView<Estudiante> lvTutoradosEncontrados;
    @FXML
    private Label lbTutorAcademico;
    @FXML
    private Label lbTutorado;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }    
    
    public void cargarEstudiantes(String busqueda){
           
        ArrayList<Estudiante> Estudiantes = EstudianteDAO.busquedaEstudiantes(busqueda);
        if(Estudiantes != null){
           listaEstudiantes = FXCollections.observableArrayList();
           listaEstudiantes.addAll(Estudiantes);
           lvTutoradosEncontrados.setItems(listaEstudiantes);
        }else{
            Utilidades.mostrarAlerta("Error 501", "No hay conexión con la base de datos", Alert.AlertType.WARNING);
        }
    }

    public void borrarInformacion(){
        lbTutorAcademico.setText("");
        lbTutorado.setText("");
        lbMatricula.setText("");
        cbTutores.setItems(null);
        tfBuscador.setText("");
        lvTutoradosEncontrados.setItems(null);
        tfBuscador.getCursor();
    }
   
    
    @FXML
    private void btnBusqueda(javafx.event.ActionEvent event) {
        String busqueda = tfBuscador.getText();
        cargarEstudiantes(busqueda);    
    }
    
    @FXML
    private void seleccionarTutorado(MouseEvent event) {
        Estudiante tutoradoSeleccionado = lvTutoradosEncontrados.getSelectionModel().getSelectedItem();
        cargarTutorado(tutoradoSeleccionado);
    }

    
    private void cargarTutorado(Estudiante tutorado){
        lbTutorado.setText(tutorado.toString());
        lbMatricula.setText(tutorado.getMatricula());
        Rol tutorActual = RolDAO.buscarTutor(tutorado.getIdRol());
        lbTutorAcademico.setText(tutorActual.toString());
        cargarTutores();
    }
    private void cargarTutores(){
        ArrayList<Rol> tutores = RolDAO.cargarTutores();
        if(tutores != null){
           listaTutores = FXCollections.observableArrayList();
           listaTutores.addAll(tutores);
           cbTutores.setItems(listaTutores);
        }else{
            Utilidades.mostrarAlerta("Error 501", "No hay conexión con la base de datos", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnGuardar(javafx.event.ActionEvent event) {
        Rol tutor = cbTutores.getSelectionModel().getSelectedItem(); 
        
        if(tutor == null){
           Utilidades.mostrarAlerta("Error 403", "No se seleccionó una opción. Seleccione una ", Alert.AlertType.WARNING);
        }else{
        guardarAsignacion(tutor);
        }
    }
    
    private void guardarAsignacion(Rol tutor){
          Estudiante tutoradoSeleccionado = lvTutoradosEncontrados.getSelectionModel().getSelectedItem();
          tutoradoSeleccionado.setIdRol(tutor.getIdRol());
          int codigoRespuesta = EstudianteDAO.modificarTutor(tutoradoSeleccionado);
          if(codigoRespuesta == Constantes.CODIGO_OPERECION_CORRECTA){
              Utilidades.mostrarAlerta("Guardado", "Guardado con éxito", Alert.AlertType.INFORMATION);
              borrarInformacion();
          }else if(codigoRespuesta == Constantes.CODIGO_ERROR_CONEXIONDB){
              Utilidades.mostrarAlerta("Error 501", "No hay conexión con la base de datos. Inténtelo más tarde", Alert.AlertType.ERROR);
              regresar();
          }else if(codigoRespuesta == Constantes.CODIGO_OPERACION_DML_FALLIDA){
              Utilidades.mostrarAlerta("Error 502", "Hubo un error al guardar la información. Intentelo de nuevo", Alert.AlertType.WARNING);
          }
    }

    @FXML
    private void btnCancelar(javafx.event.ActionEvent event) {
        borrarInformacion();
    }
 
    public void regresar(){
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestionTutoresAcademicoEstudiante.fxml"));
           Parent root = loader.load();
           Scene escenaGestionTutoresAcademicoEstudiante = new Scene(root);
           
           Stage escenarioGestionTutoresAcademicoEstudiante = (Stage) lbTutorado.getScene().getWindow();
           escenarioGestionTutoresAcademicoEstudiante.setScene(escenaGestionTutoresAcademicoEstudiante);
           escenarioGestionTutoresAcademicoEstudiante.setTitle("Gestion de tutores academicos y estudiantes");
           escenarioGestionTutoresAcademicoEstudiante.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnRegresar(javafx.event.ActionEvent event) {
        regresar();
    }
}
