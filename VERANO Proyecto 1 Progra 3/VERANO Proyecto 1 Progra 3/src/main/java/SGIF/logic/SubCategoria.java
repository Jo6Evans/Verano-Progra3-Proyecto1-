package SGIF.logic;

import java.util.List;

public class SubCategoria {
    private String ID;
    private String nombre;
    private String descripcion;
    private List<Articulo> listadoArticulos;

    public SubCategoria(String ID, String nombre, String descripcion, List<Articulo> listadoArticulos) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listadoArticulos = listadoArticulos;
    }

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Articulo> getListadoArticulos() {
        return listadoArticulos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListadoArticulos(List<Articulo> ListadoArticulos) {
        this.listadoArticulos = ListadoArticulos;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
