
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Producto;


public final class productoDAO extends DAO{
    
    public void guardarProducto(Producto producto) throws Exception{
        try {
            if (producto == null) {
                throw new Exception ("debe indicar un producto valido");
            }
            String sql = "INSERT INTO producto (codigo, nombre, precio, codigo_fabricante) " +
             "VALUES ('" + producto.getCodigo() + "', '" + producto.getNombre() + "', " + producto.getPrecio() + ", '" + producto.getCodigoFabricante() + "');";
            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }
    public void modificarProducto (Producto producto) throws Exception{
        try {
            if(producto == null){
                throw new Exception ("El producto no se encuentra"); 
            }
            String sql = "UPDATE producto SET precio = '" + producto.getPrecio() + "' WHERE codigo = '" + producto.getCodigo() + "'";
            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
        
    }
    public void eliminarProducto (String nombreProducto) throws Exception{
        try {
         
                String sql= "DELETE FROM producto WHERE nombre='" + nombreProducto + "'";
                insertarModificarEliminar(sql);
            } catch (Exception e) {
                throw e;
        }
    }
    public Producto buscarProducto (String nombreProducto) throws Exception{
        try {
            String sql = "SELECT * FROM producto" + "WHERE nombre ='" + nombreProducto + "'";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {                
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
    public Collection<Producto> listarProductos() throws Exception{
        try {
            String sql = "SELECT nombre, precio FROM  producto";
            consultarBase(sql);
            Producto producto = null;
            Collection <Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setNombre(resultado.getString(1));
                producto.setPrecio(resultado.getDouble(2));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de Sistema");
        }
        
    }

}
