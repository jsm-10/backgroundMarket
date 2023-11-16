
package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.fabricanteDAO;


public class fabricanteservice {
    private fabricanteDAO dao;

    public fabricanteservice() {
        this.dao = new fabricanteDAO();
    }
    
    public void crearFabricante (String nombre) throws Exception{
        try {
            if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debes indicar el producto a inscribir");
        }
        if(dao.buscarFabricante(nombre) != null){
            throw new Exception ("Ya existe un producto con ese nombre");
        }
        Fabricante fabricante = new Fabricante();
        fabricante.setNombre(nombre);
        dao.GuardarFabricante(fabricante);
 
        } catch (Exception e) {
            throw e;
        }
    }
}
