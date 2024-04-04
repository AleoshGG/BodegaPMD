package models;

import java.util.InputMismatchException;
import java.util.Scanner;
import javafx.scene.control.Alert;

public class Anaquel {
    //Atributos
    private MenuSeleccion menuSeleccion = new MenuSeleccion();
    private int numeroAnaquel;
    private int seccion;
    
    //Métodos SETTER y GETTER
    public void setNumeroAnaquel(int numero){      
        numeroAnaquel = validarNumero(numero,"Los anaqueles comienzan desde el 1", "Ingrese el numero de anaquel: ");
    }
    
    public void setSeccion(int seccion){
        this.seccion = validarNumero(seccion,"Las secciones comienzan desde el 1", "Ingrese el numero de seccion: ");
    }    
    
    public int getNumeroAnaquel(){
        return numeroAnaquel;
    }
    
    public int getSeccion(){
        return seccion;
    }
     
    //Demás métodos
    public void verUbicacion() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Ubicación del producto");
        alert.setContentText("El producto está ubicado en: \nAnaquel: " +  numeroAnaquel + " Sección: " + seccion);
        alert.showAndWait();
    }
    
    
    public int validarNumero(int numero, String advertencia, String mensaje){
        while (numero < 1) {
            System.out.println(advertencia+" vuelva a intenterlo");
            try {
                numero = menuSeleccion.ingresarEntero(mensaje);
            } catch (InputMismatchException e) {
                System.out.println("Ingrese numeros enteros por favor");
            }
        } 
        
        return numero;
    }
}
