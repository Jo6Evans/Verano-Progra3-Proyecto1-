package SGIF.Presentation.Model;

import SGIF.logic.Categoria;
import javax.swing.table.AbstractTableModel;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CategoriaTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Nombre","Descripcion"};
    private List<Categoria> categorias;

    public CategoriaTableModel(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public int getRowCount() {
        return categorias.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Categoria categoria = categorias.get(rowIndex);
        switch (columnIndex) {
            case 0: return categoria.getID();
            case 1: return categoria.getNombre();
            case 2: return categoria.getDescripcion();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    //METODO NUEVO
    // Método para actualizar las categorías en el TableModel
    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
        fireTableDataChanged();  // Notificar a la vista que los datos han cambiado
    }



}
