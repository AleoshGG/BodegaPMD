import java.util.Scanner;

public class Administrador extends Persona {
    //Atributos
    private String password;
    
    public Administrador() {
        super.nombre = "Admin";
        password = "admin1";
    }
    
    //Demás métodos    
    public boolean accederSistema(){
        Scanner sc = new Scanner(System.in);
        boolean bandera;
        String password,usuario;
        int contador = 0;
        
        System.out.println("\tLogin");
        
        do {
            System.out.print("Ingrese el usuario: ");
            usuario = sc.nextLine();
            System.out.print("Ingrese la contrasenia: ");
            password = sc.nextLine();
            
            if (this.password.equals(password) && nombre.equals(usuario)) {
                //Validacion exitosa
                bandera = true;
                contador = 0;
            } else {
                contador++;
                bandera = false;
            }
        
        } while (contador != 0 && contador < 3);
        
        return bandera;
    }
    
    public String verSujeto() {
        return "\nNombre: "+nombre;
    }
    
}
