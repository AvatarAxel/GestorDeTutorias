package gestortutorias.vistas;

import gestortutorias.modelo.dao.EstudianteDAO;
import gestortutorias.modelo.dao.RolDAO;
import gestortutorias.modelo.pojo.Estudiante;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXMLAsignarTutorAcademicoAEstudianteController implements Initializable {

    @FXML
    private TableView tbAsignacion;
    @FXML
    private TableColumn<?, ?> colNumero;
    @FXML
    private TableColumn<?, ?> colEstudiante;
    @FXML
    private TableColumn colTutorAcademico;
    @FXML
    private TableColumn<?, ?> colTotalTutorados;
    
    // TODO
    
    private ObservableList<Estudiante> listaEstudiantes; 
    private ObservableList<Rol> infoRol;
    //count(*) FROM estudiantes WHERE idRol = '?';


    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        configurarColumnasTabla();
        cargarInformacionEstudiante();
        cargarInformacionTutor();
    }
    
    private void configurarColumnasTabla(){
        colEstudiante.setCellValueFactory(new PropertyValueFactory("nombreCompletoEstudiante"));
        colTutorAcademico.setCellValueFactory(new PropertyValueFactory("prueba"));
        listaEstudiantes = FXCollections.observableArrayList();
    }    
    
    private void cargarInformacionEstudiante(){
        ArrayList<Estudiante> resultadoConsulta = EstudianteDAO.obtenerInformacionEstudiante();
        if(resultadoConsulta != null){
            listaEstudiantes.addAll(resultadoConsulta);
            tbAsignacion.setItems(listaEstudiantes);
        }else{
            Utilidades.mostrarAlerta("Error de conexion", "Por el momento no hay conexion con la BD", Alert.AlertType.ERROR); 
        }
    }    
    
    private void cargarInformacionTutor(){
        //ComboBox comboBoxRol = RolDAO.obtenerInformacionTutor();
        /*if(comboBoxRol != null){*/
            if(listaEstudiantes.size() > 0){
                for(int i = 0; i<listaEstudiantes.size(); i++){
                    ComboBox comboBoxRol = RolDAO.obtenerInformacionTutor();
                    System.out.println(i+" "+listaEstudiantes.get(i).getNombreCompletoEstudiante());
                    listaEstudiantes.get(i).setPrueba(comboBoxRol); //(i, comboBoxRol.getItems().get(i));
                }
            }            
       /* }else{
            Utilidades.mostrarAlerta("Error de conexion", "Por el momento no hay conexion con la BD", Alert.AlertType.ERROR); 
        }*/
    }
    
    private void asignarTutorAlumno(){
        if(listaEstudiantes.size() > 0){
            for(int i = 0; i<listaEstudiantes.size(); i++){
                System.out.println(i+" "+listaEstudiantes.get(i).getNombreCompletoEstudiante()+" - "+listaEstudiantes.get(i).getPrueba().getSelectionModel().getSelectedItem());
            }
        }
    }

    @FXML
    private void btnGuardar(ActionEvent event) {
        //System.out.println(listaEstudiantes.get(4).getPrueba().getSelectionModel().getSelectedItem());
        asignarTutorAlumno();
    }

    @FXML
    private void btnCancelar(ActionEvent event) {
        cerrarVentana();
    }
    
    private void cerrarVentana() {
        Stage escenario = (Stage)tbAsignacion.getScene().getWindow();
        escenario.close();
    }    
    
}
