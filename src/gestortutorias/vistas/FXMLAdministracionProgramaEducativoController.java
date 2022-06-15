/*
 * Autor : Obet.... , Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 
 * Fecha de modificación: 15/06/2022
 * Descripción: Mandar a la escena de asignar experiencia educativa a profesor
 */
package gestortutorias.vistas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLAdministracionProgramaEducativoController implements Initializable {

    @FXML
    private Label lbMenuPrincipal;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    
}