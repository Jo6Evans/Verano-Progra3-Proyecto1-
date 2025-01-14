package SGIF.logic;

import java.util.List;

public class Articulo {
    String id;
    String marca;
    String nombre;
    String Descripcion;
    List<Presentacion> presentacion;

    public Articulo(String id, String marca, String nombre, String Descripcion, List<Presentacion> presentacion) {
        this.id = id;
        this.marca = marca;
        this.nombre = nombre;
        this.Descripcion = Descripcion;
        this.presentacion = presentacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public List<Presentacion> getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(List<Presentacion> presentacion) {
        this.presentacion = presentacion;
    }
    @Override
    public String toString() {
        return this.nombre + this.id;
    }

}
