package SGIF.Presentation.Model;

import SGIF.logic.Articulo;
import SGIF.logic.Presentacion;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PresentacionTableModel extends AbstractTableModel {

    final String[] columnas = {"ID", "Unidad", "Cantidad"};
    private List<Presentacion> presentaciones;

    public PresentacionTableModel(List<Presentacion> presentaciones) {
        this.presentaciones = presentaciones;
    }

    @Override
    public int getRowCount() {
        return presentaciones.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }
    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Presentacion presentacion = presentaciones.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return presentacion.getId();
            case 1:
                return presentacion.getUnidad();
            case 2:
                return presentacion.getCantidad();
            default:
                return null;
        }
    }
}
