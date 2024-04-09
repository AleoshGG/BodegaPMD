package models;


public class Administrador extends Persona {
    //Atributos
    private String password;
    
    public Administrador() {
        super.nombre = "Admin";
        password = "admin1";
    }
    
    //Demás métodos    
    public boolean accederSistema(String password, String usuario){
        boolean bandera;         
            if (this.password.equals(password) && nombre.equals(usuario)) {
                //Validacion exitosa
                bandera = true;      
            } else {             
                bandera = false;
            }        
        return bandera;
    }    
    
}
