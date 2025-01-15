package SGIF.Presentation.Controller;

/*import SGIF.logic.Categoria;
import SGIF.Presentation.Model.Model;
import SGIF.Presentation.Controller.Controller.View.InventarioView;
import SGIF.data.Inventario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;*/

import java.util.ArrayList;
import java.util.List;

import SGIF.Presentation.Model.*;
import SGIF.Presentation.View.InventarioView;
import SGIF.Presentation.View.InventarioView;
import SGIF.logic.Articulo;
import SGIF.logic.Categoria;
import SGIF.logic.Presentacion;
import SGIF.logic.SubCategoria;

import javax.swing.table.AbstractTableModel;


public class Controller {

    private Model model;
    private InventarioView view;

    public Controller() {
        model = new Model();
        model.cargarArchivo();
    }

    public Model getModel() {
        return model;
    }

    public void startApplication() {
        InventarioView view = new InventarioView();
        view.setController(this);
        view.loadView();
    }

    public AbstractTableModel getModelCategorias() {
        return new CategoriaTableModel(model.getCategorias());
    }

    public AbstractTableModel getModelSubCategorias(Categoria categoriaSeleccionada) {
        return new SubCategoriaTableModel(model.cargarSubCategorias(categoriaSeleccionada));
    }

    public AbstractTableModel getModelArticulos(SubCategoria subCategoriaSeleccionada) {
        return new ArticuloTableModel(model.cargarArticulos(subCategoriaSeleccionada));
    }

    public AbstractTableModel getModelPresentaciones(Articulo articuloSeleccionado) {
        return new PresentacionTableModel(model.cargarPresentaciones(articuloSeleccionado));
    }

    //SEARCH
    public void searchCategoria(String id, String nombre) {
        model.setCategorias(model.getCategorias());
        model.searchC(id, nombre);
    }

    public void searchSubcategoria(String id, String nombre) {
        model.setSubCategorias(model.getSubcategorias());
        model.searchSub(id, nombre);
    }

    public void searchArticulo(String id, String nombre) {
        model.setArticulos(model.getArticulos());
        model.searchArt(id, nombre);
    }

    //GUARDAR
    public void guardarCat(Categoria categoria) throws Exception {
        model.getCategorias();
        model.guardarCategoria(categoria);
    }


    public Articulo obtenerArticuloSeleccionado() {
        return model.getArticuloSeleccionado();
    }

    public void seleccionarPresentacion(Presentacion presentacion) {
        model.setPresentacionSeleccionada(presentacion);
    }

    public Presentacion obtenerPresentacionSeleccionada() {
        return model.getPresentacionSeleccionada();
    }


    public void eliminarCategoria(Categoria categoriaSeleccionada) throws Exception {
        try {
            model.eliminarCategoria(categoriaSeleccionada);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminarSubCategoria(SubCategoria subCategoriaSeleccionada) throws Exception {
        try {
            model.eliminarSubCategoria(obtenerCategoriaSeleccionada(), subCategoriaSeleccionada);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminarArticulo(Articulo articuloSeleccionado) throws Exception {
        try {
            model.eliminarArticulo(obtenerSubCategoriaSeleccionada(), articuloSeleccionado);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void eliminarPresentacion(Presentacion presentacionSeleccionada) throws Exception {
        model.eliminarPresentacion(obtenerArticuloSeleccionado(), presentacionSeleccionada);
    }

    public void seleccionarCategoria(Categoria categoria) {
        model.setCategoriaSeleccionada(categoria);
    }

    public Categoria obtenerCategoriaSeleccionada() {
        return model.getCategoriaSeleccionada();
    }

    public void seleccionarSubCategoria(SubCategoria subCategoria) {
        model.setSubCategoriaSeleccionada(subCategoria);
    }

    public SubCategoria obtenerSubCategoriaSeleccionada() {
        return model.getSubCategoriaSeleccionada();
    }

    public void seleccionarArticulo(Articulo articulo) {
        model.setArticuloSeleccionado(articulo);
    }
}

/// Controller, esta un JTabble porque supuestamente asi se puede iniciar pero no esta sirviendo (ProyectoSISE)
/// EL start() es para iniciar el VIEW en el main.
/// Los metodos TablaCategoria son para crear y actualizar la tabla pero ni se muestra la tabla jaja

    /*
    guardar cate(categoria c){
    if(model.guusadhfuihasdiu)
    else
    ya existe cat con ese codigop

    private InventarioView inventarioView;
    private Model model;
    private static Inventario inventario;

    private static JTable tablaCategoria;

    public Controller() {
        inventario = new Inventario();
        tablaCategoria = new JTable();
        model = new Model();
        tablaCategoria.setModel(model);
        //model.actualizarTablaCategorias();
    }

    public void start(InventarioView inventarioView) throws Exception {
        this.inventarioView = inventarioView;
        model.setTablaCategoria(tablaCategoria);
        TablaCategoria();
    }

    public void TablaCategoria() throws Exception{

        tablaCategoria.setModel(new DefaultTableModel(new String[]{"ID", "Nombre","Descripcion"}, inventario.getCategorias().size()){}
        );

        for(int i = 0; i < inventario.getCategorias().size(); i++){
            Categoria categoria = inventario.getCategorias().get(i);
            tablaCategoria.setValueAt(categoria.getID(), i, 0);
            tablaCategoria.setValueAt(categoria.getNombre(), i, 1);
            tablaCategoria.setValueAt(categoria.getDescripcion(), i, 2);
        }

    }

    public void actualizarTablaCategorias() {
        model.actualizarTablaCategorias();
    }

    */

//}
