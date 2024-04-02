Object eventSource = event.getSource(); 
            Node sourceAsNode = (Node) eventSource ;
            Scene oldScene = sourceAsNode.getScene();
            javafx.stage.Window window = oldScene.getWindow();
            Stage stage = (Stage) window ;
            //stage.hide(); OCULTA LA ECENA
                        
            Parent root = FXMLLoader.load(getClass().getResource("/views/viewPrincipal.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("Inicio");
            stage.setScene(scene);