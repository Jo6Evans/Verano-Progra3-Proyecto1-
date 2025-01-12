package SGIF.Controller;

/*import SGIF.logic.Categoria;
import SGIF.Model.Model;
import SGIF.View.InventarioView;
import SGIF.data.Inventario;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;*/

public class Controller {

    ///Controller, esta un JTabble porque supuestamente asi se puede iniciar pero no esta sirviendo (ProyectoSISE)
    ///EL start() es para iniciar el VIEW en el main.
    ///Los metodos TablaCategoria son para crear y actualizar la tabla pero ni se muestra la tabla jaja

    /*

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

}
