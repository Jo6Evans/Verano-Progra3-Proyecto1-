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
    private String[] columnasCategorias = {"Codigo", "Nombre", "Descripcion"};
    private String[] columnasSubCategorias = {"Codigo", "Nombre", "Descripcion"};
    private String[] columnasArticulos = {"Codigo", "Marca", "Nombre", "Descripcion"};
    private String[] columnasPresentaciones = {"Codigo", "Unidad", "Cantidad"};
    private List<Categoria> categorias;
    private List<SubCategoria> subcategorias;
    private List<Articulo> articulos;
    private List<Presentacion> presentaciones;

    public Model() {
        Inventario data = new Inventario();
    }

    public List<Categoria> getCategorias() {
        return data.getCategorias();
    }
    public List<SubCategoria> cargarSubCategorias(Categoria categoriaSeleccionada) {
        this.subcategorias = categoriaSeleccionada.getSubCategoria();
//        if (subcategorias != null && !subcategorias.isEmpty()) {
//           fireTableDataChanged();
//        } else {
//            System.out.println("No se han encontrado subcategorías.");
//        }

        return this.subcategorias;
    }
    public List<Articulo> cargarArticulos(SubCategoria subcategoriaSeleccionada) {
        this.articulos=subcategoriaSeleccionada.getListadoArticulos();
        return this.articulos;
       // fireTableDataChanged();
    }
    public void cargarPresentaciones(Articulo articuloSeleccionado) {
        this.presentaciones = articuloSeleccionado.getPresentacion();
      //  fireTableDataChanged();
    }
//    public void setCategorias(List<Categoria> categorias) {
//        this.categorias = categorias;
//        fireTableDataChanged();
//    }
    Presentacion guardarPresentacion(Presentacion presentacion) {
        for (Presentacion p : this.presentaciones) {
            if (p.getId().equals(presentacion.getId())) {
                return null;
            }
        }
        presentaciones.add(presentacion);
        //fireTableDataChanged();
        return presentacion;
    }
    public Categoria searchCategoria(String id, String nom){
        for(Categoria cat: categorias){
            if(data.getCategorias().get(0).getID().equals(id) || data.getCategorias().get(0).getNombre().equals(nom)){
                categorias.add(cat);
            }
        }
        return null;
//        return data.getCategorias().stream()
//                .filter(i->i.getNombre().contains(e.getNombre()))
//                .sorted(Comparator.comparing(Categoria::getNombre))
//                .collect(Collectors.toList());
    }
    public void cargarArchivo() {
        data.LoadXML();
    }

    private enum TipoModelo {
        CATEGORIA,
        SUBCATEGORIA,
        ARTICULO,
        PRESENTACION,
        NINGUNO
    }

    private TipoModelo getTipoModeloActivo() {
        if (categorias != null) return TipoModelo.CATEGORIA;
        if (subcategorias != null) return TipoModelo.SUBCATEGORIA;
        if (articulos != null) return TipoModelo.ARTICULO;
        if (presentaciones != null) return TipoModelo.PRESENTACION;
        return TipoModelo.NINGUNO;
    }

    private String[] getColumnasActivas() {
        switch (getTipoModeloActivo()) {
            case CATEGORIA: return columnasCategorias;
            case SUBCATEGORIA: return columnasSubCategorias;
            case ARTICULO: return columnasArticulos;
            case PRESENTACION: return columnasPresentaciones;
            default: return new String[0];
        }
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
