package SGIF.Controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Articulo {
    @XmlID
    String id;
    String marca;
    String nombre;
    String Descripcion;
    List<Presentacion> presentacion;

}
