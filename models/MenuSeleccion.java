package models;

import java.util.InputMismatchException;
import java.util.Scanner;


public class MenuSeleccion extends Menu {
    private String categoria;
    
    @Override
    public String mostrarMenu() {
        categoria = "Sin categoria";
        int opcion;
        System.out.println("\nElija la categoria");
        try {
            opcion = super.ingresarEntero("1. Alimentos Enlatados\n2. Lacteos\n3. Bebidas\n4. Panaderia\n5. Carnes y embutidos\n6. Cereales y Legumbres\n7. Golosinas\n8. Limpieza\n9. Condimentos y Especias\n10. Cuidado personal\n11. Para el hogar\n12. Sin categoria\n>> ");
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
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    } 
    
    public String getCategoria() {
        return categoria;
    }
    
    public double ingresaDouble(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        double numero;
        System.out.print(mensaje);
        numero = sc.nextDouble();
        return numero;
    }
    
    public long ingresaLong(String mensaje) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        long numero;
        System.out.print(mensaje);
        numero = sc.nextLong();
        return numero;
    }
}
