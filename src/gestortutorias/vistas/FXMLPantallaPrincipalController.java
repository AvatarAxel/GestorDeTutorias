/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestortutorias.vistas;

import gestortutorias.util.Variables;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLPantallaPrincipalController implements Initializable {

    @FXML
    private Label lbMenuPrincipal;
    @FXML
    private Button btnAdministracionSesionesTutoria;
    @FXML
    private Button btnAdministracionProgramaEducativo;
    @FXML
    private Button btnGestiónReporteTutoriales;
    @FXML
    private Button btnSeguimientoProblematicascAdemicas;
    @FXML
    private Button btnGestionTutoresAcademicosEstudiante;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lbMenuPrincipal.setText(Variables.getTipoRol());
        if(Variables.getTipoRol().equals("Tutor")){
           btnGestionTutoresAcademicosEstudiante.setVisible(false);
           btnAdministracionProgramaEducativo.setVisible(false);
           btnGestiónReporteTutoriales.setVisible(false);
           btnSeguimientoProblematicascAdemicas.setVisible(false);
        }
    }    

    @FXML
    private void btnAdministracionSesionesTutoria(javafx.event.ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAdministracionSesionesTutoria.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Administración de Sesiones Tutoria");
           escenarioRegistrar.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }


    @FXML
    private void btnAdministracionProgramaEducativo(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAdministracionProgramaEducativo.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Administracion de Programa Educativo");
           escenarioRegistrar.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnGestiónReporteTutoriales(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestiónReporteTutoriales.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Gestión de Reportes Tutoriales");
           escenarioRegistrar.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }
    
    

    @FXML
    private void btnRegresar(ActionEvent event) {
        cerrarSesion();
    }
    public void cerrarSesion(){
        Variables.setTipoRol("");
       try{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLIniciarSesion.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Iniciar de sesión");
           escenarioRegistrar.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    

    @FXML
    private void btnGestionTutoresAcademicosEstudiante(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestionTutoresAcademicoEstudiante.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Administración de Sesiones Tutoria");
           escenarioRegistrar.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnSeguimientoProblematicascAdemicas(ActionEvent event) {
         try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSeguimientoProblemáticascAdemicas.fxml"));
           Parent root = loader.load();
           Scene escenaRegistrarReporte = new Scene(root);
           
           Stage escenarioRegistrar = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioRegistrar.setScene(escenaRegistrarReporte);
           escenarioRegistrar.setTitle("Seguimiento de Problemáticas Ademicas");
           escenarioRegistrar.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    
}
