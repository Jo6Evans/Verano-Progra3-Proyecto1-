package SGIF.data;

import SGIF.logic.Categoria;
import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List categorias;

    public Inventario() {
        categorias = new ArrayList<>();

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
        ReadXMLFile xmlPersistent = new ReadXMLFile();

    }

    //GET
    public List<Categoria> getCategorias() {
        return categorias;
    }

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


}
