package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Administrador;
import models.Menu;
import models.MenuPrincipal;


/**
 * FXML Controller class
 *
 * @author spart
 */
public class LoginController implements Initializable {

    private Administrador admin = new Administrador();
    private int contador = 0;
    
    @FXML
    private TextField inputUser;
    @FXML
    private PasswordField inputPassword;
    @FXML
    private Button btnAcceder;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void contadorIntentos(){                
        if (contador >= 3){
            btnAcceder.setDisable(true);
        }
    }

    
    @FXML
    private void accederSistema(ActionEvent event) throws IOException, Exception {
        
        String password = inputPassword.getText();
        String user = inputUser.getText();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
        

        if (admin.accederSistema(password, user)) {          
            Object eventSource = event.getSource(); 
            Node sourceAsNode = (Node) eventSource;
            Scene oldScene = sourceAsNode.getScene();
            javafx.stage.Window window = oldScene.getWindow();
            Stage stage = (Stage) window;
            stage.hide();

            Menu menuPrincipal = new MenuPrincipal();
            menuPrincipal.mostrarMenu();            

        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Alerta");
            alert.setContentText("Le queda "+(2-contador)+" intentos");
            alert.showAndWait();
            contador++;
            contadorIntentos();
        }
       
    }
    
}
