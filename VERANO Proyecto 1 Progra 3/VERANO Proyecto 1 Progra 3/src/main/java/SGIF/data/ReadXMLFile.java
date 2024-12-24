package SGIF.data;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

//Document builder factory
//Document builder
//Document
public class ReadXMLFile {
   public void parseXML() throws ParserConfigurationException, IOException, SAXException {
       try {
           // Configuración del parser
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
           DocumentBuilder builder = factory.newDocumentBuilder();

           // Cargar el archivo XML
           Document document = builder.parse("VERANO Proyecto 1 Progra 3/inventario.xml");

           // Obtener el nodo raíz
           Element root = document.getDocumentElement();
           System.out.println("Root: " + root.getTagName());

           // Iterar sobre las categorías
           NodeList categorias = root.getElementsByTagName("categoria");
           for (int i = 0; i < categorias.getLength(); i++) {
               Element categoria = (Element) categorias.item(i);
               String idCategoria = categoria.getAttribute("ID");
               String nombreCategoria = categoria.getElementsByTagName("nombre").item(0).getTextContent();
               String descripcionCategoria = categoria.getElementsByTagName("descripcion").item(0).getTextContent();

               // Verificar si la descripción de la categoría está vacía
               if (descripcionCategoria == null || descripcionCategoria.trim().isEmpty()) {
                   descripcionCategoria = "Descripción no disponible"; // Valor predeterminado
               }

               System.out.println("\n  Categoria ID: " + idCategoria);
               System.out.println("Nombre: " + nombreCategoria);
               System.out.println("Descripcion: " + descripcionCategoria+ "\n");

               // Iterar sobre las subcategorías
               NodeList subcategorias = categoria.getElementsByTagName("subcategoria");
               for (int j = 0; j < subcategorias.getLength(); j++) {
                   Element subcategoria = (Element) subcategorias.item(j);
                   String idSubcategoria = subcategoria.getAttribute("ID");
                   String nombreSubcategoria = subcategoria.getElementsByTagName("nombre").item(0).getTextContent();
                   String descripcionSubcategoria = subcategoria.getElementsByTagName("descripcion").item(0).getTextContent();

                   //verifica si hay descripcion de subcategoria
                   if (descripcionSubcategoria == null || descripcionSubcategoria.trim().isEmpty()) {
                       descripcionSubcategoria = " "; // Valor predeterminado
                   }

                   System.out.println("  Subcategoria ID: " + idSubcategoria);
                   System.out.println("Nombre: " + nombreSubcategoria);
                   System.out.println("Descripcion: " + descripcionSubcategoria+ "\n");

                   // Iterar sobre los artículos
                   NodeList articulos = subcategoria.getElementsByTagName("articulo");
                   for (int k = 0; k < articulos.getLength(); k++) {
                       Element articulo = (Element) articulos.item(k);
                       String idArticulo = articulo.getAttribute("ID");
                       String marca = articulo.getElementsByTagName("marca").item(0).getTextContent();
                       String nombreArticulo = articulo.getElementsByTagName("nombre").item(0).getTextContent();
                       String descripcion = articulo.getElementsByTagName("Descripcion").item(0).getTextContent();

                       // Verificar si la descripción del artículo está vacía
                       if (descripcion == null || descripcion.trim().isEmpty()) {
                           descripcion = " "; // Valor predeterminado
                       }

                       System.out.println("  Articulo ID: " + idArticulo);
                       System.out.println("Marca: " + marca);
                       System.out.println("Nombre: " + nombreArticulo);
                       System.out.println("Descripcion: " + descripcion);

                       // Iterar sobre las presentaciones
                       NodeList presentaciones = articulo.getElementsByTagName("presentacion");
                       for (int l = 0; l < presentaciones.getLength(); l++) {
                           Element presentacion = (Element) presentaciones.item(l);
                           String unidad = presentacion.getElementsByTagName("unidad").item(0).getTextContent();
                           String cantidad = presentacion.getElementsByTagName("cantidad").item(0).getTextContent();

                           System.out.println("  Presentacion: " + cantidad + " " + unidad);
                       }
                   }
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
   }
}
