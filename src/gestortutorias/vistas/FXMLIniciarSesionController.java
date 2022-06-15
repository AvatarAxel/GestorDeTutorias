/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package gestortutorias.vistas;

import gestortutorias.modelo.dao.TutorDAO;
import gestortutorias.modelo.pojo.Tutor;
import gestortutorias.util.Constantes;
import gestortutorias.util.Utilidades;
import gestortutorias.util.Variables;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class FXMLIniciarSesionController implements Initializable {

    @FXML
    private TextField tfUsuario;
    @FXML
    private PasswordField pfContrasenia;
    @FXML
    private Label lbErrorUsuario;
    @FXML
    private Label lbErrorContrasenia;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnIniciarSesion(javafx.event.ActionEvent event) {
        String usuario = tfUsuario.getText();
        String password = pfContrasenia.getText();
        boolean valido = true;
        
        if(usuario.isEmpty()){
            lbErrorUsuario.setText("Usuario requerido");
            valido = false;
        }
        if(password.isEmpty()){
            lbErrorContrasenia.setText("Contraseña requerida");
            valido = false;
        }
        if(valido){
            
          validarUsuarioBD(usuario, password);
        }    
    }

    private void validarUsuarioBD(String usuario, String password) {
        Tutor tutor = TutorDAO.iniciarSesion(usuario, password);
        if(tutor.getCodigoRespuesta() == Constantes.CODIGO_OPERECION_CORRECTA){
             Utilidades.mostrarAlerta("Usuario verificado", "Bienvenido(a) al sistema", Alert.AlertType.INFORMATION);
             Variables.setTipoRol(tutor.getTipoRol());
             irPantallaPrincipal();
        }else if (tutor.getCodigoRespuesta() == Constantes.CODIGO_CREDENCIALES_INCORRECTAS){
             Utilidades.mostrarAlerta("Credenciales incorrectas", "El usuario o contraseña introducidos son incorrectos", Alert.AlertType.WARNING);
        }else if(tutor.getCodigoRespuesta() == Constantes.CODIGO_ERROR_CONEXIONDB){
             Utilidades.mostrarAlerta("Erros al conectar con la base de datos","Intentelo más tarde.", Alert.AlertType.ERROR);
        }   
    
    }
    
    
    private void irPantallaPrincipal(){
     try{
            Stage escenarioPrincipal = (Stage) tfUsuario.getScene().getWindow();
            escenarioPrincipal.setTitle("Menu principal");
            Scene menuPrincipal = new Scene(FXMLLoader.load(getClass().getResource("FXMLPantallaPrincipal.fxml")));
            escenarioPrincipal.setScene(menuPrincipal);
            escenarioPrincipal.show();
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
}
    
    
  
    

