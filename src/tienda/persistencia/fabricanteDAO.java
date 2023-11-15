
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
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
    public void eliminarFabricante (String nombre) throws Exception{
        try {
            String sql = "DELETE FROM fabricante WHERE nombre= '" + nombre + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    public Fabricante buscarFabricante (String nombre) throws Exception{
        try {
            String sql= "SELECT * FROM fabricante Where nombre='" + nombre + "'";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {                
            fabricante = new Fabricante();
            fabricante.setidFab(resultado.getInt(1));
            fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
    public Collection<Fabricante> listarFabricantes() throws Exception{
        try {
            String sql = "Select codigo, nombre FROM producto";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection <Fabricante> fabricantes = new ArrayList();
            
            while (resultado.next()) {                
            fabricante = new Fabricante();
            fabricante.setidFab(resultado.getInt(1));
            fabricante.setNombre(resultado.getString(2));
            fabricantes.add(fabricante);
            }
            desconectarBase();
            return fabricantes;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema en la coleccion intetada");
        }
    }
}
