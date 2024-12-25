package SGIF;

import SGIF.Controller.*;
import SGIF.View.Inventario;

import javax.swing.*;

import static java.awt.SystemColor.window;


public class Main {

    public static void main(String[] args) {
        // Crear el JFrame
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
    }
}
