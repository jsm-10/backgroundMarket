
package tienda.persistencia;

import tienda.entidades.Fabricante;


public final class fabricanteDAO extends DAO {
    
    public void GuardarFabricante (Fabricante fabricante)throws Exception {
        try {
            if( fabricante == null){
                throw new Exception ("debe indicar el fabricante");
            }
            String sql = "INSERT INTO fabricante (nombre)" + "VALUES ( '" + fabricante.getNombre()+ "');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
        }
    }
    public void modificarFabricante(Fabricante fabricante) throws Exception{
        try {
            if(fabricante == null){
                throw new Exception ("debe indicar el fabricante a modificar");
            }
            String sql = "UPDATE fabricante SET nombre = '" + fabricante.getNombre() + "' WHERE codigo = '" + fabricante.getidFab() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }finally{
            desconectarBase();
     
        }
    }
}
