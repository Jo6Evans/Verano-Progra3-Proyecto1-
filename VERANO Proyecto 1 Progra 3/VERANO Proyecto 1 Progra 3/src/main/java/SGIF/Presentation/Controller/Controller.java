package SGIF.Presentation.Controller;

/*import SGIF.logic.Categoria;
import SGIF.Presentation.Model.Model;
import SGIF.Presentation.Controller.Controller.View.InventarioView;
import SGIF.data.Inventario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;*/

import SGIF.Presentation.Model.CategoriaTableModel;
import SGIF.Presentation.Model.Model;
import SGIF.Presentation.Model.SubCategoriaTableModel;
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
        // Este metodo configura el modelo con las categorias actuales
        return new CategoriaTableModel(model.getCategorias());

    }

    // Método para obtener el modelo de subcategorías
    public AbstractTableModel getModelSubCategorias(Categoria categoriaSeleccionada) {
        // Cargamos las subcategorias según la categoria seleccionada
        return new SubCategoriaTableModel(model.cargarSubCategorias(categoriaSeleccionada));
    }

    // Método para obtener el modelo de artículos
    public AbstractTableModel getModelArticulos(SubCategoria subCategoriaSeleccionada) {
        // Cargamos los articulos segun la subcategoria seleccionada
        model.cargarArticulos(subCategoriaSeleccionada);
        return model;
    }

    // Método para obtener el modelo de presentaciones
    public AbstractTableModel getModelPresentaciones(Articulo articuloSeleccionado) {
        // Cargamos las presentaciones correspondientes al articulo seleccionado
        model.cargarPresentaciones(articuloSeleccionado);
        return model;
    }


    public Categoria getCategoriaAt(int rowIndex) {
        return model.getCategorias().get(rowIndex); // Cambia 'data' por el nombre de tu lista de categorías
    }

    public SubCategoria getSubCategoriaAt(int rowIndex, Categoria categoriaSeleccionada) {
        return categoriaSeleccionada.getSubCategoria().get(rowIndex);
    }

    public Articulo getArticuloAt(int rowIndex, SubCategoria subCategoriaSeleccionada) {
        return subCategoriaSeleccionada.getListadoArticulos().get(rowIndex);
    }

    public Presentacion getPresentacionAt(int rowIndex, Articulo articuloSeleccionado) {
        return articuloSeleccionado.getPresentacion().get(rowIndex);
    }


}










    ///Controller, esta un JTabble porque supuestamente asi se puede iniciar pero no esta sirviendo (ProyectoSISE)
    ///EL start() es para iniciar el VIEW en el main.
    ///Los metodos TablaCategoria son para crear y actualizar la tabla pero ni se muestra la tabla jaja

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
