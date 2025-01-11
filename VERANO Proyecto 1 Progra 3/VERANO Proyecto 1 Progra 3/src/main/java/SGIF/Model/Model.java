package SGIF.Model;

import SGIF.logic.Categoria;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

///AQUI VA UN MODEL COMO EL DEL LABORATORIO 05

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
