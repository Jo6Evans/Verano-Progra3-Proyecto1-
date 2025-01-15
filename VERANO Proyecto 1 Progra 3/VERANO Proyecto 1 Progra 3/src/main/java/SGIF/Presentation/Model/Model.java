package SGIF.Presentation.Model;

import SGIF.data.Inventario;
import SGIF.logic.Articulo;
import SGIF.logic.Categoria;
import SGIF.logic.Presentacion;
import SGIF.logic.SubCategoria;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/// AQUI VA UN MODEL COMO EL DEL LABORATORIO 05

public class Model {
    private Inventario data = new Inventario();
    //llenar las columnas de las tablas
    private List<SubCategoria> subcategorias;
    private List<Articulo> articulos;
    //private List<Categoria> categorias;
    private List<Presentacion> presentaciones;
    public void cargarArchivo() {
        data.LoadXML();
    }

    public Model() {
        Inventario data = new Inventario();
    }

    public List<Categoria> getCategorias() {
        return data.getCategorias();
    }

    public List<SubCategoria> cargarSubCategorias(Categoria categoriaSeleccionada) {
        this.subcategorias = categoriaSeleccionada.getSubCategoria();
        return this.subcategorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        data.setCategorias(categorias);
    }

    public void setSubCategorias(List<SubCategoria> subcategoria) {
        this.subcategorias = subcategoria;

    }

    public List<SubCategoria> getSubcategorias() {
        return subcategorias;
    }

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;

    }
    public List<Presentacion> getPresentaciones() {
        return presentaciones;
    }

    public void setPresentaciones(List<Presentacion> presentaciones) {
        this.presentaciones = presentaciones;

    }


    public List<Articulo> cargarArticulos(SubCategoria subcategoriaSeleccionada) {
        this.articulos=subcategoriaSeleccionada.getListadoArticulos();
        return this.articulos;
    }
    public List<Presentacion> cargarPresentaciones(Articulo articuloSeleccionado) {
        this.presentaciones = articuloSeleccionado.getPresentacion();

        return this.presentaciones;
    }

    public Categoria getCategoriaAt(int rowIndex){
        return data.getCategorias().get(rowIndex);
    }
    public SubCategoria getSubCategoriaAt(int rowIndex, Categoria categoriaSeleccionada){
        return categoriaSeleccionada.getSubCategoria().get(rowIndex);
    }
    public Articulo getArticuloAt(int rowIndex, SubCategoria subCategoriaSeleccionada){
        return subCategoriaSeleccionada.getListadoArticulos().get(rowIndex);
    }
    public Presentacion getPresentacionAt(int rowIndex, Articulo articuloSeleccionado){
        return articuloSeleccionado.getPresentacion().get(rowIndex);
    }
    public List<SubCategoria> searchSubCategorias(String id,String nom) {
        List<SubCategoria> subCategoriasEncontradas = new ArrayList<>();
        for(Categoria cat: getCategorias()){
            for(SubCategoria sub : cat.getSubCategoria()){
                if(sub.getNombre().equalsIgnoreCase(id)||sub.getNombre().equalsIgnoreCase(nom)){
                    subCategoriasEncontradas.add(sub);
                }
            }
        }
        return subCategoriasEncontradas;
    }
    public List<Categoria> searchCategorias(String id, String nom) {
        List<Categoria> categoriasEncontradas = new ArrayList<>();
        for(Categoria cat: getCategorias()){
            if(cat.getNombre().equalsIgnoreCase(id)||cat.getNombre().equalsIgnoreCase(nom)){
                categoriasEncontradas.add(cat);
            }
        }
        return categoriasEncontradas;
    }
    public boolean eliminarCategoria(Categoria categoria) throws Exception {
       try{
           data.deleteCategoria(categoria);
           return true;
       }catch(Exception e){
           System.out.println("La categoria todavia tiene subcategorias");
           return false;
       }
    }
    public void eliminarSubCategoria(Categoria categoria, SubCategoria subCategoria) {
        try {
            data.deleteSubCategoria(categoria, subCategoria);
        } catch (Exception e) {
            System.out.println("La subcategoría tiene artículos asociados");
        }
    }
    public void eliminarArticulo(SubCategoria subCategoria, Articulo articulo) {
        try {
            data.deleteArticulo(subCategoria, articulo);
        } catch (Exception e) {
            System.out.println("El artículo tiene presentaciones asociadas");
        }
    }

    public void eliminarPresentacion(Articulo articulo, Presentacion presentacion) {
        data.deletePresentacion(articulo, presentacion);
    }

    //SEARCH
    public List<Categoria> searchC(String id, String nombre){
        return data.getCategorias().stream()
                .filter(i -> (id == null || i.getID().contains(id)) &&
                        (nombre == null || i.getNombre().contains(nombre)))
                .sorted(Comparator.comparing(Categoria::getNombre))
                .collect(Collectors.toList());
    }


    public List<SubCategoria> searchSub(String id, String nombre) {
        List<SubCategoria> subCategoriasEncontradas = new ArrayList<>();
        for (Categoria categoria : data.getCategorias()) {
            for (SubCategoria subCategoria : categoria.getSubCategoria()) {
                if (subCategoria.getNombre().equalsIgnoreCase(id) || subCategoria.getNombre().equalsIgnoreCase(nombre)) {
                    subCategoriasEncontradas.add(subCategoria);
                }
            }
        }
        return subCategoriasEncontradas;
    }

    public List<Articulo> searchArt(String id, String nombre) {
        List<Articulo> articulosEncontradas = new ArrayList<>();
        for (SubCategoria subCategoria : subcategorias) {
            for (Articulo articulo : subCategoria.getListadoArticulos()) {
                if (articulo.getNombre().equalsIgnoreCase(id) || articulo.getNombre().equalsIgnoreCase(nombre)) {
                    articulosEncontradas.add(articulo);
                }
            }
        }
        return articulosEncontradas;
    }

    /*public List<Presentacion> searchPrt(String id, String nombre) {
        List<Presentacion> presentEncontradas = new ArrayList<>();
        for (Articulo articulos : articulos) {
            for (Presentacion presentacion : articulos.getPresentacion()) {
                if (presentacion.getNombre().equalsIgnoreCase(id) || presentacion.getNombre().equalsIgnoreCase(nombre)) {
                    presentEncontradas.add(presentacion);
                }
            }
        }
        return presentEncontradas;
    }*/

    //GUARDAR
    public Categoria guardarCategoria(Categoria categoria) throws Exception {
        for (Categoria c : data.getCategorias()) {
            if (c.getID().equals(categoria.getID())) {
                return null; //esto es si ya existe una categoria con el mismo ID
            }
        }
        categoria.setSubcategorias(this.subcategorias);
        //data.getCategorias().add(categoria);
        data.createCategoria(categoria);
        return categoria;
    }

    public List<SubCategoria> guardarSubCategoria(SubCategoria subcategoria) {
        for (SubCategoria sc : subcategorias) {
            if (sc.getID().equals(subcategoria.getID()) || sc.getNombre().equals(subcategoria.getNombre())) {
                return null;
            }
        }
        subcategoria.setListadoArticulos(articulos);
        subcategorias.add(subcategoria);
        setSubCategorias(subcategorias);
        return subcategorias;
    }

    public List<Articulo> guardarArticulo(Articulo articulo) {
        for (Articulo a : articulos) {
            if (a.getId().equals(articulo.getId())) {
                return null;
            }
        }
        articulo.setPresentacion(this.presentaciones);
        articulos.add(articulo);
        setArticulos(articulos);
        return articulos;
    }

    public List<Presentacion> guardarPresentacion(Presentacion presentacion) {
        for (Presentacion p : this.presentaciones) {
            if (p.getId().equals(presentacion.getId())) {
                return null;
            }
        }
        presentaciones.add(presentacion);
        setPresentaciones(presentaciones);
        return presentaciones;
    }

    //a ver si esto sirve
    private Categoria categoriaSeleccionada;
    private SubCategoria subCategoriaSeleccionada;
    private Articulo articuloSeleccionado;
    private Presentacion presentacionSeleccionada;

    public void setCategoriaSeleccionada(Categoria categoria) {
        this.categoriaSeleccionada = categoria;
    }
    public Categoria getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }
    public void setSubCategoriaSeleccionada(SubCategoria subCategoria) {
        this.subCategoriaSeleccionada = subCategoria;
    }
    public SubCategoria getSubCategoriaSeleccionada() {
        return subCategoriaSeleccionada;
    }
    public void setArticuloSeleccionado(Articulo articulo) {
        this.articuloSeleccionado = articulo;
    }
    public Articulo getArticuloSeleccionado() {
        return articuloSeleccionado;
    }
    public void setPresentacionSeleccionada(Presentacion presentacion) {
        this.presentacionSeleccionada = presentacion;
    }
    public Presentacion getPresentacionSeleccionada() {
        return presentacionSeleccionada;
    }




}

