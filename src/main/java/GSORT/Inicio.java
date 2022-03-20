package GSORT;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Inicio extends JFrame {
    private String ruta;
    public Dato [] datos;
    private String [] datosColumnas;
    JPanel ContenedorGrafico;
    JPanel root;
    public Inicio(){
        componentes();
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("G-SORT");
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    public void componentes(){
        ContenedorGrafico = new JPanel();
        ContenedorGrafico.setBounds(300, 250, 435, 250);

        root = new JPanel();
        this.getContentPane().add(root);
        root.setLayout(null);
        root.add(ContenedorGrafico);


        JLabel ruta = new JLabel("Ruta del archivo");
        ruta.setBounds(50, 10, 150, 30);
        root.add(ruta);

        JTextField cajaIngresar = new JTextField();
        cajaIngresar.setBounds(50, 50, 550, 30);

        root.add(cajaIngresar);

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setBounds(630, 50, 100, 30);
        root.add(botonBuscar);

        botonBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clickBuscar(e);
                cajaIngresar.setText(getRuta());
            }
        });


        JLabel titulo = new JLabel("Título de la gráfica");
        titulo.setBounds(50, 100, 150, 30);
        root.add(titulo);

        JTextField cajaTitulo = new JTextField();
        cajaTitulo.setBounds(50, 140, 550, 30);
        root.add(cajaTitulo);

        JButton botonCargar = new JButton("Cargar");
        botonCargar.setBounds(630, 140, 100, 30);
        root.add(botonCargar);

        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    clickCargar(e, cajaIngresar.getText(), cajaTitulo.getText());
        }});


        JLabel panelOpciones = new JLabel("Panel de opciones");
        panelOpciones.setBounds(50, 240, 150, 30);
        root.add(panelOpciones);


        JLabel algoritmo = new JLabel("Algoritmo");
        algoritmo.setBounds(50, 300, 100, 30);
        root.add(algoritmo);

        JComboBox listaAlgoritmo = new JComboBox();
        listaAlgoritmo.setBounds(130, 305, 100, 20);
        listaAlgoritmo.addItem("Burbuja");
        listaAlgoritmo.addItem("Selección");
        listaAlgoritmo.addItem("Inserción");
        root.add(listaAlgoritmo);


        JLabel tipo = new JLabel("Tipo");
        tipo.setBounds(50, 350, 100, 30);
        root.add(tipo);

        JComboBox listaTipo = new JComboBox();
        listaTipo.setBounds(130, 355, 100, 20);
        listaTipo.addItem("Ascendente");
        listaTipo.addItem("Descendente");
        root.add(listaTipo);


        JLabel velocidad = new JLabel("Velocidad");
        velocidad.setBounds(50, 400, 100, 30);
        root.add(velocidad);

        JComboBox listaVelocidad = new JComboBox();
        listaVelocidad.setBounds(130, 405, 100, 20);
        listaVelocidad.addItem("Rápida");
        listaVelocidad.addItem("Media");
        listaVelocidad.addItem("Baja");
        root.add(listaVelocidad);

        JButton botonEjecutar = new JButton("Ejecutar");
        botonEjecutar.setBounds(80, 460, 100, 40);
        root.add(botonEjecutar);


    }

    public void clickBuscar(ActionEvent e){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(fileChooser);
        setRuta(fileChooser.getSelectedFile().getAbsolutePath());
    }

    public void clickCargar(ActionEvent event, String a, String titulo) {
        String extension = a.substring(a.lastIndexOf(".")+1);

        if(extension.equals("csv")) {
            BufferedReader bufferLectura = null;
            try{
                bufferLectura = new BufferedReader(new FileReader(a));
                String textoArchivo = bufferLectura.readLine();
                String [] textoLineas = textoArchivo.split("/n");
                String [] encabezado = textoLineas[0].split(",");
                datos = new Dato[textoLineas.length-1];
                String[] columnas;

                for(int i=1; i < textoLineas.length; i++) {
                    columnas = textoLineas[i].split(",");
                    datos[i-1] = new Dato(columnas[0],columnas[1]);
                }

                DefaultCategoryDataset DefDatos = new DefaultCategoryDataset();

                for(Dato dato: datos){
                    DefDatos.setValue(dato.getValor(), dato.getCategoria(), "");
                 }

                JFreeChart grafico = ChartFactory.createBarChart3D(
                        titulo,
                        encabezado[0],
                        encabezado[1],
                        DefDatos,
                        PlotOrientation.VERTICAL,
                        true,
                        true,
                        false);

                ChartPanel panelGrafico = new ChartPanel(grafico);
                panelGrafico.setMouseWheelEnabled(true);
                panelGrafico.setPreferredSize(new Dimension(400, 200));

               ContenedorGrafico.setLayout(new BorderLayout());
               ContenedorGrafico.add(panelGrafico);
               ContenedorGrafico.validate();


            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                if (bufferLectura != null) {
                    try {
                        bufferLectura.close();
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }}}



        }
        else{
            JOptionPane.showMessageDialog(this, "¡Archivo no valido!");
        }
    }

    public void setRuta(String ruta){
        this.ruta = ruta;
    }

    public String getRuta(){
        return  this.ruta;
    }

}
