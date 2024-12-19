package SGIF.logic;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlID;

import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class Presentacion {
    @XmlID
    String id;
    String unidad;
    int cantidad;
}
