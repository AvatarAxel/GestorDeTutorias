package gestortutorias.vistas;

import gestortutorias.modelo.dao.EstudianteDAO;
import gestortutorias.modelo.dao.TutorDAO;
import gestortutorias.modelo.pojo.Estudiante;
import gestortutorias.modelo.pojo.Tutor;
import gestortutorias.util.Constantes;
import gestortutorias.util.Utilidades;
import java.awt.event.ActionEvent;
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
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    private ComboBox<Tutor> cbTutores;
    @FXML
    private Label lbCampoVacioBusqueda;

    private ObservableList<Estudiante> listaEstudiantes;
    
    private ObservableList<Tutor> listaTutores;
    @FXML
    private ListView<Estudiante> lvTutoradosEncontrados;
    @FXML
    private Label lbTutorAcademico;
    @FXML
    private Label lbTutorado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void cargarEstudiantes(String busqueda){
           
        ArrayList<Estudiante> Estudiantes = EstudianteDAO.busquedaEstudiantes(busqueda);
        if(Estudiantes != null){
           listaEstudiantes = FXCollections.observableArrayList();
           listaEstudiantes.addAll(Estudiantes);
           lvTutoradosEncontrados.setItems(listaEstudiantes);
        }else{
            Utilidades.mostrarAlerta("Tutorado no encontrado", "Este tutorado no ha sido encontrado", Alert.AlertType.WARNING);
        }
    }

    
   
    
    @FXML
    private void btnBusqueda(javafx.event.ActionEvent event) {
        String busqueda = tfBuscador.getText();
        cargarEstudiantes(busqueda);    
    }
    
    @FXML
    private void seleccionarTutorado(MouseEvent event) {
        //String tutoradoSeleccionado = lvTutoradosEncontrados.getSelectionModel().getSelectedItem().toString();
        Estudiante tutoradoSeleccionado = lvTutoradosEncontrados.getSelectionModel().getSelectedItem();
        cargarTutorado(tutoradoSeleccionado);
    }

    
    private void cargarTutorado(Estudiante tutorado){
        lbTutorado.setText(tutorado.toString());
        lbMatricula.setText(tutorado.getMatricula());
        Tutor tutorActual = TutorDAO.buscarTutor(tutorado.getIdRol());
        lbTutorAcademico.setText(tutorActual.toString());
        cargarTutores();
    }
    private void cargarTutores(){
        ArrayList<Tutor> tutores = TutorDAO.cargarTutores();
        if(tutores != null){
           listaTutores = FXCollections.observableArrayList();
           listaTutores.addAll(tutores);
           cbTutores.setItems(listaTutores);
        }else{
            System.out.println("Error");
        }
    }

    @FXML
    private void btnGuardar(javafx.event.ActionEvent event) {
        Tutor tutor = cbTutores.getSelectionModel().getSelectedItem(); 
        
        if(tutor == null){
           Utilidades.mostrarAlerta("Error 403", "Error 403-No se seleccionó una opción. Seleccione una ", Alert.AlertType.WARNING);
        }else{
        guardarAsignacion(tutor);
        }
    }
    
    private void guardarAsignacion(Tutor tutor){
          Estudiante tutoradoSeleccionado = lvTutoradosEncontrados.getSelectionModel().getSelectedItem();
          tutoradoSeleccionado.setIdRol(tutor.getIdRol());
          int codigoRespuesta = EstudianteDAO.modificarTutor(tutoradoSeleccionado);
          if(codigoRespuesta == Constantes.CODIGO_OPERECION_CORRECTA){
              Utilidades.mostrarAlerta("Guardado", "Modificación exitosa", Alert.AlertType.INFORMATION);
          }else if(codigoRespuesta == Constantes.CODIGO_CREDENCIALES_INCORRECTAS){
              Utilidades.mostrarAlerta("Credenciales incorrectas", "El nombre o el tutor son erroneos", Alert.AlertType.ERROR);
          }else if(codigoRespuesta == Constantes.CODIGO_ERROR_CONEXIONDB){
              Utilidades.mostrarAlerta("Error", "Es imposible conectarse con la base de datos en estos momentos, inténtelo más tarde", Alert.AlertType.ERROR);
              regresar();
          }else if(codigoRespuesta == Constantes.CODIGO_OPERACION_DML_FALLIDA){
              Utilidades.mostrarAlerta("Error", "Es imposible realizar la consulta en estos momentos, inténtelo más tarde", Alert.AlertType.ERROR);
          }
    }

    @FXML
    private void btnCancelar(javafx.event.ActionEvent event) {
        lbTutorAcademico.setText("");
        lbTutorado.setText("");
        lbMatricula.setText("");
        cbTutores.setItems(null);
        tfBuscador.setText("");
        lvTutoradosEncontrados.setItems(null);
        tfBuscador.getCursor();
    }
 
    public void regresar(){
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestionTutoresAcademicoEstudiante.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbTutorado.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Gestion de tutores academicos y estudiantes");
           escenarioRegistrar.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnRegresar(javafx.event.ActionEvent event) {
        regresar();
    }
}
