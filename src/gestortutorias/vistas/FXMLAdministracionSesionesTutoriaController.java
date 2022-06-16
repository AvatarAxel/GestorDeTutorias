/*
 * Autor : Andrea Alejandra Vargas Pucheta
 * Fecha de creación: 
 * Fecha de modificación: 15/06/2022
 * Descripción: Mandar a la escena las opciones disponibles en la ventana (no forman parte de los CU´s a realizar)
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
import javafx.stage.Stage;


public class FXMLAdministracionSesionesTutoriaController implements Initializable {

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
    
}
