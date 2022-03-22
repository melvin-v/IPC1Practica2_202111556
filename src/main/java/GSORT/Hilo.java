package GSORT;

public class Hilo extends Thread{

    public  Hilo(Dato[] unosDatos, String orden, String vel ){
        this.ordenamiento = orden;
        this.velocidad = vel;

        datos = new Dato[unosDatos.length];
        for(int i = 0;i<unosDatos.length;i++){
            this.datos[i] = unosDatos[i];
        }

    }

    @Override
    public void run() {
        if(ordenamiento == "Burbuja"){
           burbuja();
        }
        if(ordenamiento == "Selección"){
            seleccion();
        }
        if(ordenamiento == "Inserción"){
            insercion();
        }
    }

    public void burbuja(){
        String auxiliarSt;
        int auxiliarInt;
        for(int i=0;i < datos.length - 1;i++){
            System.out.println("Hola");
            for(int j=0;j < datos.length - 1;j++){
                if(datos[j].getValor() > datos[j+1].getValor()){
                    auxiliarSt = datos[j].getCategoria();
                    auxiliarInt = datos[j].getValor();
                    datos[j].setCategoria(datos[j+1].getCategoria());
                    datos[j].setValor(datos[j+1].getValor());
                    datos[j+1].setCategoria(auxiliarSt);
                    datos[j+1].setValor(auxiliarInt);
                }
            }
        }
    }

    public void seleccion(){

    }

    public void insercion(){

    }

    private Dato[] datos;
    private String ordenamiento;
    private String velocidad;
}
