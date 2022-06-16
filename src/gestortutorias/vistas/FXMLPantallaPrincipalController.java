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
           Scene escenaAdministracionSesionesTutoria = new Scene(root);
           
           Stage escenarioAdministracionSesionesTutorias = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioAdministracionSesionesTutorias.setTitle("");
           escenarioAdministracionSesionesTutorias.setScene(escenaAdministracionSesionesTutoria);
           escenarioAdministracionSesionesTutorias.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }


    @FXML
    private void btnAdministracionProgramaEducativo(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAdministracionProgramaEducativo.fxml"));
           Parent root = loader.load();
           Scene escenaAdministracionProgramaEducativo = new Scene(root);
           
           Stage escenarioAdministracionProgramaEducativo = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioAdministracionProgramaEducativo.setTitle("");
           escenarioAdministracionProgramaEducativo.setScene(escenaAdministracionProgramaEducativo);
           escenarioAdministracionProgramaEducativo.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnGestiónReporteTutoriales(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestiónReporteTutoriales.fxml"));
           Parent root = loader.load();
           Scene escenaGestionReporteTutoriales = new Scene(root);
           
           Stage escenarioGestionReporteTutoriales = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioGestionReporteTutoriales.setTitle("");
           escenarioGestionReporteTutoriales.setScene(escenaGestionReporteTutoriales);
           escenarioGestionReporteTutoriales.show();
           
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
           Scene escenaInicioSesion = new Scene(root);
           
           Stage escenarioInicioSesion = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioInicioSesion.setScene(escenaInicioSesion);
           escenarioInicioSesion.setTitle("Iniciar de sesión");
           escenarioInicioSesion.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    

    @FXML
    private void btnGestionTutoresAcademicosEstudiante(ActionEvent event) {
        try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGestionTutoresAcademicoEstudiante.fxml"));
           Parent root = loader.load();
           Scene escenaGestionTutoresAcademicosEstudiantes = new Scene(root);
           
           Stage escenarioGestionTutoresAcademicosEstudiantes = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioGestionTutoresAcademicosEstudiantes.setTitle("");
           escenarioGestionTutoresAcademicosEstudiantes.setScene(escenaGestionTutoresAcademicosEstudiantes);
           escenarioGestionTutoresAcademicosEstudiantes.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    @FXML
    private void btnSeguimientoProblematicascAdemicas(ActionEvent event) {
         try{
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSeguimientoProblemáticascAdemicas.fxml"));
           Parent root = loader.load();
           Scene escenaSeguimientoProblematicaAcademica = new Scene(root);
           
           Stage escenarioSeguimientoProblematicaAcademica = (Stage) lbMenuPrincipal.getScene().getWindow();
           escenarioSeguimientoProblematicaAcademica.setTitle("");
           escenarioSeguimientoProblematicaAcademica.setScene(escenaSeguimientoProblematicaAcademica);
           escenarioSeguimientoProblematicaAcademica.show();
           
       }catch(IOException ex){
          ex.printStackTrace();
       }
    }

    
}
