package models;

import java.util.InputMismatchException;

public class Proveedor extends Persona {
    //Atributos 
    private MenuSeleccion menuSeleccion = new MenuSeleccion();
    private long telefono;
    private String direccion;
        
    //Métodos SETTER y GETTER
    public void setTelefono(long numero){
        telefono = validarNumero(numero,"Ingrese numeros enteros","Ingrese el numero telefonico: ");
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public long getTelefono(){
        return telefono;
    }
    
    public String getDireccion(){
        return direccion;
    }
    
    //Demás métodos
    public String verSujeto() {
        return "\nNombre: "+nombre+"\nDireccion: "+direccion+"\nTelefono: "+telefono;
    }
        
    public long validarNumero(long numero, String advertencia, String mensaje){
        while (numero < 1) {
            System.out.println(advertencia+" vuelva a intenterlo");
            try {
                numero = menuSeleccion.ingresaLong(mensaje);
            } catch (InputMismatchException e) {
                System.out.println("Ingrese numeros por favor");
            }
        }
        
        return numero; 
    }
}
