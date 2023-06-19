package Pila;

import Lista.*;

public class Pila_Lista {
    private Lista p;
    
    public Pila_Lista() {
    	this.p = new Lista();
    }
      
    public void push(int x) {
        p.add(x);
    }

    public int pop() {
        return p.eliminarPrimero();
    }
            
    public boolean esVacia() {
        return p.esVacia();
    }
    
    public int dameTop() {
        return p.valoInicial();
    }
}
