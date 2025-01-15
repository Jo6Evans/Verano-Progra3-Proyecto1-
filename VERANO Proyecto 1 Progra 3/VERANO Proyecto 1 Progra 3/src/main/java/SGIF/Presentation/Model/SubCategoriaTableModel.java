package SGIF.Presentation.Model;

import SGIF.logic.SubCategoria;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class SubCategoriaTableModel extends AbstractTableModel {
    private final String[] columnNames = {"ID", "Categoria ID", "Nombre"};
    private final List<SubCategoria> subcategorias;

    public SubCategoriaTableModel(List<SubCategoria> subcategorias) {
        this.subcategorias = subcategorias;
    }

    @Override
    public int getRowCount() {
        return subcategorias.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SubCategoria subCategoria = subcategorias.get(rowIndex);
        switch (columnIndex) {
            case 0: return subCategoria.getID();
            case 1: return subCategoria.getNombre();
            case 2: return subCategoria.getDescripcion();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}