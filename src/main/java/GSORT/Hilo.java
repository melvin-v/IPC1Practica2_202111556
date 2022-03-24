package GSORT;

public class Hilo extends Thread{

    public  Hilo(Dato[] unosDatos, String orden, String vel, String upDown ){
        this.ordenamiento = orden;
        this.tipo = upDown;

        if(vel.equals("Rápida")){
            this.velocidad = 500;
        }
        if(vel.equals("Media")){
            this.velocidad = 1000;
        }
        if(vel.equals("Baja")){
            this.velocidad = 2000;
        }

        datos = new Dato[unosDatos.length];
        for(int i = 0;i<unosDatos.length;i++){
            this.datos[i] = unosDatos[i];
        }

    }

    @Override
    public void run() {
        if(ordenamiento == "Burbuja"){
            try {
                burbuja();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if(ordenamiento == "Selección"){
            seleccion();
        }
        if(ordenamiento == "Inserción"){
            insercion();
        }
    }

    public void burbuja() throws InterruptedException {
        String auxiliarSt;
        int auxiliarInt;
        for(int i=0;i < datos.length ;i++){
            for(int j=0;j < datos.length - 1;j++){
                if(datos[j].getValor() > datos[j+1].getValor()){
                    PanelOrdenamiento.grafico();
                    sleep(velocidad);
                    auxiliarSt = datos[j + 1].getCategoria();
                    auxiliarInt = datos[j + 1].getValor();
                    datos[j + 1].setCategoria(datos[j].getCategoria());
                    datos[j + 1].setValor(datos[j].getValor());
                    datos[j].setCategoria(auxiliarSt);
                    datos[j].setValor(auxiliarInt);
                }
            }
        }
        Cronometro.pararCrono = false;
    }

    public void seleccion(){

    }

    public void insercion(){

    }

    public Dato[] datos;
    private String ordenamiento;
    private int velocidad;
    private String tipo;
}
