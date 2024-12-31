package SGIF;

import SGIF.Controller.*;
import SGIF.View.Inventario;
import SGIF.data.ReadXMLFile;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;
import java.util.List;

import static java.awt.SystemColor.window;


public class Main {

        public static void main(String[] args)throws ParserConfigurationException, IOException, SAXException {

        ///Se generaban 2 interfaces al momento de correrlo y la que estaba extra era la comentada en el main
        ///Entonces la comente y solamente llame la que ya existia en el View, ya solo sale una



 /*       // Crear el JFrame
        JFrame frame = new JFrame("Inventario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una instancia de Inventario
        Inventario view = new Inventario();

        // Configurar el contenido del JFrame con el mainpanel
        frame.setContentPane(view.getMainpanel());

        // Ajustar tamaño y visibilidad
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
*/

        // Crear una instancia de Inventario para mostrar el view
        Inventario view = new Inventario();
        view.getMainpanel().setVisible(true);


        //para probar el XML
 /*       //Prueba para ver si funciona, al parecer si funciona wuuuu
        ReadXMLFile parser = new ReadXMLFile();
        List<Categoria> categorias = parser.parseXML();

        for (Categoria categoria : categorias) {
                System.out.println("Categoría: " + categoria.getNombre());
                for (SubCategoria subcategoria : categoria.getSubCategoria()) {
                        System.out.println("  Subcategoría: " + subcategoria.getNombre());
                        for (Articulo articulo : subcategoria.getListadoArticulos().getArticulo()) {
                                System.out.println("    Artículo: " + articulo.getNombre());
                                for (Presentacion presentacion : articulo.getPresentacion()) {
                                        System.out.println("      Presentación: " + presentacion.getCantidad() + " " + presentacion.getUnidad());
                                }
                        }
                }
        }
*/


    }
}
