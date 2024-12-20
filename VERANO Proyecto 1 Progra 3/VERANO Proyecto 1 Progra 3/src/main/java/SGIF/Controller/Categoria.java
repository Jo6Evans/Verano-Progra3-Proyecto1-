package SGIF.Controller;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Categoria {
    @XmlID
    String ID;
    String nombre;
    String descripcion;
    List<SubCategoria> subCategoria;
}
