
import java.util.InputMismatchException;
import java.util.Scanner;

public class Proveedor extends Persona {
    //Atributos 
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
    
    public long ingresarLong(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        long numero;
        System.out.print(mensaje);
        numero = sc.nextLong();
        return numero;
    }
    
    public long validarNumero(long numero, String advertencia, String mensaje){
        while (numero < 1) {
            System.out.println(advertencia+" vuelva a intenterlo");
            try {
                numero = ingresarLong(mensaje);
            } catch (InputMismatchException e) {
                System.out.println("Ingrese numeros por favor");
            }
        }
        
        return numero; 
    }
}
