import java.util.InputMismatchException;
import java.util.Scanner;

public class Anaquel {
    //Atributos
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
    public String verUbicacion() {
        return "\nEl producto esta ubicado en: \nAnaquel: "+numeroAnaquel+"  Seccion: "+seccion;
    }
    
    public int ingresarEntero(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        numero = sc.nextInt();
        return numero;
    }
    
    public int validarNumero(int numero, String advertencia, String mensaje){
        while (numero < 1) {
            System.out.println(advertencia+" vuelva a intenterlo");
            try {
                numero = ingresarEntero(mensaje);
            } catch (InputMismatchException e) {
                System.out.println("Ingrese numeros enteros por favor");
            }
        } 
        
        return numero;
    }
}
