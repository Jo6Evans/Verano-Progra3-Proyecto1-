package SGIF.data;

import SGIF.logic.Categoria;
import SGIF.logic.Presentacion;
import SGIF.logic.SubCategoria;
import SGIF.logic.Articulo;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List categorias;
//    private List<Presentacion> presentaciones;
//    private List<SubCategoria> subCategorias;
//    private List<Articulo> articulos;

    public Inventario() {
        categorias = new ArrayList<>();
//        subCategorias = new ArrayList<>();
//        articulos = new ArrayList<>();
//        presentaciones = new ArrayList<>();
    }

    public void LoadXML() {
        ReadXMLFile xmlPersistent = new ReadXMLFile();
        xmlPersistent.cargarCategorias();
        categorias = xmlPersistent.cargarCategorias();
    }

    private boolean categoriaExiste(String codigo) {
        return getCategorias().stream().anyMatch(categoria -> categoria.getID().equals(codigo));
    }

    private Categoria readCategoriaConCodigo(String codigo) {
        for (Categoria categoria : getCategorias()) {
            if (categoria.getID().equals(codigo)) {
                return categoria;
            }
        }
        return null;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

//    public void setPresentaciones(List<Presentacion> presentaciones) {
//        this.presentaciones = presentaciones;
//    }

//    public void setSubCategorias(List<SubCategoria> subCategorias) {
//        this.subCategorias = subCategorias;
//    }

//    public void setArticulos(List<Articulo> articulos) {
//        this.articulos = articulos;
//    }

    //GET
    public List<Categoria> getCategorias() {
        return categorias;
    }

//    public List<Presentacion> getPresentaciones() {
//        return presentaciones;
//    }
//
//    public List<SubCategoria> getSubCategorias() {
//        return subCategorias;
//    }
//
//    public List<Articulo> getArticulos() {
//        return articulos;
//    }

    //CRUD CATEGORIA
    public void createCategoria(Categoria categoria) throws Exception {
        if (getCategorias().stream().anyMatch(cat -> cat.getID().equals(categoria.getID()))) {
            throw new Exception("El categoria ya existe");
        } else {
            getCategorias().add(categoria); //agrega la categoria a la lista
            setCategorias(getCategorias());// y la actualiza
        }
    }

    public Categoria readCategoria(Categoria categoria) throws Exception {
        Categoria c = getCategorias().stream().filter(cat -> cat.getNombre().equals(categoria.getNombre())).findFirst().orElse(null);
        if (c != null) return c;
        else throw new Exception("Categoria no existe");
    }

    public void updateCategoria(Categoria categoria) throws Exception {
        Categoria result = readCategoriaConCodigo(categoria.getID());
        if (result != null) {
            result.setNombre(categoria.getNombre());
            result.setDescripcion(categoria.getDescripcion());
            result.setSubcategorias(categoria.getSubCategoria());
        } else {
            throw new Exception("Categoria no existe");
        }
    }

    public void deleteCategoria(Categoria categoria) throws Exception {
        if (!categoria.getSubCategoria().isEmpty()){
            throw new Exception("El categoria tiene subcategorias");
        }else{
            getCategorias().remove(categoria);
        }
    }


//    //CRUD SUBCATEGORIA
//
//    public void createSubCategoria(SubCategoria subCategoria)throws Exception {
//        SubCategoria s = getSubCategorias().stream().filter(cat -> cat.getNombre().equals(subCategoria.getNombre())).findFirst().orElse(null);
//        if (s == null) getSubCategorias().add(subCategoria);
//        else throw new Exception("SubCategoria ya existe");
//    }
//
//    public SubCategoria readSubCategoria(SubCategoria subCategoria)throws Exception {
//        SubCategoria s = getSubCategorias().stream().filter(cat -> cat.getNombre().equals(subCategoria.getNombre())).findFirst().orElse(null);
//        if (s != null) return s;
//        else throw new Exception("SubCategoria no existe");
//    }
//
//    public void updateSubCategoria(SubCategoria subCategoria) throws Exception{
//        SubCategoria s;
//        try{
//            s = this.readSubCategoria(subCategoria);
//            getSubCategorias().remove(s);
//            getSubCategorias().add(subCategoria);
//        }catch (Exception ex) {
//            throw new Exception("Subcategoria no existe");
//        }
//    }
//
//    public void deleteSubCategoria(SubCategoria subCategoria)throws Exception {
//        getSubCategorias().remove(subCategoria);
//    }
//
//    //CRUD ARTICULO
//
//    public void createArticulo(Articulo articulo)throws Exception {
//        Articulo a = getArticulos().stream().filter(cat -> cat.getNombre().equals(articulo.getNombre())).findFirst().orElse(null);
//        if (a == null) getArticulos().add(articulo);
//        else throw new Exception("Articulo ya existe");
//    }
//
//    public Articulo readArticulo(Articulo articulo)throws Exception {
//        Articulo a = getArticulos().stream().filter(cat -> cat.getNombre().equals(articulo.getNombre())).findFirst().orElse(null);
//        if (a != null) return a;
//        else throw new Exception("Articulo no existe");
//    }
//
//    public void updateArticulo(Articulo articulo) throws Exception{
//        Articulo a;
//        try{
//            a = this.readArticulo(articulo);
//            getArticulos().remove(a);
//            getArticulos().add(articulo);
//        }catch (Exception ex) {
//            throw new Exception("Articulo no existe");
//        }
//    }
//
//    public void deleteArticulo(Articulo articulo)throws Exception {
//        getArticulos().remove(articulo);
//    }

}
