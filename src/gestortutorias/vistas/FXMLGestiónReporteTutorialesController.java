/*
 * Autor : Obet.... , Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 
 * Fecha de modificación: 15/06/2022
 * Descripción: Mandar a la escena de Consultar Reporte de tutoria academica
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

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLGestiónReporteTutorialesController implements Initializable {

    @FXML
    private Label lbMenuPrincipal;

    /**
     * Initializes the controller class.
     */
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
    private void btnConsultarReporteTutorAcademico(ActionEvent event) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLConsultarReporteDeTutor.fxml"));
            Parent root = loader.load();
            FXMLConsultarReporteDeTutorController controladorConsultarReporteTutor = loader.getController();
            Scene escenaConsultarReporteTutor = new Scene(root);
            Stage escenarioConsultarReporteTutor = new Stage();
            escenarioConsultarReporteTutor.setScene(escenaConsultarReporteTutor);
            escenarioConsultarReporteTutor.initModality(Modality.APPLICATION_MODAL);
            escenarioConsultarReporteTutor.show();        

       }catch(IOException ex){
          ex.printStackTrace();
       }
        
    }
    
}
