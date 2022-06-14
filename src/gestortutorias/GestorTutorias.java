package gestortutorias;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class GestorTutorias extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("vistas/FXMLAsignarTutorAcademicoAEstudiante.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("vistas/FXMLConsultarReporteDeTutor.fxml"));
>>>>>>> 250ac05d66657c54d9192e88ed6223dd656f22c5
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
