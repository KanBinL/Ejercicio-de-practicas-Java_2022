package Interador;

import Nodo.*;
import Lista.*;

public class InteradorT<T> {
	private ListaT<T> l;
    private NodoT<T> act;

    public InteradorT(ListaT<T> l) {
        this.l = l;
        this.act = l.damePrimelo();
    }
    
    public NodoT next() {
        act = act.getEnlace();
        return act;
    }

    public T getValor() {
        return act.getDato();
    }
    
    public void setValor(T x) {
        act.setDato(x);
    }
    
    public void inicializar() {
        act = l.damePrimelo();
    }
    
    public boolean hasNext() {
        if(act == null) {
            return true;
        }
        return false;
    }
}
