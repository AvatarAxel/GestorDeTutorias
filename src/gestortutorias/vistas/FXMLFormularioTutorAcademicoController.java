/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestortutorias.vistas;

import gestortutorias.modelo.dao.RolDAO;
import gestortutorias.modelo.pojo.Rol;
import gestortutorias.util.Constantes;
import gestortutorias.util.Utilidades;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author je_zu
 */
public class FXMLFormularioTutorAcademicoController implements Initializable {

    @FXML
    private ToggleGroup tgTipoDocente;
    @FXML
    private TextField tfNombreTutor;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfApellidoMaterno;
    @FXML
    private TextField tfCorreoInstitucional;
    @FXML
    private TextField tfCorreoPersonal;
    @FXML
    private RadioButton rbDocenteCompleto;
    @FXML
    private RadioButton rbDocenteAsignatura;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnRegistrarTutor(ActionEvent event) {
        validarCampos();
    }

    @FXML
    private void btnCancelarRegistro(ActionEvent event) {
        cerrarVentana();
        
    }
    
    private void cerrarVentana(){
        Stage escenario = (Stage) tfNombreTutor.getScene().getWindow();
        escenario.close();
    }
    
    private void validarCampos(){
        String nombreTutor = tfNombreTutor.getText();
        String apellidoPaterno = tfApellidoPaterno.getText();
        String apellidoMaterno = tfApellidoMaterno.getText();
        String correoPersonal = tfCorreoPersonal.getText();
        String correoInstitucional = tfCorreoInstitucional.getText();
        boolean camposValidos = true;
        String docente = "";
        
        if(nombreTutor.isEmpty() || apellidoPaterno.isEmpty() || apellidoMaterno.isEmpty() || correoInstitucional.isEmpty() || correoPersonal.isEmpty()){
            Utilidades.mostrarAlerta("Error", "No se pueden dejar campos vacios", Alert.AlertType.WARNING);
            camposValidos = false;
            return;
        }
        
        camposValidos = verificarTextoCampo(nombreTutor);
        
        if(camposValidos){
            camposValidos = verificarTextoCampo(apellidoPaterno);
        }
        
        if(camposValidos){
            camposValidos = verificarTextoCampo(apellidoMaterno);
        }
        
        if(rbDocenteAsignatura.isSelected()){
            docente = "Por Asignatura";
        }else{
            if(rbDocenteCompleto.isSelected()){
                docente = "Tiempo Completo";
            }
            else{
                Utilidades.mostrarAlerta("Error", "No se selecciono una opción. Seleccione una", Alert.AlertType.WARNING);
                camposValidos = false;
                return;
            }
        }
        
        if (camposValidos) {
            camposValidos = verificarEmails(correoPersonal, correoInstitucional);
        }
            
        if(camposValidos){
            camposValidos = verificarTutorNuevo(correoInstitucional, correoPersonal);
        }
        
        
        if(camposValidos){
            String usuario = nombreTutor.replace(" ", "") + apellidoPaterno;
            String contrasena = apellidoPaterno + (int)(Math.random() * 1000);
            Rol rolTutor = new Rol();
            rolTutor.setNombre(nombreTutor);
            rolTutor.setApellidoPaterno(apellidoPaterno);
            rolTutor.setApellidoMaterno(apellidoMaterno);
            rolTutor.setCorreElectronicoPersonal(correoPersonal);
            rolTutor.setCorreoElectronicoInstitucional(correoInstitucional);
            rolTutor.setTipoDocente(docente);
            rolTutor.setTipoRol("Tutor");
            rolTutor.setNombreUsuario(usuario);
            rolTutor.setContrasena(contrasena);
            registrarTutor(rolTutor);
        }
    }
    
    private void registrarTutor(Rol rolTutor){
        int codigoRespuesta = RolDAO.insertarRol(rolTutor);
        switch(codigoRespuesta){
            case Constantes.CODIGO_OPERACION_CORRECTA:
                Utilidades.mostrarAlerta("Aviso", "Guardado con exito", Alert.AlertType.INFORMATION);
                break;
            case Constantes.CODIGO_OPERACION_DML_FALLIDA:
                Utilidades.mostrarAlerta("Error", "No hay conexion con la base de datos. Intentelo de nuevo", Alert.AlertType.WARNING);
                break;
            case Constantes.COODIGO_ERROR_CONEXIONBD:
                Utilidades.mostrarAlerta("Error", "No hay conexion con la base de datos. Intentelo de nuevo mas tarde", Alert.AlertType.ERROR);
                break;
        }
    }  
    /*Verifica si los correos electronico ingresados esten escritos correctamente, siguiendo la sintaxis "Tecto"@"texto"."texto". solo comprueba que esten bien escritos,
    no si exiten*/
    private boolean verificarEmails(String correElectronicoPersonal, String correoElectronicoInstitucional){
        Pattern verificarSintaxis = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher verificarCorreoInstitucional = verificarSintaxis.matcher(correoElectronicoInstitucional);
        Matcher verficarCorreoPersonal = verificarSintaxis.matcher(correElectronicoPersonal);
        
        if(verficarCorreoPersonal.find() == false || verificarCorreoInstitucional.find() == false){
            Utilidades.mostrarAlerta("Error", "Datos invalidos", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }
    /*Verifica si el Tutor que quiere registrar se encuentra en la base de datos, para esto se utilizan el correo electronico personal y el correo
    electronico institucional, ningun tutor puede tener los mismos correos, puede haber probabilidades que se llamen igual, es por eso que se opta por usar
    los correo para indentificar si ya estan registrados*/
    private boolean verificarTutorNuevo(String correoElectronicoInstitucional, String correoElectronicoPersonal){
        Rol rolTutorBD = RolDAO.obtenerInformacionRolesTutor(correoElectronicoInstitucional, correoElectronicoPersonal);
        
        if(rolTutorBD.getCorreoElectronicoInstitucional().equals(correoElectronicoInstitucional) || rolTutorBD.getCorreElectronicoPersonal().equals(correoElectronicoPersonal)){
            Utilidades.mostrarAlerta("Error", "Datos duplicados", Alert.AlertType.WARNING);
            return false;
        }
        return true;
    }
    /*Verifica que se ingrese en los campos del nombre, apellido paterno y el apellido materno puras letras, quitando numeros y caracteres raros*/
    private boolean verificarTextoCampo(String campoLleno){
        int valorASCCI = 0;
        
        for(int i = 0; i < campoLleno.length();i++){
            char caracter = campoLleno.charAt(i);
            valorASCCI = (int) caracter;
            if((valorASCCI > 0 && valorASCCI < 32)||(valorASCCI > 32 && valorASCCI < 65)|| (valorASCCI > 90 && valorASCCI < 97) || (valorASCCI > 122 && valorASCCI < 160 ) || (valorASCCI > 165 && valorASCCI <= 255)){
                Utilidades.mostrarAlerta("Error", "Datos Invalidos", Alert.AlertType.WARNING);
                return false;
            }
        }
        return true;
    } 
      
}
