package SGIF.Presentation.Model;

import SGIF.logic.Categoria;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CategoriaTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Nombre"};
    private final List<Categoria> categorias;

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
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
