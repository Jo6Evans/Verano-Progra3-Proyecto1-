package SGIF.View;

import javax.swing.*;
import javax.swing.JFrame;

public class Inventario {

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
    private JTable ListadoPanel;
    private JScrollPane PresentacionesScrollPanel;
    private JTable PresentacionesPanel;
    private JButton ArticuloguardarTodoButton;
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
    private JButton CategoriaeditarButton;
    private JButton SubCategoriaeditarButton;
    private JButton ArticuloeditarButton;

    public Inventario() {
        // Crear el JFrame
        JFrame frame = new JFrame("Inventario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Asegurarte de que mainpanel está correctamente inicializado
        if (mainpanel == null) {
            throw new IllegalStateException("El panel principal (mainpanel) no está inicializado. Verifica el diseño en IntelliJ.");
        }

        // Configurar el JFrame
        frame.setContentPane(mainpanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
