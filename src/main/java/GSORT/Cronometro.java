package GSORT;

import javax.swing.*;

public class Cronometro extends Thread{
        JLabel labelCrono;
        static boolean pararCrono=true;
        public Cronometro(JLabel label){
            labelCrono = label;
        }

    @Override
    public void run() {
            if (pararCrono) {
                try {
                    while (true) {
                        Thread.sleep(1000);
                        metodo();
                    }
                } catch (Exception e) {
                    System.out.println("Error en el hilo" + e.getMessage());
                }
            }
    }

    public void metodo(){
            PanelOrdenamiento.segundo++;
            if(PanelOrdenamiento.segundo > 59){
                PanelOrdenamiento.segundo = 0;
                PanelOrdenamiento.miniuto++;
            }
            if(PanelOrdenamiento.miniuto > 59){
                PanelOrdenamiento.miniuto = 0;
             PanelOrdenamiento.hora++;
            }

            String textSeg = "", textMin = "", textHora = "";

            if(PanelOrdenamiento.segundo<10){
                textSeg = "0" + PanelOrdenamiento.segundo;
            }
            else{
                textSeg = "" + PanelOrdenamiento.segundo;
            }

             if(PanelOrdenamiento.miniuto<10){
                textMin = "0" + PanelOrdenamiento.miniuto;
                }
            else{
             textMin = "" + PanelOrdenamiento.miniuto;
                }

            if(PanelOrdenamiento.hora<10){
             textHora = "0" + PanelOrdenamiento.hora;
             }
            else{
                textHora = "" + PanelOrdenamiento.hora;
                }

            String reloj = textHora + ":" + textMin + ":" + textSeg;
            labelCrono.setText(reloj);
    }
}
