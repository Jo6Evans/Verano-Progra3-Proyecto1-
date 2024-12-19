package SGIF.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class SubCategoria {
    @XmlID
    String ID;
    String nombre;
    List<Listado> listado;
}
