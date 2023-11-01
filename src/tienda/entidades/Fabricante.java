
package tienda.entidades;

public class Fabricante {
    
    private int idFab;
    private String nombre;

    public Fabricante(int codigoFab, String nombre) {
        this.idFab = codigoFab;
        this.nombre = nombre;
    }

    public Fabricante() {
    }

    public int getidFab() {
        return idFab;
    }

    public void setidFab(int idFab) {
        this.idFab = idFab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
