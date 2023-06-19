package Interador;

import Lista.*;
import Nodo.*;

public class Interador {
    private Lista l;
    private Nodo act;

    public Interador(Lista l) {
        this.l = l;
        this.act = l.damePrimelo();
    }
    
    public Nodo next() {
        act = act.getEnlace();
        return act;
    }

    public int getValor() {
        return act.getDato();
    }
    
    public void setValor(int x) {
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
    
    public void porTres() {
        while(!hasNext()) {
            int num = act.getDato();
            act.setDato(num * 3);
            System.out.println(act.getDato());
            act = next();
        }
    }
}
