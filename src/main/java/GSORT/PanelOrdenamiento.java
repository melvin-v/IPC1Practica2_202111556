package GSORT;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class PanelOrdenamiento extends JFrame{
    JPanel ContenedorGrafico;
    JPanel root;
    static Hilo h;
    Cronometro cr;
    JLabel crono;
    private String ordenamiento;
    private String velocidad;
    private String tipo;
    private String mensaje;
    static int hora = 0, miniuto = 0, segundo = 0;

    public PanelOrdenamiento(Dato[] unosDatos, String orden, String vel, String upDown) {
        setSize(700, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Ordenamiento");
        setVisible(true);
        ordenamiento = orden;
        velocidad = vel;
        tipo = upDown;

        h = new Hilo(unosDatos, orden, vel, upDown);
        h.start();

        mensaje();
        iniciarComponentes();

        cr = new Cronometro(crono);
        cr.start();
    }

    public void mensaje(){
        mensaje = "Algotitmo: " + ordenamiento + "     " + "Tipo: " + tipo + "     " + "Velocidad: " + velocidad;
    }

    public void iniciarComponentes(){

        ContenedorGrafico = new JPanel();
        ContenedorGrafico.setBounds(100, 150, 435, 250);

        root = new JPanel();
        this.getContentPane().add(root);
        root.setLayout(null);
        root.add(ContenedorGrafico);

        JLabel caracteristicas = new JLabel("Características del ordenamiento");
        caracteristicas.setBounds(30, 5, 300, 30);
        caracteristicas.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        root.add(caracteristicas);

        JLabel texto = new JLabel(mensaje);
        texto.setBounds(30, 50, 400, 30);
        root.add(texto);

        JLabel ejecucion = new JLabel("Ejecucion");
        ejecucion.setBounds(500, 5, 400, 30);
        ejecucion.setFont(new Font("TimesRoman", Font.PLAIN, 16));
        root.add(ejecucion);

        JLabel tiem = new JLabel("Tiempo: ");
        tiem.setBounds(500, 40, 100, 40);
        root.add(tiem);

        crono = new JLabel("00:00:00");
        crono.setBounds(550, 40, 100, 40);
        root.add(crono);

        JLabel textPasos = new JLabel("Pasos: ");
        textPasos.setBounds(500, 70, 100, 30);
        root.add(textPasos);

        JLabel pasos = new JLabel("1");
        pasos.setBounds(550, 70, 100, 30);
        root.add(pasos);




    }

    public static void grafico(){
        DefaultCategoryDataset DefDatos = new DefaultCategoryDataset();

        for(int i = 0; i < h.datos.length; i++){
            DefDatos.setValue(h.datos[i].getValor(), h.datos[i].getCategoria(), "");
        }


        JFreeChart grafico = ChartFactory.createBarChart3D(
                Inicio.tituloGrafica,
                Inicio.encabezado[0],
                Inicio.encabezado[1],
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
}
