package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import models.Menu;


public class VerProductosController implements Initializable {
    @FXML 
    private ChoiceBox<String> CBCategorias;
    @FXML 
    private Button btnVolver;
    
    private String[] categoriasP = {"Alimentos Enlatados","Lacteos","Bebidas","Panaderia","Carnes y Embutidos","Cereales y Legumbres","Golosinas","Limpieza","Condimentos y Especias","Cuidado personal","Para el hogar","Sin categoria"};
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        CBCategorias.getItems().addAll(categoriasP);  
        
        CBCategorias.setOnAction(event -> {
            try {
                this.getCategoria((ActionEvent) event);
            } catch (IOException ex) {
                Logger.getLogger(VerProductosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void getCategoria(ActionEvent event) throws IOException {
        Object eventSource = event.getSource(); 
        Node sourceAsNode = (Node) eventSource;
        Scene oldScene = sourceAsNode.getScene();
        javafx.stage.Window window = oldScene.getWindow();
        Stage stage = (Stage) window;
            
        Parent root = FXMLLoader.load(getClass().getResource("/views/viewVerProductos.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Ver los productos");
        stage.setScene(scene);                   
        stage.show();
            
        String categoria = CBCategorias.getValue();
        System.out.println(categoria);
    }
    
    @FXML
    private void regresar(ActionEvent event) throws IOException, Exception {
        Object eventSource = event.getSource(); 
        Node sourceAsNode = (Node) eventSource;
        Scene oldScene = sourceAsNode.getScene();
        javafx.stage.Window window = oldScene.getWindow();
        Stage stage = (Stage) window;
        stage.hide();
        
    }
}
