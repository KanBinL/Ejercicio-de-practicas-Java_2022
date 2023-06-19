package Pila;

import Lista.*;

public class Pila_ListaT<T> {
    private ListaT<T> p;
    
    public Pila_ListaT() {
    	this.p = new ListaT();
    }
      
    public void push(T x) {
        p.add(x);
    }

    public T pop() {
        return p.eliminarPrimero();
    }
            
    public boolean esVacia() {
        return p.esVacia();
    }
    
    public T dameTop() {
        return p.valoInicial();
    }
}
