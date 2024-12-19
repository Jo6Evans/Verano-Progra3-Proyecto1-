package SGIF.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Categoria {
    @XmlID
    String ID;
    String nombre;
    String descripcion;
    List<SubCategoria> subCategoria;
}
