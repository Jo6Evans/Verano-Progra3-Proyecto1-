package SGIF.data;

import SGIF.Controller.*;
import SGIF.Model.Articulo;
import SGIF.Model.Categoria;
import SGIF.Model.Presentacion;
import SGIF.Model.SubCategoria;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Document builder factory
//Document builder
//Document
public class ReadXMLFile {
   public List<Categoria> parseXML() throws ParserConfigurationException, IOException, SAXException {
       List<Categoria> listaCategorias = new ArrayList<>();
       try {
           // Configuracion del parser
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
               Element categoriaElement = (Element) categorias.item(i);
               //metiendo las informaciones en categorias que podemos manejar
               Categoria categoria = new Categoria();
               categoria.setID(categoriaElement.getAttribute("ID"));
               categoria.setNombre(categoriaElement.getAttribute("nombre"));
               categoria.setDescripcion(getTextContentOrDefault(categoriaElement,"descripcion"," "));
               //lineas 40 a 52 son para probar que funcione
               //-----------------------------------------------------------------------------------------------------------------------
               String idCategoria = categoriaElement.getAttribute("ID");
               String nombreCategoria = categoriaElement.getElementsByTagName("nombre").item(0).getTextContent();
               String descripcionCategoria = categoriaElement.getElementsByTagName("descripcion").item(0).getTextContent();

               // Verificar si la descripción de la categoría está vacía
               if (descripcionCategoria == null || descripcionCategoria.trim().isEmpty()) {
                   descripcionCategoria = "Descripción no disponible"; // Valor predeterminado
               }

               System.out.println("\n  Categoria ID: " + idCategoria);
               System.out.println("Nombre: " + nombreCategoria);
               System.out.println("Descripcion: " + descripcionCategoria+ "\n");
               //-----------------------------------------------------------------------------------------------------------------------


               // Iterar sobre las subcategorias
               NodeList subcategorias = categoriaElement.getElementsByTagName("subcategoria");
               List<SubCategoria> ListaSubCategorias = new ArrayList<>();
               for (int j = 0; j < subcategorias.getLength(); j++) {
                   Element subcategoriaElement = (Element) subcategorias.item(j);
                   SubCategoria subCategoria = new SubCategoria();
                   subCategoria.setID(subcategoriaElement.getAttribute("ID"));
                   subCategoria.setNombre(getTextContent(subcategoriaElement, "nombre"));
                   subCategoria.setDescripcion(getTextContentOrDefault(subcategoriaElement, "descripcion", " "));
                   //-----------------------------------------------------------------------------------------------------------------------------
                   String idSubcategoria = subcategoriaElement.getAttribute("ID");
                   String nombreSubcategoria = subcategoriaElement.getElementsByTagName("nombre").item(0).getTextContent();
                   String descripcionSubcategoria = subcategoriaElement.getElementsByTagName("descripcion").item(0).getTextContent();

                   //verifica si hay descripcion de subcategoria
                   if (descripcionSubcategoria == null || descripcionSubcategoria.trim().isEmpty()) {
                       descripcionSubcategoria = " "; // Valor predeterminado
                   }

                   System.out.println("  Subcategoria ID: " + idSubcategoria);
                   System.out.println("Nombre: " + nombreSubcategoria);
                   System.out.println("Descripcion: " + descripcionSubcategoria+ "\n");
                   //------------------------------------------------------------------------------------------------------------------------------

                   //listado que no se si hace falta, creo que si
                   Element listadoElement = (Element) subcategoriaElement.getElementsByTagName("listado").item(0);
                   NodeList articulos = listadoElement.getElementsByTagName("articulo");
                   // Iterar sobre los artículos
                   List<Articulo> listaArticulos = new ArrayList<>();
                   for (int k = 0; k < articulos.getLength(); k++) {
                       Element articuloElement = (Element) articulos.item(k);
                       Articulo articulo = new Articulo();
                       articulo.setId(articuloElement.getAttribute("ID"));
                       articulo.setMarca(getTextContent(articuloElement, "marca"));
                       articulo.setNombre(getTextContent(articuloElement, "nombre"));
                       articulo.setDescripcion(getTextContentOrDefault(articuloElement, "Descripcion", " "));

                       //------------------------------------------------------------------------------------------------------------------------------
                       String idArticulo = articuloElement.getAttribute("ID");
                       String marca = articuloElement.getElementsByTagName("marca").item(0).getTextContent();
                       String nombreArticulo = articuloElement.getElementsByTagName("nombre").item(0).getTextContent();
                       String descripcion = articuloElement.getElementsByTagName("Descripcion").item(0).getTextContent();

                       // Verificar si la descripción del artículo está vacía
                       if (descripcion == null || descripcion.trim().isEmpty()) {
                           descripcion = " "; // Valor predeterminado
                       }

                       System.out.println("  Articulo ID: " + idArticulo);
                       System.out.println("Marca: " + marca);
                       System.out.println("Nombre: " + nombreArticulo);
                       System.out.println("Descripcion: " + descripcion);
                       //------------------------------------------------------------------------------------------------------------------------------



                       // Iterar sobre las presentaciones
                       NodeList presentaciones = articuloElement.getElementsByTagName("presentacion");
                       List<Presentacion> listaPresentaciones = new ArrayList<>();
                       for (int l = 0; l < presentaciones.getLength(); l++) {
                           Element presentacionElement = (Element) presentaciones.item(l);
                           Presentacion presentacion = new Presentacion();
                           presentacion.setId(presentacionElement.getAttribute("id"));
                           presentacion.setUnidad(getTextContent(presentacionElement, "unidad"));
                           presentacion.setCantidad(getTextContent(presentacionElement, "cantidad"));

                           listaPresentaciones.add(presentacion);
                           //------------------------------------------------------------------------------------------------------------------------------
                           String unidad = presentacionElement.getElementsByTagName("unidad").item(0).getTextContent();
                           String cantidad = presentacionElement.getElementsByTagName("cantidad").item(0).getTextContent();

                           System.out.println("  Presentacion: " + cantidad + " " + unidad);
                           //------------------------------------------------------------------------------------------------------------------------------

                       }
                       articulo.setPresentacion(listaPresentaciones);
                       listaArticulos.add(articulo);
                   }
                   Listado listado = new Listado(listaArticulos);
                   subCategoria.setListadoArticulos(listado);
                   ListaSubCategorias.add(subCategoria);
               }
               categoria.setSubcategorias(ListaSubCategorias);
               listaCategorias.add(categoria);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return listaCategorias;
   }

   //metodos para obtener el texto dentro de los tags del xml, para que sea mas legible
    private String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent().trim(); //el trim elimina solo los espacios sobrantes al inicio y final
        }
        return "";
    }

    //para facilitar el manejo de los metodos para parsear
    private String getTextContentOrDefault(Element element, String tagName, String defaultValue) { //se entiende mejor en el metodo de parsear arriba
        String content = getTextContent(element, tagName);
        return content.isEmpty() ? defaultValue : content;
    }
}
