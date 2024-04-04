package models;

public abstract class Persona {
    //Atributos heredables 
    protected String nombre;
    
    //Métodos SETTER y GETTER
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
        
    //Demás métodos
    protected abstract String verSujeto();
    
}
