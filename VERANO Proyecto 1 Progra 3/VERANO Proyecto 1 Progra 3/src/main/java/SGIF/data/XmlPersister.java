package SGIF.data;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XmlPersister {
    private String path;
    private static XmlPersister theInstance;
    public static XmlPersister instance(){
        if (theInstance==null) theInstance=new XmlPersister("inventario.xml"); //hay que cambiar este nombre si para el examen por ejemplo
        return theInstance;
    }
    public XmlPersister(String p) {
        path=p;
    }
    public Inventario load() throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Inventario.class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Inventario result = (Inventario) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }
    public void store(Inventario d)throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Inventario.class);
        FileOutputStream os = new FileOutputStream(path);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(d, os);
        os.flush();
        os.close();
    }
}
