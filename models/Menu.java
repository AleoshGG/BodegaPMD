package models;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.scene.control.Alert;

public abstract class Menu {
    private int opcion;
    private ArrayList lista;
    
    public abstract Object mostrarMenu();
    
    public boolean leerLista(ArrayList lista, String mensaje) {
        boolean bandera = false;
        
        if (lista   .size() >= 1) {
            bandera = true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Alerta");
            alert.setContentText(mensaje);
            alert.showAndWait();
        }
        
        return bandera;
    }
    
    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    
    public void setLista(ArrayList lista) {
        this.lista = lista;
    }
    
    public int getOpcion() {
        return opcion;
    }
    
    public ArrayList getLista() {
        return lista;
    }
    
    public int ingresarEntero(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        numero = sc.nextInt();
        return numero;
    }

}
