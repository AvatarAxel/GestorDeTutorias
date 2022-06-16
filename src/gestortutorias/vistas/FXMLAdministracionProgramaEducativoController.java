/*
 * Autor : Andrea Alejandra Vargas Pucheta, Jesus Onofre Rodriguez Cortes
 * Fecha de creación: 10/06/2022
 * Fecha de modificación: 15/06/2022
 * Descripción: Mandar a la escena de asignar experiencia educativa a profesor
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


public class FXMLAdministracionProgramaEducativoController implements Initializable {

    @FXML
    private Label lbMenuPrincipal;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
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
    private void btnAsignarEEAProfesor(ActionEvent event) {
         try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistrarProfesorAExperiencia.fxml"));
           Parent root = loader.load();
           FXMLRegistrarProfesorAExperienciaController controladorEEAProfesor = loader.getController();
           Scene escenaEEAProfesor = new Scene(root);
           Stage escenarioEEAProfesor = new Stage();
           escenarioEEAProfesor.setScene(escenaEEAProfesor);
           escenarioEEAProfesor.initModality(Modality.APPLICATION_MODAL);
           escenarioEEAProfesor.show();        

       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnConsultarOfertaEducativa(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLConsultarOfertaEducativa.fxml"));
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
    
}
