package GSORT;

public class Dato {
    private String categoria;
    private int valor;

    public Dato (String categoria, int valor) {
        this.categoria = categoria;
        this.valor = valor;
    }

    public Dato (String categoria, String valor) {
        this.categoria = categoria;
        this.valor = Integer.parseInt(valor);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
