 /* Autor: Axel Saturnino Mendoza Domingo, Jesus Onofre Rodriguez Cortes, Obet Jair Hernández González
 * Fecha de creación: 08/06/2022
 * Fecha de modificación: 
 * Descripción: Manda a escena las opciones de ModificarAsignacionTutorAcadémico, RegistrarTutorAcademico y AsignarTutorAcademicoEstudiante
 */
package gestortutorias.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FXMLGestionTutoresAcademicoEstudianteController implements Initializable {

    @FXML
    private Label lbMenuPrincipal;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }    
    
    
    public void regresar(){
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMGestionTutoresAcademicoEstudiante.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Gestion de tutores academicos y estudiantes");
           escenarioRegistrar.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnRegresar(ActionEvent event) {
        try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLPantallaPrincipal.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Menú principal");
           escenarioRegistrar.show();
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnModificarAsignacionTutorAcademico(ActionEvent event) {
         try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLModificarAsignacionTutorAcademico.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Modificar Asignacion de Tutor Academico");
           escenarioRegistrar.show();
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnRegistrarTutorAcademico(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistrarTutorAcademico.fxml"));
           Parent root = loader.load();
           Scene escenaTablaReporte = new Scene(root);
           Stage escenarioTablaReportes = new Stage();
           escenarioTablaReportes.setScene(escenaTablaReporte);
           escenarioTablaReportes.initModality(Modality.APPLICATION_MODAL);
           escenarioTablaReportes.show();        

       }catch(IOException ex){
          ex.printStackTrace();
        }
    }

    @FXML
    private void btnAsignarTutorAcademicoEstudiante(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAsignarTutorAcademicoAEstudiante.fxml"));
            Parent root = loader.load();
            Scene escenaTablaReporte = new Scene(root);
            Stage escenarioTablaReportes = new Stage();
            escenarioTablaReportes.setScene(escenaTablaReporte);
            escenarioTablaReportes.initModality(Modality.APPLICATION_MODAL);
            escenarioTablaReportes.show();
        } catch (IOException ex) {
            ex.printStackTrace();

        }

    }
}
