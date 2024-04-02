import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Inventario {
    private ArrayList<Producto> productos = new ArrayList();
    
    public ArrayList<Producto> getListaProductos() {
        return productos;
    }
    
    private int ingresarEntero(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int numero;
        System.out.print(mensaje);
        numero = sc.nextInt();
        return numero;
    }
    
    private double ingresaDouble(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        double numero;
        System.out.print(mensaje);
        numero = sc.nextDouble();
        return numero;
    }
    
    private long ingresaLong(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        long numero;
        System.out.print(mensaje);
        numero = sc.nextLong();
        return numero;
    }
    
    public void crearProducto(ArrayList<Proveedor> proveedores) {
        Scanner sc = new Scanner(System.in);
        Producto producto = new Producto();
        boolean bandera = true;
        
        do {
            System.out.println("\tREGISTRO DEL PRODUCTO");
            try {
                int codigo = ingresarEntero("Ingrese el codigo de barras: ");
                producto.setCodigoBarras(codigo);             
                System.out.print("Ingrese el nombre: ");
                producto.setNombre(sc.nextLine());  
                double costo = ingresaDouble("Ingrese el costo con el que se adquirio: ");
                producto.setCosto(costo);
                producto.setCategoria(elegirCategoria());              
                agregarFecha(producto);
                System.out.println("\tUbicacion");
                int numeroA = ingresarEntero("Ingrese el numero de anaquel: ");
                producto.getAnaquel().setNumeroAnaquel(numeroA);
                int numeroS = ingresarEntero("Ingrese el numero de seccion: ");
                producto.getAnaquel().setSeccion(numeroS);
                int cantidad = ingresarEntero("Ingrese la cantidad de productos a guardar: ");
                producto.setExistenciaProducto(cantidad);
                agregarProveedor(proveedores, producto);
                productos.add(producto);
                System.out.println("\n\tGUARDADO");
                bandera = false;
            } catch (InputMismatchException e){
                System.out.println("Vuelva a intentarlo");
            }
            
        } while (bandera);
    }
    
    public String elegirCategoria() {
        String categoria = "Sin categoria";
        int opcion;
        System.out.println("\nElija la categoria");
        try {
            opcion = ingresarEntero("1. Alimentos Enlatados\n2. Lacteos\n3. Bebidas\n4. Panaderia\n5. Carnes y embutidos\n6. Cereales y Legumbres\n7. Golosinas\n8. Limpieza\n9. Condimentos y Especias\n10. Cuidado personal\n11. Para el hogar\n12. Sin categoria\n>> ");
        } catch (InputMismatchException e) {
            opcion = 15;
        }
        
        switch (opcion) {
            case 1: categoria = "Alimentos Enlatados";
            break;
            case 2: categoria = "Lacteos";
            break;
            case 3: categoria = "Bebidas";
            break;
            case 4: categoria = "Panaderia";
            break;
            case 5: categoria = "Carnes y Embutidos";
            break;
            case 6: categoria = "Cereales y Legumbres";
            break;
            case 7: categoria = "Golosinas";
            break;
            case 8: categoria = "Limpieza";
            break;
            case 9: categoria = "Condimentos y Especias";
            break;
            case 10: categoria = "Cuidado personal";
            break;
            case 11: categoria = "Para el hogar";
            break;
            case 12: categoria = "Sin categoria";
            break;
            default:
            break;
        }
        return categoria;
    }
    
    private void agregarFecha(Producto producto) {
        int year, month, day;
        boolean bandera = true;
        
        do {
            try {
                System.out.println("\n\tFecha de caducidad");
                year = ingresarEntero("Ingrese el anio: ");
                month = ingresarEntero("Ingrese el mes: ");
                day = ingresarEntero("Ingrese el dia: ");

                if (year > 2000 && year <2050 && month > 0 && month < 13 && day > 0 && day < 32) {
                    Calendar fechaCaducidad = Calendar.getInstance();
                    fechaCaducidad.set(year, month, day);
                    producto.setFecha(fechaCaducidad);
                    bandera = false;
                } else {
                    System.out.println("Verifique el formato de las fechas");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vuelva a intentarlo");
            }
        } while (bandera);
        
        
    }
    
    public void agregarProveedor(ArrayList<Proveedor> proveedores, Producto producto) {
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        String nombre;
        
        if (proveedores.size()>=1) {
            do {
                try {
                    int opcion = ingresarEntero("\nDesea agregar un proveedor existente? \n1. SI\n2. NUEVO\n>> ");
                    
                    if (opcion == 1) {
                        System.out.print("\nEscriba el nombre del proveedor: ");
                        nombre = sc.nextLine();
                        for (int i = 0; i < proveedores.size(); i++) {
                            if (nombre.equals(proveedores.get(i).getNombre())) {
                                producto.setProveedor(proveedores.get(i));
                                bandera = false;
                            }
                        }
                        if (bandera) {
                            System.out.println("NO ENCONTRADO");
                        }
                    } else if (opcion == 2) {
                        agregarNuevoProveedor(proveedores, producto);
                        bandera = false;
                    } else if (opcion < 1 || opcion > 2) {
                        System.out.println("Intente de nuevo");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Vuelva a intentarlo");
                }                
            } while (bandera);                 
        } else {
            agregarNuevoProveedor(proveedores, producto);
        }      
    }
    
    public void agregarNuevoProveedor(ArrayList<Proveedor> proveedores, Producto producto) {
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;
        System.out.println("\n\tAgregar Nuevo Proveedor");
        Proveedor proveedor = new Proveedor();
                
        System.out.print("Ingrese el nombre: ");
        proveedor.setNombre(sc.nextLine());
        System.out.print("Ingrese la direccion: ");
        proveedor.setDireccion(sc.nextLine());    
        do {
            try {
                long numero = ingresaLong("Ingrese el numero telefonico: ");
                proveedor.setTelefono(numero);
                producto.setProveedor(proveedor);
                proveedores.add(proveedor);
                bandera = false;
            } catch (InputMismatchException e) {
                System.out.println("Vuelva a intentarlo");
            } 
        } while (bandera);
    }
    
    public void guardarProducto() {
        boolean bandera = true;
        
        do {
            try {
                System.out.println("\n\tGuardar Productos");
                String categoria = elegirCategoria();
                int codigo = ingresarEntero("Ingrese el codigo de barras: ");
                int cantidad = ingresarEntero("Ingrese la cantidad a guardar: ");

                for (int i = 0; i < productos.size(); i++) {
                    if (categoria.equals(productos.get(i).getCategoria()) && codigo == productos.get(i).getCodigoBarras()) {
                        productos.get(i).setExistenciaProducto(cantidad+productos.get(i).getExistenciaProducto());
                        agregarFecha(productos.get(i));
                        bandera = false;
                    }
                }
                if (bandera) {
                    System.out.println("NO ENCONTRADO");
                }
            } catch (InputMismatchException e) {
                System.out.println("Vuelve a intentarlo");
            }      
        } while(bandera);
    }
    
    public void sacarProducto() {
        boolean bandera = true;
        
        do {
            try {
                System.out.println("\n\tSacar Productos");
                String categoria = elegirCategoria();
                int codigo = ingresarEntero("Ingrese el codigo de barras: ");
                int cantidad = ingresarEntero("Ingrese la cantidad a sacar: ");
                
                if (cantidad > 0) {
                    for (int i = 0; i < productos.size(); i++) {
                        if (categoria.equals(productos.get(i).getCategoria()) && codigo == productos.get(i).getCodigoBarras()) {
                            int numero = productos.get(i).getExistenciaProducto()-cantidad;
                            if (numero >= 0) {
                                productos.get(i).setExistenciaProducto(numero);
                                bandera = false;
                            } else {
                                System.out.println("No se puede sacar mas de lo que se tiene guardado");
                                bandera = false;
                            }
                        }
                    }
                    if (bandera) {
                        System.out.println("NO ENCONTRADO");
                    }
                } else {
                    System.out.println("Verifique las cantidades");
                }           
            } catch (InputMismatchException e) {
                System.out.println("Vuelve a intentarlo");
            }      
        } while(bandera);
    }
    
    public void eliminarProducto(int comportamiento) {
        boolean bandera = true;
        Calendar fechaActual = Calendar.getInstance();
        int year = fechaActual.get(Calendar.YEAR);
        int month = fechaActual.get(Calendar.MONTH);
        int day = fechaActual.get(Calendar.DAY_OF_MONTH);
        fechaActual.set(year, month, day);
        
        if (comportamiento == 0) {
                for (int i = 0; i < productos.size(); i++) {
                    if (!productos.get(i).getFechaCaducidad().before(fechaActual)) {
                    } else {
                        System.out.println("PRODUCTO CADUCADO");
                        productos.remove(i);
                        bandera = false;
                    }
                }        
        } 
            
        if (comportamiento == 1) {
            do {
                System.out.println("\n\tEliminar Producto");
                String categoria = elegirCategoria();
                try {
                    int codigo = ingresarEntero("Ingrese el codigo de barras: ");
                    for (int i = 0; i < productos.size(); i++) {
                        if ((categoria.equals(productos.get(i).getCategoria()) && codigo == productos.get(i).getCodigoBarras())) {
                            productos.remove(i);
                            bandera = false;
                        }
                    }
                    if (bandera) {
                        System.out.println("NO ENCONTRADO");
                        bandera = false;
                    }            
                } catch (InputMismatchException e) {
                    System.out.println("Vuelva a intentarlo");
                }
            } while (bandera);         
        }
                      
    }
    
    public void modificarProducto(ArrayList<Proveedor> proveedores) {
        Scanner sc = new Scanner(System.in);
        String categoria = elegirCategoria();
        boolean bandera = true;
        int codigo;
        
        System.out.println("\n\tEdicion de productos");
        try {
                codigo = ingresarEntero("Ingrese el codigo de barras: ");
                for (int i = 0; i < productos.size(); i++) {
                    if ((categoria.equals(productos.get(i).getCategoria()) && codigo == productos.get(i).getCodigoBarras())) {
                        int opcion;
                        System.out.println("Elija el campo que desera alterar: ");
                        try {
                            opcion = ingresarEntero("1. Atributos (Nombre/Categoria/Codigo de barras)\n2. Ubicacion\n3. Proveedor\n4. Fecha de caducidad \n5. Adquisicion (Cantidad/Precio)\n6. Regresar\n>> ");
                        } catch (InputMismatchException e) {
                            opcion = 15;
                        }

                        switch (opcion){
                            case 1:
                                System.out.print("Ingrese la categoria del producto: ");
                                productos.get(i).setCategoria(elegirCategoria());
                                try {
                                    codigo = ingresarEntero("Ingrese el codigo de barras: ");
                                    productos.get(i).setCodigoBarras(codigo);
                                    sc.nextLine();
                                    System.out.print("Ingrese el nombre del producto: ");
                                    productos.get(i).setNombre(sc.nextLine());
                                } catch (InputMismatchException e) {
                                    System.out.println("Vuelve a intentarlo");
                                }
                            break;
                            case 2:
                                try {
                                    int numeroA = ingresarEntero("Ingrese el numero de anaquel: ");
                                    productos.get(i).getAnaquel().setNumeroAnaquel(numeroA);
                                    int numeroS = ingresarEntero("Ingrese el numero de seccion: ");
                                    productos.get(i).getAnaquel().setSeccion(numeroS);
                                } catch (InputMismatchException e) {
                                    System.out.println("Vuelve a intentarlo");
                                }         
                            break;
                            case 3:
                                agregarProveedor(proveedores, productos.get(i));
                            break;
                            case 4:
                                agregarFecha(productos.get(i));
                            break;
                            case 5:
                                try {
                                    int cantidad = ingresarEntero("Ingrese la cantidad de productos a guardar: ");
                                    productos.get(i).setExistenciaProducto(cantidad);
                                    double costo = ingresaDouble("Ingrese el costo con el que se adquirio: ");
                                    productos.get(i).setCosto(costo);
                                } catch (InputMismatchException e) {
                                    System.out.println("Intentalo de nuevo");
                                }
                            break;
                            case 6:
                            break;
                            default:System.out.println("No valido");
                            break;
                        }
                        bandera = false;
                        }
                    }
                if (bandera) {
                    System.out.println("NO ENCONTRADO");
                } 
            } catch (InputMismatchException e) {
                System.out.println("Vuelva a intentarlo");
            }     
    } 
}
