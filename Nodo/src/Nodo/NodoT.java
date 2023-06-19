package Nodo;

public class NodoT<T> {
    private NodoT<T> enlace;
    private T dato;

    public NodoT() {
        this.enlace = null;
        this.dato = null;
    }

    public NodoT(T p_dato) {
        this.enlace = null;
        this.dato = p_dato;
    }

     public NodoT(NodoT<T> p_nodo, T p_dato) {
        this.enlace = p_nodo;
        this.dato = p_dato;
    }

     public NodoT getEnlace () {
        return this.enlace;
    }

     public T getDato () {
        return this.dato;
    }

    public void setEnlace (NodoT<T> enlace) {
        this.enlace = enlace;
    }

    public void setDato (T dato) {
        this.dato= dato;
    }
}
