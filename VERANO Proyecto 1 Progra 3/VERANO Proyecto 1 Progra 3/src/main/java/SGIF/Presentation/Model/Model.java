package SGIF.Presentation.Model;

import SGIF.data.Inventario;
import SGIF.logic.Articulo;
import SGIF.logic.Categoria;
import SGIF.logic.Presentacion;
import SGIF.logic.SubCategoria;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

/// AQUI VA UN MODEL COMO EL DEL LABORATORIO 05

public class Model extends AbstractTableModel {
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
        if (subcategorias != null && !subcategorias.isEmpty()) {
            fireTableDataChanged();
        } else {
            System.out.println("No se han encontrado subcategorías.");
        }

        return this.subcategorias;
    }
    public void cargarArticulos(SubCategoria subcategoriaSeleccionada) {
        this.articulos=subcategoriaSeleccionada.getListadoArticulos();
        fireTableDataChanged();
    }
    public void cargarPresentaciones(Articulo articuloSeleccionado) {
        this.presentaciones = articuloSeleccionado.getPresentacion();
        fireTableDataChanged();
    }
    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
        fireTableDataChanged();
    }

    public void cargarArchivo() {
        data.LoadXML();
    }

    @Override
    public int getRowCount() { //categorias
       if(categorias != null) {
           return categorias.size();
       }else if(subcategorias != null) {
           return subcategorias.size();
       }else if(articulos != null) {
           return articulos.size();
       }else if(presentaciones != null) {
           return presentaciones.size();
       }
       return 0;
    }
    @Override
    public String getColumnName(int columna) {
        if(categorias != null) {
            return columnasCategorias[columna];
        }else if(subcategorias != null) {
            return columnasSubCategorias[columna];
        }else if(articulos != null) {
            return columnasArticulos[columna];
        }else if(presentaciones != null) {
            return columnasPresentaciones[columna];
        }
        return null;
    }

    @Override
    public int getColumnCount() {
        if(categorias != null) {
            return columnasCategorias.length;
        }else if(subcategorias != null) {
            return columnasSubCategorias.length;
        }else if(articulos != null) {
            return columnasArticulos.length;
        }else if(presentaciones != null) {
            return columnasPresentaciones.length;
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (categorias != null) {
            Categoria categoria = categorias.get(rowIndex);
            switch (columnIndex) {
                case 0: return categoria.getID();
                case 1: return categoria.getNombre();
                case 2: return categoria.getDescripcion();
                default: return null;
            }
        } else if (subcategorias != null) {
            SubCategoria subCategoria = subcategorias.get(rowIndex);
            switch (columnIndex) {
                case 0: return subCategoria.getID();
                case 1: return subCategoria.getNombre();
                case 2: return subCategoria.getDescripcion();
                default: return null;
            }
        } else if (articulos != null) {
            Articulo articulo = articulos.get(rowIndex);
            switch (columnIndex) {
                case 0: return articulo.getId();
                case 1: return articulo.getMarca();
                case 2: return articulo.getNombre();
                case 3: return articulo.getDescripcion();
                default: return null;
            }
        } else if (presentaciones != null) {
            Presentacion presentacion = presentaciones.get(rowIndex);
            switch (columnIndex) {
                case 0: return presentacion.getId();
                case 1: return presentacion.getUnidad();
                case 2: return presentacion.getCantidad();
                default: return null;
            }
        }
        return null;
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
    public void actualizarDatosCategorias(List<Categoria> nuevasCategorias) {
        data.setCategorias(nuevasCategorias);
        fireTableDataChanged();  // Notifica a la vista que los datos han cambiado en el Table
    }
    public void actualizarDatosSubCategorias(List<SubCategoria> nuevasSubCategorias, Categoria categoriaSeleccionada) {
        categoriaSeleccionada.setSubcategorias(nuevasSubCategorias);
        fireTableDataChanged();
    }
    public void actualizarDatosArticulos(List<Articulo> nuevasArticulos, SubCategoria subCategoriaSeleccionada) {
        subCategoriaSeleccionada.setListadoArticulos(nuevasArticulos);
        fireTableDataChanged();
    }
    public void actualizarDatosPresentaciones(List<Presentacion> nuevasPresentaciones, Articulo articuloSeleccionado) {
        articuloSeleccionado.setPresentacion(nuevasPresentaciones);
        fireTableDataChanged();
    }
}

/// MODEL
/// Sus atributos son el inventario porque esa es la forma de acceder a los datos del XML
/// La idea es que los tables agarren la informacion y se pongan sus valores pero no funca jaja

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
