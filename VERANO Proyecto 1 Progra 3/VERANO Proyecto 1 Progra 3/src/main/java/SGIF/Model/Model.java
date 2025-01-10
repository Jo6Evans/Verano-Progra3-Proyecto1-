package SGIF.Model;

import SGIF.logic.Categoria;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;


public class Model extends DefaultTableModel {
    private List<Categoria> Categorias;

    public Model(){
        Categorias = new ArrayList<>();
    }
    public List<Categoria> getCategorias() {
        return Categorias;
    }
    public void setCategorias(List<Categoria> categorias) {
        Categorias = categorias;
    }
}
