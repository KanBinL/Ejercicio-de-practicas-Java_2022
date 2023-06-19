package Nodo;

public class Nodo {
    private Nodo enlace;
    private int dato;

    public Nodo() {
        this.enlace = null;
        this.dato = 0;
    }

    public Nodo(int p_dato) {
        this.enlace = null;
        this.dato = p_dato;
    }

     public Nodo(Nodo p_nodo, int p_dato) {
        this.enlace = p_nodo;
        this.dato = p_dato;
    }

     public Nodo getEnlace () {
        return this.enlace;
    }

     public int getDato () {
        return this.dato;
    }

    public void setEnlace (Nodo enlace) {
        this.enlace = enlace;
    }

    public void setDato (int dato) {
        this.dato= dato;
    }
}