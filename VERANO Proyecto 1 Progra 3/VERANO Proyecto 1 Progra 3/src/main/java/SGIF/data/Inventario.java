package SGIF.data;
import SGIF.Controller.*;
import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Inventario { //no se como hacerle para los articulos y el resto creo ;-; --- este es el Data como en el proyecto pasado, el que contiene todo

    @XmlElementWrapper(name = "presentaciones")
    @XmlElement(name = "presentacion")
    private List<Presentacion> presentaciones;

    public Inventario() {
        presentaciones = new ArrayList<>();
    }

    public List<Presentacion> getPresentaciones() {
        return presentaciones;
    }

}
