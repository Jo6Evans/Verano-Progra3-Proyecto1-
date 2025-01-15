package SGIF;

import SGIF.Presentation.Controller.Controller;
import SGIF.Presentation.Model.Model;
import SGIF.Presentation.View.InventarioView;
import SGIF.data.ReadXMLFile;
import SGIF.logic.Categoria;
import SGIF.logic.Presentacion;
import SGIF.logic.SubCategoria;
import SGIF.logic.Articulo;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.


        InventarioView view = new InventarioView();
        Controller controller = new Controller();
        controller.startApplication();

//
//
//
//        System.out.printf("Carga bien, escribe bien" + '\n');
//
//       // Data data = new Data();
//        ReadXMLFile xml = new ReadXMLFile();
//        Model model = new Model();
//        model.setCategorias(xml.cargarCategorias());
//
//        List<Categoria> Categorias = model.getCategorias();
//
//        for (Categoria categoria : Categorias) {
//            System.out.println("CATEGORIA");
//            System.out.println("ID:" + categoria.getID() + "  Nombre:" + categoria.getNombre() + "  Descripcion:" + categoria.getDescripcion());
//
//            List<SubCategoria> subCategorias = categoria.getSubCategoria();
//
//            for (SubCategoria subcategoria : subCategorias) {
//                System.out.println("\tSUB-CATEGORIA");
//                System.out.println("\tID:" + subcategoria.getID() + "  Nombre:" + subcategoria.getNombre() + "  Descripcion:" + subcategoria.getDescripcion());
//                List<Articulo> articulos = subcategoria.getListadoArticulos();
//
//                for (Articulo articulo : articulos) {
//                    System.out.println("\t\tARTICULO");
//                    System.out.println("\t\tID:" + articulo.getId() + " Marca: " + articulo.getMarca()+"  Nombre:" + articulo.getNombre() + "  Descripcion:" + articulo.getDescripcion());
//
//                    for(Presentacion presentacion : articulo.getPresentacion()){
//                        System.out.println("\t\t\tPRESENTACION");
//                        System.out.println("\t\t\tID:"+ presentacion.getId() + " Unidad:" + presentacion.getUnidad() + " Cantidad:"+ presentacion.getCantidad());
//                    }
//                }
//
//            }
//
//        }
//        try {
//            xml.guardar(Categorias);
//        } catch (ParserConfigurationException e) {
//            throw new RuntimeException(e);
//        } catch (TransformerException e) {
//            throw new RuntimeException(e);
//        }

    }







































//        public static void main(String[] args)throws ParserConfigurationException, IOException, SAXException {
//
//        ///Se generaban 2 interfaces al momento de correrlo y la que estaba extra era la comentada en el main
//        ///Entonces la comente y solamente llame la que ya existia en el View, ya solo sale una
//
//
//
// /*       // Crear el JFrame
//        JFrame frame = new JFrame("Inventario");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Crear una instancia de Inventario
//        Inventario view = new Inventario();
//
//        // Configurar el contenido del JFrame con el mainpanel
//        frame.setContentPane(view.getMainpanel());
//
//        // Ajustar tamaño y visibilidad
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//*/
//
//        // Crear una instancia de Inventario para mostrar el view
//        Inventario view = new Inventario();
//        view.getMainpanel().setVisible(true);
//
//
//        //para probar el XML
// /*       //Prueba para ver si funciona, al parecer si funciona wuuuu
//        ReadXMLFile parser = new ReadXMLFile();
//        List<Categoria> categorias = parser.parseXML();
//
//        for (Categoria categoria : categorias) {
//                System.out.println("Categoría: " + categoria.getNombre());
//                for (SubCategoria subcategoria : categoria.getSubCategoria()) {
//                        System.out.println("  Subcategoría: " + subcategoria.getNombre());
//                        for (Articulo articulo : subcategoria.getListadoArticulos().getArticulo()) {
//                                System.out.println("    Artículo: " + articulo.getNombre());
//                                for (Presentacion presentacion : articulo.getPresentacion()) {
//                                        System.out.println("      Presentación: " + presentacion.getCantidad() + " " + presentacion.getUnidad());
//                                }
//                        }
//                }
//        }
//*/
//
//
//    }
}
