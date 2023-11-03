
package tienda.persistencia;

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
}