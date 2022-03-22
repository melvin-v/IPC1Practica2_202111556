package GSORT;

import javax.swing.*;
import java.awt.*;

public class PanelOrdenamiento extends JDialog{
    JPanel ContenedorGrafico;
    JPanel root;
    Hilo h;

    public PanelOrdenamiento(Frame parent, boolean modal, Dato[] unosDatos, String orden, String vel) {
        super(parent, modal);
        iniciarComponentes();
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ordenamiento");
        setVisible(true);

        h = new Hilo(unosDatos, orden, vel);
        h.start();

    }

    public void iniciarComponentes(){
        ContenedorGrafico = new JPanel();
        ContenedorGrafico.setBounds(50, 250, 435, 250);

        root = new JPanel();
        this.getContentPane().add(root);
        root.setLayout(null);
        root.add(ContenedorGrafico);

        JLabel caracteristicas = new JLabel("Características del ordenamiento");
        caracteristicas.setBounds(30, 5, 200, 30);
        root.add(caracteristicas);

    }
}
