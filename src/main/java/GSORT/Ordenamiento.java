package GSORT;

public class Ordenamiento {
    public Ordenamiento(Inicio unMenu, Dato[] unosDatos){
        menu = new Inicio();
        datos = new Dato[unosDatos.length];

        this.menu = unMenu;
        for(int i = 0;i<unosDatos.length;i++){
            this.datos[i] = unosDatos[i];
        }
    }



    private Inicio menu;
    private Dato[] datos;
}
