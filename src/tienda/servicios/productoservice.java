/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import tienda.entidades.Producto;
import tienda.persistencia.productoDAO;

/**
 *
 * @author juans
 */
public class productoservice {
    
    private productoDAO dao;
    
    public productoservice(){
        this.dao = new productoDAO();
        
    }
    public void crearProducto (String nombre, double precio, int codigoFabricante) throws Exception {
       try {
       if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debes indicar el producto a inscribir");
        }
        if (precio == 0.0){
            throw new Exception ("establece un precio y/o no puede ser 0");
        }
        if(dao.buscarProducto(nombre) != null){
            throw new Exception ("Ya existe un producto con ese nombre");
        }
        Producto producto = new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCodigoFabricante(codigoFabricante);
        dao.guardarProducto(producto);
    }catch(Exception e){
    throw e;
}
}   
}
