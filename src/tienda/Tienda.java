
package tienda;

import tienda.servicios.productoservice;


public class Tienda {

  
    public static void main(String[] args) throws Exception {
        
    productoservice ProductoService = new productoservice();
    
    try {
        ProductoService.crearProducto("rx 6700 XT", 800, 2);
    } catch (Exception e) {
        System.out.println("Error al crear el producto: " + e.getMessage());
    }
}

    
}
