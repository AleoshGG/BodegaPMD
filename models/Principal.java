package models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {

    public static void main(String[] args) {
        launch (args);

    }
    
    @Override 
    public void start (Stage stage) throws Exception {
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("/views/viewLogin.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("/views/viewVerProveedores.fxml"));
>>>>>>> 89ba36a8f68898e729144c4c076f9d75ff70a3c2
        Scene scene = new Scene(root);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
    
    
    
}
