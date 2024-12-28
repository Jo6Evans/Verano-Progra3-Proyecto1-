package SGIF.Controller;

import org.w3c.dom.NodeList;

import java.util.List;

public class Listado { //esto creo que no hace falta pero no estoy nada seguro, le mando un mensaje al profe el lunes
    //en el caso de que esto se use creo que este tiene la lista de articulos y subcateogoria tendria un objeto listado
    private List<Articulo> articulos; //?? el orden creo que es: subcategoria tiene sus atributos Y un Listado que tiene un articulo con una lista de presentaciones

    public Listado(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public List<Articulo> getArticulo() {
        return articulos;
    }

    public void setArticulo(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    public void agregarArticulo(Articulo articulo) {
        this.articulos.add(articulo);
    }
    public void eliminarArticulo(Articulo articulo) {
        this.articulos.remove(articulo);
    }
}
