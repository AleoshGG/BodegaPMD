package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;


public class VerProductosController implements Initializable {
    @FXML 
    private ChoiceBox CBCategorias;
    private String[] categoriasP = {"Alimentos Enlatados","Lacteos","Bebidas","Panaderia","Carnes y Embutidos","Cereales y Legumbres","Golosinas","Limpieza","Condimentos y Especias","Cuidado personal","Para el hogar","Sin categoria"};

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CBCategorias.getItems().addAll(categoriasP);  
    }
    
    public void getCategoria(ActionEvent event) {
        String categoria = (String) CBCategorias.getValue();
    }
    
}