/// MODEL
/// Sus atributos son el inventario porque esa es la forma de acceder a los datos del XML
/// La idea es que los tables agarren la informacion y se pongan sus valores pero no funca jaja

/*
    guardar x4
    modificar x4
    eliminar x4
    mostrar x4
    buscar x4



    private Inventario inventario;
    private JTable tablaCategoria = new JTable();


    public Model() {
        inventario = new Inventario();
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public JTable getTablaCategoria() {
        return tablaCategoria;
    }

    public void setTablaCategoria(JTable tablaCategoria) {
        this.tablaCategoria = tablaCategoria;
    }


    public List<Categoria> getCategorias() {
        return inventario.getCategorias();
    }
    public void setCategorias(List<Categoria> categorias) {
        inventario.setCategorias(categorias);
    }
    public void actualizarTablaCategorias() {
        // Obtener los datos de las categorías
        List<Categoria> categorias = getCategorias();

        // Crear un nuevo DefaultTableModel y llenarlo con los datos
        DefaultTableModel model = new DefaultTableModel(new String[]{"ID", "Nombre", "Descripción"}, categorias.size());
        for (int i = 0; i < categorias.size(); i++) {
            Categoria categoria = categorias.get(i);
            model.setValueAt(categoria.getID(), i, 0);
            model.setValueAt(categoria.getNombre(), i, 1);
            model.setValueAt(categoria.getDescripcion(), i, 2);
        }

        // Asignar el nuevo modelo a la tabla
        tablaCategoria.setModel(model);
    }

    */
