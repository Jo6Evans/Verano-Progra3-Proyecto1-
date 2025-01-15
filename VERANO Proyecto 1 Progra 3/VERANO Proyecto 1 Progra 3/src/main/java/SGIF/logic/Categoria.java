package SGIF.logic;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
    String ID;
    String nombre;
    String descripcion;
    List<SubCategoria> subCategoria;

    public Categoria(){}

    //cosntruc nuevo para guardar, HACER EN LOS QUE TENGAN LISTAS
    public Categoria(String i, String n, String d){
        ID = i;
        nombre = n;
        descripcion = d;
        subCategoria = new ArrayList<SubCategoria>();
    }

    public Categoria(String ID, String nombre, String descripcion, List<SubCategoria> subCategoria) {
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.subCategoria = subCategoria;
    }
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SubCategoria> getSubCategoria() {
        return subCategoria;
    }

    public void setSubcategorias(List<SubCategoria> listaSubCategorias) {
        this.subCategoria = listaSubCategorias;
    }
}
