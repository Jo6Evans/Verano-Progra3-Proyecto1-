package SGIF.data;

import SGIF.logic.Categoria;
import SGIF.logic.Presentacion;
import SGIF.logic.SubCategoria;
import SGIF.logic.Articulo;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Categoria> categorias;
    private List<Presentacion> presentaciones;
    private List<SubCategoria> subCategorias;
    private List<Articulo> articulos;

    public Inventario() {
        categorias = new ArrayList<>();
        presentaciones = new ArrayList<>();
        subCategorias = new ArrayList<>();
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Presentacion> getPresentaciones() {
        return presentaciones;
    }

    public List<SubCategoria> getSubCategorias() {
        return subCategorias;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    //CRUD CATEGORIA
    public void createCategoria(Categoria categoria) throws Exception {
        Categoria c = getCategorias().stream().filter(cat -> cat.getNombre().equals(categoria.getNombre())).findFirst().orElse(null);
        if (c == null) getCategorias().add(categoria);
        else throw new Exception("Categoria ya existe");
    }

    public Categoria readCategoria(Categoria categoria) throws Exception {
        Categoria c = getCategorias().stream().filter(cat -> cat.getNombre().equals(categoria.getNombre())).findFirst().orElse(null);
        if (c != null) return c;
        else throw new Exception("Categoria no existe");
    }

    public void updateCategoria(Categoria categoria) throws Exception {
        Categoria result;
        try {
            result = this.readCategoria(categoria);
            getCategorias().remove(result);
            getCategorias().add(categoria);
        } catch (Exception ex) {
            throw new Exception("Categoria no existe");
        }
    }

    public void deleteCategoria(Categoria categoria) throws Exception {
        getCategorias().remove(categoria);
    }


    //CRUD SUBCATEGORIA

    public void createSubCategoria(SubCategoria subCategoria)throws Exception {
        SubCategoria s = getSubCategorias().stream().filter(cat -> cat.getNombre().equals(subCategoria.getNombre())).findFirst().orElse(null);
        if (s == null) getSubCategorias().add(subCategoria);
        else throw new Exception("SubCategoria ya existe");
    }

    public SubCategoria readSubCategoria(SubCategoria subCategoria)throws Exception {
        SubCategoria s = getSubCategorias().stream().filter(cat -> cat.getNombre().equals(subCategoria.getNombre())).findFirst().orElse(null);
        if (s != null) return s;
        else throw new Exception("SubCategoria no existe");
    }

    public void updateSubCategoria(SubCategoria subCategoria) throws Exception{
        SubCategoria s;
        try{
            s = this.readSubCategoria(subCategoria);
            getSubCategorias().remove(s);
            getSubCategorias().add(subCategoria);
        }catch (Exception ex) {
            throw new Exception("Subcategoria no existe");
        }
    }

    public void deleteSubCategoria(SubCategoria subCategoria)throws Exception {
        getSubCategorias().remove(subCategoria);
    }

    //CRUD ARTICULO

    public void createArticulo(Articulo articulo)throws Exception {
        Articulo a = getArticulos().stream().filter(cat -> cat.getNombre().equals(articulo.getNombre())).findFirst().orElse(null);
        if (a == null) getArticulos().add(articulo);
        else throw new Exception("Articulo ya existe");
    }

    public Articulo readArticulo(Articulo articulo)throws Exception {
        Articulo a = getArticulos().stream().filter(cat -> cat.getNombre().equals(articulo.getNombre())).findFirst().orElse(null);
        if (a != null) return a;
        else throw new Exception("Articulo no existe");
    }

    public void updateArticulo(Articulo articulo) throws Exception{
        Articulo a;
        try{
            a = this.readArticulo(articulo);
            getArticulos().remove(a);
            getArticulos().add(articulo);
        }catch (Exception ex) {
            throw new Exception("Articulo no existe");
        }
    }

    public void deleteArticulo(Articulo articulo)throws Exception {
        getArticulos().remove(articulo);
    }

}
