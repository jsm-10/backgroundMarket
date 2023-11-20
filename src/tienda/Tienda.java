
package tienda;

import java.util.Scanner;
import tienda.servicios.fabricanteservice;
import tienda.servicios.productoservice;


public class Tienda {

  
    public static void main(String[] args) throws Exception {
        
    productoservice ProductoService = new productoservice();
    
    fabricanteservice FabricanteService = new fabricanteservice();
    Scanner sc = new Scanner(System.in);
    int opcion;
    
    do{    
    
        System.out.println("Menu");
        System.out.println("1. Listar nombres de productos");
        System.out.println("2. Listar nombres y precios");
        System.out.println("3. Productos con precio entre 120 y 202");
        System.out.println("4. listar todos los portatiles de la tabla producto");
        System.out.println("5. Listar el nombre y precio del producto mas barato");
        System.out.println("6. Ingresar un producto a la base de datos");
        System.out.println("7. Ingresar un fabricante a la base de datos");
        System.out.println("8. Editar un producto con datos a eleccion");
        System.out.println("9. Salir");
        
        System.out.println("Elija una opcion del menu ");
        opcion = sc.nextInt();
        
        switch(opcion){
            case 1: System.out.println("Aqui van los nombres ------------------------------------");
                try {
                    ProductoService.imprimirNproductos();
                    break;
                } catch (Exception e) {
                    throw new Exception ("Surgio un error al imprimir los nombres" + e.getMessage());
                }
            case 2: System.out.println("Aqui van los nombres y sus precios ------------------------------------");
                try {
                    ProductoService.imprimirProductos();
                    break;
                } catch (Exception e) {
                    throw new Exception ("Surgio un error al imprimir los nombres y sus precios" + e.getMessage());
                }
            case 3: System.out.println("Productos con precio entre 120 y 202 ");
                try {
                    ProductoService.Prodprom();
                    break;
                } catch (Exception e) {
                    throw new Exception("Surgio un error al establecer los precios entre parametros");
                } 
            case 4: System.out.println("Listar todos los productos portatiles de la tabla");
                try {
                    ProductoService.Prodsport();
                    break;
                } catch (Exception e) {
                    throw new Exception ("No se pudo traer los productos con la palabra portatil");
                }
            case 5: System.out.println("Aqui va el producto mas barato ------------------------------");
                    try{
                        System.out.println(ProductoService.ProdBar());
                        break;
                    }catch (Exception e){
                        throw new Exception("No se pudo determinar el producto mas barato");
                    }
            case 6: System.out.println("Ingresar un producto a la base de datos");
                    try {
                        System.out.println("Ingrese nombre, precio y codigo de fabricante en ese orden");
                        String nombre;
                        double precio;
                        int codFabricante;
                        
                        nombre= sc.next();
                        precio = sc.nextDouble();
                        codFabricante = sc.nextInt();
                    ProductoService.crearProducto(nombre, precio, codFabricante);
                } catch (Exception e) {
                    e.printStackTrace();
                    throw new Exception ("No se pudo crear el producto");
                }
            
        }
       

    }while (opcion != 9);
    sc.close();
    
    }
    
    
}

    

