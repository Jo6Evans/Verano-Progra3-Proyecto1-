package SGIF.Controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class SubCategoria {
    @XmlID
    String ID;
    String nombre;
    List<Listado> listado;
}
