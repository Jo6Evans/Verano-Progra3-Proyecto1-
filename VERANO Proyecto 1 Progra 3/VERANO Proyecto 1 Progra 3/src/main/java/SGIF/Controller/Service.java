package SGIF.Controller;

import SGIF.data.Inventario;
import SGIF.data.XmlPersister;

public class Service {
    private static Service theInstance;

    public static Service instance(){
        if (theInstance == null) theInstance = new Service();
        return theInstance;
    }
    private Inventario inventario;

    private Service(){
        try{
            inventario = XmlPersister.instance().load();
        }
        catch(Exception e){
            inventario =  new Inventario();
        }
    }

    public void stop(){
        try {
            XmlPersister.instance().store(inventario);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    //------------CRUDS de las clases------------//

}
