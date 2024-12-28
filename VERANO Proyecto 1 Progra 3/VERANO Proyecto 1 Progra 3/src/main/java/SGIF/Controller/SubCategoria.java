package SGIF.Controller;

import java.util.List;

public class SubCategoria {
    private String ID;
    private String nombre;
    private String descripcion;
    private Listado listadoArticulos;

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public Listado getListadoArticulos() {
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

    public void setListadoArticulos(Listado ListadoArticulos) {
        this.listadoArticulos = ListadoArticulos;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
