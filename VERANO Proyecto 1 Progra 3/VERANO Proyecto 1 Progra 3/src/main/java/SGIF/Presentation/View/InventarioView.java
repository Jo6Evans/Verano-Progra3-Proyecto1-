package SGIF.Presentation.View;

import SGIF.Presentation.Controller.Controller;
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
    private JTextField PresentacioncapacidadCantidadTxtField;
    private JTextField PresentacionIDTxtField;
    private JPanel CategoriaJpanel;
    private JPanel articuloPanel;
    private JPanel SubCategoriaPanel;
    private JPanel ArticuloPanel;
    private JLabel PresentacionUnidadLabel;
    private JTextField PresentacionUnidadTxtField;
    private JButton categoriaEliminarButton;
    private JButton categoriaLimpiarButton;
    private JButton subCategoriaElminarButton;
    private JButton subCategoriaLimpiarButton;
    private JButton articuloEliminarButton;
    private JButton articuloLimpiarButton;
    private JButton PresentacionEliminarButton;
    private JButton PresentacionLimpiarButton;

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

        listadoCategoria.setModel(controller.getModelCategorias());

        listadoCategoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = listadoCategoria.getSelectedRow();
                if (row >= 0) {
                    Categoria categoria = controller.getModel().getCategoriaAt(row);
                    SubCategoriaPanel.setEnabled(true);
                    var newModel = controller.getModelSubCategorias(categoria);
                    listadoSubcategoria.setModel(newModel);
                }
            }
        });

        listadoSubcategoria.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = listadoSubcategoria.getSelectedRow();
                if (row >= 0) {
                    int selectedCategoryRow = listadoCategoria.getSelectedRow();
                    if (selectedCategoryRow >= 0) {
                        Categoria categoriaSeleccionada = controller.getModel().getCategoriaAt(selectedCategoryRow);
                        SubCategoria subCategoria = controller.getModel().getSubCategoriaAt(row, categoriaSeleccionada);
                        listadoArticuloPanel.setEnabled(true);
                        listadoArticuloPanel.setModel(controller.getModelArticulos(subCategoria));
                    } else {
                        System.out.println("No se ha seleccionado ninguna categoría.");
                    }
                }
            }
        });


        listadoArticuloPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = listadoArticuloPanel.getSelectedRow();
                if (row >= 0) {

                    SubCategoria subCategoriaSeleccionada = controller.getModel().getSubCategoriaAt(listadoSubcategoria.getSelectedRow(),
                            controller.getModel().getCategoriaAt(listadoCategoria.getSelectedRow()));
                    Articulo articulo = controller.getModel().getArticuloAt(row, subCategoriaSeleccionada);
                    listadoPresentacionesPanel.setEnabled(true); // Habilitar panel de presentaciones
                    listadoPresentacionesPanel.setModel(controller.getModelPresentaciones(articulo)); // Actualizar presentaciones
                }
            }
        });

        listadoPresentacionesPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = listadoPresentacionesPanel.getSelectedRow();
                if (row >= 0) {
                    Articulo articuloSeleccionado = controller.getModel().getArticuloAt(listadoArticuloPanel.getSelectedRow(),
                            controller.getModel().getSubCategoriaAt(listadoSubcategoria.getSelectedRow(),
                                    controller.getModel().getCategoriaAt(listadoCategoria.getSelectedRow())));
                    Presentacion presentacion = controller.getModel().getPresentacionAt(row, articuloSeleccionado);
                }
            }
        });

        CategoriaguardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CategoriacodigoTxtField.setText("");
                CategorianombreTxtField.setText("");
                CategoriadescripcionTxtField.setText("");
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
        categoriaLimpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        subCategoriaLimpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SubCategoriacodigoTxtField.setText("");
                SubCategorianombreTxtField.setText("");
                SubCategoriadescripcionTxtField.setText("");
            }
        });

        articuloLimpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArticuloSubCategoriaTxtField.setText("");
                ArticuloCodigoTxtField.setText("");
                ArticuloDescripcionTxtField.setText("");
            }
        });
        PresentacionLimpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PresentacionUnidadTxtField.setText("");
                PresentacionIDTxtField.setText("");
                PresentacioncapacidadCantidadTxtField.setText("");
            }
        });
        CategoriabuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Categoria categoria = new Categoria();
                    controller.searchCategoria(SubCategoriaIDBuscarTxtField.getText(), SubCategorianombreBuscarTxtField.getText());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        SubCategoriabuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.searchSubcategoria(SubCategoriaIDBuscarTxtField.getText(),SubCategorianombreBuscarTxtField.getText());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        ArticulobuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    controller.searchArticulo(ArticuloIDBusquedaTxtField.getText(), ArticulonombreBusquedaTxtField.getText());
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
