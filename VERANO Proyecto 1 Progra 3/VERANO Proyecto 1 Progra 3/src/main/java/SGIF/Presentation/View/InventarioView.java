package SGIF.Presentation.View;

import SGIF.Presentation.Controller.Controller;
import SGIF.Presentation.Model.CategoriaTableModel;
import SGIF.Presentation.Model.SubCategoriaTableModel;
import SGIF.logic.Articulo;
import SGIF.logic.Categoria;
import SGIF.logic.Presentacion;
import SGIF.logic.SubCategoria;

import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InventarioView {

    private JTabbedPane tabbedPane;
    private JPanel mainpanel;
    private JLabel ArticulocategoriaLabel;
    private JLabel ArticulosubCategoriaLabel;
    private JLabel ArticulocodigoLabel;
    private JLabel ArticulonombreLabel;
    private JTextField ArticuloCodigoTxtField;
    private JTextField ArticuloNombreTxtField;
    private JTextField ArticuloDescripcionTxtField;
    private JTextField ArticuloSubCategoriaTxtField;
    private JTextField ArticuloCategoriaTxtField;
    private JButton ArticuloguardarButton;
    private JLabel ArticulodescripcionLabel;
    private JLabel ArticulonombreLabel1;
    private JTextField ArticulonombreBusquedaTxtField;
    private JLabel ArticuloIDLabel;
    private JTextField ArticuloIDBusquedaTxtField;
    private JButton ArticulobuscarButton;
    private JScrollPane ListadoScrollPanel;
    private JTable listadoArticuloPanel;
    private JScrollPane PresentacionesScrollPanel;
    private JTable listadoPresentacionesPanel;
    private JButton presentacionguardarTodoButton;
    private JLabel CategoriacodigoLabel;
    private JTextField CategoriacodigoTxtField;
    private JTextField CategorianombreTxtField;
    private JTextField CategoriadescripcionTxtField;
    private JButton CategoriaguardarButton;
    private JLabel CategorianombreBuscarLabel;
    private JTextField CategorianombreBuscarTxtField;
    private JLabel CategoriaIDBuscarLabel;
    private JTextField CategoriaIDBuscarTxtField;
    private JButton CategoriabuscarButton;
    private JTable listadoCategoria;
    private JLabel CategorianombreLabel;
    private JLabel CategoriadescripcionLabel;
    private JLabel SubCategoriacategoriaLabel;
    private JLabel SubCategoriasubCategoriaLabel;
    private JLabel SubCategoriacodigoLabel;
    private JLabel SubCategorianombreLabel;
    private JLabel SubCategoriadescripcionLabel;
    private JTextField SubCategoriacategoriaTxtField;
    private JTextField SubCategoriasubCategoriaTxtField;
    private JTextField SubCategoriacodigoTxtField;
    private JTextField SubCategorianombreTxtField;
    private JTextField SubCategoriadescripcionTxtField;
    private JLabel SubCategorianombreBuscarLabel1;
    private JTextField SubCategorianombreBuscarTxtField;
    private JLabel SubCategoriaIDBuscarLabel;
    private JTextField SubCategoriaIDBuscarTxtField;
    private JButton SubCategoriabuscarButton;
    private JTable listadoSubcategoria;
    private JButton SubCategoriaguardarButton;

    //tab acerca de
    private JPanel AcercaDePanel;
    private JLabel IntegrantesLabel;
    private JLabel LetraAsignadaDeGrupo;
    private JLabel InfoDelPrograma;
    private JLabel PresentacionIDLabel;
    private JLabel capacidadCantidadLabel;
    private JTextField presentacioncapacidadCantidadLabel;
    private JTextField presentacionIDTxtField;
    private JPanel CategoriaJpanel;
    private JPanel articuloPanel;
    private JPanel SubCategoriaPanel;
    private JPanel ArticuloPanel;

    private Controller controller;

    public InventarioView() {

        controller = new Controller();

        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                int selectedIndex = tabbedPane.getSelectedIndex();
                // Si se selecciona Categoría
                if (selectedIndex == 0) {
                    tabbedPane.setEnabledAt(1, true);   // Habilitar Subcategoría

                    // Si se selecciona Subcategoría
                } else if (selectedIndex == 1) {
                    tabbedPane.setEnabledAt(2, true);   // Habilitar Artículo
                }
            }
        });

        // 1. Tabla de Categorías

        listadoCategoria.setModel(controller.getModelCategorias());

        listadoCategoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = listadoCategoria.getSelectedRow();
                if (row >= 0) {
                    Categoria categoria = controller.getModel().getCategoriaAt(row);
                    SubCategoriaPanel.setEnabled(true);  // Habilitar subcategorías
                    var newModel = controller.getModelSubCategorias(categoria);
                    listadoSubcategoria.setModel(newModel);  // Actualizar subcategorías
                }
            }
        });

