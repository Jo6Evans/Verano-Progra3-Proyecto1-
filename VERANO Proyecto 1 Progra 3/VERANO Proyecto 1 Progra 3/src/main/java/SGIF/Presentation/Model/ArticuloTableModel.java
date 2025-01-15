package SGIF.Presentation.Model;

import SGIF.logic.Articulo;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ArticuloTableModel extends AbstractTableModel {
    final String[] columnas = {"ID", "Marca", "Nombre", "Descripcion"};
    private List<Articulo> articulos;

    public ArticuloTableModel(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public int getRowCount() {
        return articulos.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Articulo articulo = articulos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return articulo.getId();
            case 1:
                return articulo.getMarca();
            case 2:
                return articulo.getNombre();
            case 3:
                return articulo.getDescripcion();
            default:
                return null;
        }
    }
}
