import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Producto {
    //Atributos
    private int codigoBarras;
    private double costo;
    private String nombre;
    private String categoria;
    private Calendar fechaCaducidad;
    private Proveedor proveedor = new Proveedor();
    private Anaquel anaquel = new Anaquel();
    private int existenciaProducto;
    
    //Métodos SETTER y GETTER
    public void setCodigoBarras(int codigo){  
        codigoBarras = validarCodigo(codigo);
    }
    
    public void setCosto(double costo){
        this.costo = validarNumero(costo,"No puede costar menos de 0","Ingrese el costo con el que se adquirio: ");
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public void setFecha(Calendar fecha){
        fechaCaducidad = fecha;
    }
    
    public void setProveedor(Proveedor proveedor){
        this.proveedor = proveedor;
    }
    
    public void setAnaquel(Anaquel anaquel){
        this.anaquel = anaquel;
    }
    
     public void setExistenciaProducto(int existencia){
        existenciaProducto = validarNumero(existencia, "No ingrese valores negativos", "Ingrese la cantidad de productos a guardar: ");
    }
    
    public int getCodigoBarras(){
        return codigoBarras;
    }
    
    public double getCosto(){
        return costo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public Calendar getFechaCaducidad(){
        return fechaCaducidad;
    }
    
    public Proveedor getProveedor(){
        return proveedor;
    }
    
    public Anaquel getAnaquel(){
        return anaquel;
    }
    
    public int getExistenciaProducto(){
        return existenciaProducto;
    }
   
    //Demás métodos
    public void incluirProveedor() {
        Scanner sc = new Scanner(System.in);
        
        try {
            System.out.print("Ingrese el nombre: ");
            this.proveedor.setNombre(sc.nextLine());
            long numero = ingresarLong("Ingrese el numero de telefono: ");
            this.proveedor.setTelefono(numero);
            System.out.print("\nIngrese la direccion: ");
            this.proveedor.setDireccion(sc.nextLine());
        } catch (InputMismatchException e) {
            System.out.println("Vuelva a intentarlo");
        }
        
    }
    
    public void incluirAnaquel() {
        try {
            int numeroA = ingresarEntero("Ingrese el numero de anaquel: : ");
            this.anaquel.setNumeroAnaquel(numeroA);
            int numeroS = ingresarEntero("Ingrese el numero de seccion: ");
            this.anaquel.setSeccion(numeroS);
        } catch (InputMismatchException e) {
            System.out.println("Intentelo de nuevo");
        }
       
    }
    
    public int validarCodigo(int codigo) {
        while (codigo < 100000000 || codigo > 999999999) {
            codigo = validarNumero(codigo, 100000000,999999999,"El codigo no puede tener mas o menos de 9 digitos enteros","Ingrese el codigo de barras: ");
        }
        return codigo;
    }
    
     public int ingresarEntero(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        numero = sc.nextInt();
        return numero;
    }
     
    public double ingresarDouble(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        double numero;
        System.out.print(mensaje);
        numero = sc.nextInt();
        return numero;
    }
    
    public long ingresarLong(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        long numero;
        System.out.print(mensaje);
        numero = sc.nextLong();
        return numero;
    }
    
    public int validarNumero(int numero, int limiteI,int limiteD, String advertencia, String mensaje){
        while (numero < limiteI || numero > limiteD) {
            System.out.println(advertencia+" vuelva a intenterlo");
            try {
                numero = ingresarEntero(mensaje);
            } catch (InputMismatchException e) {
                System.out.println("Ingrese numeros por favor");
            }
        }
        
        return numero;
    }
    
    public int validarNumero(int numero, String advertencia, String mensaje){
        while (numero < 1) {
            System.out.println(advertencia+" vuelva a intenterlo");
            try {
                numero = ingresarEntero(mensaje);
            } catch (InputMismatchException e) {
                System.out.println("Ingrese numeros por favor");
            }
        }
        
        return numero;
    }
    
    public double validarNumero(double numero, String advertencia, String mensaje){
        while (numero < 1) {
            System.out.println(advertencia+" vuelva a intenterlo");
            try {
                numero = ingresarDouble(mensaje);
            } catch (InputMismatchException e) {
                System.out.println("Ingrese numeros por favor");
            }
        }
        
        return numero;
    }
    
    public long validarNumero(long numero, String advertencia, String mensaje){
        while (numero < 1) {
            System.out.println(advertencia+" vuelva a intenterlo");
            try {
                numero = ingresarEntero(mensaje);
            } catch (InputMismatchException e) {
                System.out.println("Ingrese numeros por favor");
            }
        }
        
        return numero;
    }
}