// 2. Tabla de Subcategorías
        listadoSubcategoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = listadoSubcategoria.getSelectedRow();
                if (row >= 0) {
                    int selectedCategoryRow = listadoCategoria.getSelectedRow();
                    if (selectedCategoryRow >= 0) {
                        Categoria categoriaSeleccionada = controller.getModel().getCategoriaAt(selectedCategoryRow);
                        SubCategoria subCategoria = controller.getModel().getSubCategoriaAt(row, categoriaSeleccionada);
                        listadoArticuloPanel.setEnabled(true); // Habilitar panel de articulos
                        listadoArticuloPanel.setModel(controller.getModelArticulos(subCategoria));
                    } else {
                        System.out.println("No se ha seleccionado ninguna categoría.");
                    }
                }
            }
        });


// 3. Tabla de Artículos
        listadoArticuloPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = listadoArticuloPanel.getSelectedRow();
                if (row >= 0) {
                    // Obtener la subcategoría seleccionada
                    SubCategoria subCategoriaSeleccionada = controller.getModel().getSubCategoriaAt(listadoSubcategoria.getSelectedRow(),
                            controller.getModel().getCategoriaAt(listadoCategoria.getSelectedRow()));
                    // Obtener el artículo seleccionado
                    Articulo articulo = controller.getModel().getArticuloAt(row, subCategoriaSeleccionada);
                    listadoPresentacionesPanel.setEnabled(true); // Habilitar panel de presentaciones
                    listadoPresentacionesPanel.setModel(controller.getModelPresentaciones(articulo)); // Actualizar presentaciones
                }
            }
        });

// 4. Tabla de Presentaciones
        listadoPresentacionesPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = listadoPresentacionesPanel.getSelectedRow();
                if (row >= 0) {
                    // Obtener el artículo seleccionado
                    Articulo articuloSeleccionado = controller.getModel().getArticuloAt(listadoArticuloPanel.getSelectedRow(),
                            controller.getModel().getSubCategoriaAt(listadoSubcategoria.getSelectedRow(),
                                    controller.getModel().getCategoriaAt(listadoCategoria.getSelectedRow())));
                    // Obtener la presentación seleccionada
                    Presentacion presentacion = controller.getModel().getPresentacionAt(row, articuloSeleccionado);
                    // Aquí puedes hacer lo que necesites con la presentación seleccionada
                }
            }
        });

        CategoriaguardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        CategoriabuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Categoria categoria = new Categoria();
                    categoria.setID(CategoriaIDBuscarTxtField.getText());
                    categoria.setNombre(CategorianombreBuscarTxtField.getText());
                   // controller.searchCategoria(categoria);
                    llenarCamposdeTexto(categoria);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    private void llenarCamposdeTexto(Categoria e) {
        CategoriacodigoTxtField.setText(e.getID());
        CategorianombreTxtField.setText(e.getNombre());
        CategoriadescripcionTxtField.setText(String.valueOf(e.getDescripcion()));
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void loadView() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Login");
            frame.setContentPane(new InventarioView().mainpanel); // Asigna el JPanel al JFrame
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al salir

            frame.pack(); // Ajusta el tamaño del JFrame al contenido
            frame.setLocationRelativeTo(null); // Centra la ventana
            frame.setVisible(true); // Muestra la ventana
        });
    }
}
