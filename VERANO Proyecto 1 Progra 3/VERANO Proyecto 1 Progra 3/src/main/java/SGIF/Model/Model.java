package SGIF.Model;

import SGIF.data.Inventario;
import SGIF.logic.Categoria;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

///AQUI VA UN MODEL COMO EL DEL LABORATORIO 05

public class Model extends DefaultTableModel {
    private Inventario data;
    //llenar las columnas de las tablas
    private String[] columnasCategorias = {"Codigo","Nombre","Descripcion"};
    private String[] columnasSubCategorias = {"Codigo","Nombre","Descripcion"};
    private String[] columnasArticulos = {"Codigo","Marca","Nombre","Descripcion"};
    private String[] columnasPresentaciones = {"Codigo","Unidad","Cantidad"};

    public Model(){
        Inventario data = new Inventario();
    }
    public List<Categoria> getCategorias() {
        return data.getCategorias();
    }
    public void setCategorias(List<Categoria> categorias) {
        data.setCategorias(categorias);
    }
    public void cargarArchivo(){data.LoadXML();}


}

///MODEL
///Sus atributos son el inventario porque esa es la forma de acceder a los datos del XML
///La idea es que los tables agarren la informacion y se pongan sus valores pero no funca jaja

/*
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
