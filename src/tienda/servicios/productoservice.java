/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tienda.servicios;

import java.util.Collection;
import java.util.Iterator;
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
    public Collection<Producto> listarProductos () throws Exception{
        try {
            Collection<Producto> productos = dao.listarProductos();
            
            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirNproductos () throws Exception{
        try {
            Collection<Producto> productos = listarProductos();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos a listar");
            }else{
                for (Producto x : productos) {
                    System.out.println(x.getNombre());
                    
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    public void imprimirProductos () throws Exception{
        try {
            Collection<Producto> productos = listarProductos();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos a listar");
            }else{
                for (Producto x : productos) {
                    System.out.println(x.getNombre());
                    System.out.println(x.getPrecio());
                    
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
      public void Prodprom() throws Exception {
    try {
        Collection<Producto> productos = listarProductos();
        if (productos.isEmpty()) {
            throw new Exception("No existen productos con esas caracteristicas");
        } else {
            for (Producto x : productos) {
                if (x.getPrecio() > 120 && x.getPrecio() < 202) {
                    System.out.println(x);
                }
            }
        }
    } catch (Exception e) {
        throw e;
    }
}
      public void Prodsport() throws Exception{
          try {
              Collection<Producto> productos = listarProductos();
              if(productos.isEmpty()){
                  throw new Exception("No existen productos");
              }else{
                  for (Producto x : productos) {
                      if(x.getNombre().toLowerCase().contains("por")){
                          System.out.println(x);
                      }
                  }
              }
          } catch (Exception e) {
              throw e;
          }
      }
       public Producto ProdBar() throws Exception {
    Collection<Producto> productos = listarProductos();

    if (productos.isEmpty()) {
        throw new Exception("No existen productos para esta solicitud");
    }

    Iterator<Producto> iterator = productos.iterator();
    Producto producto = iterator.next();

    while (iterator.hasNext()) {
        Producto productoActual = iterator.next();
        if (productoActual.getPrecio() < producto.getPrecio()) {
            producto = productoActual;
        }
    }

    return producto;
}

  
    

}
