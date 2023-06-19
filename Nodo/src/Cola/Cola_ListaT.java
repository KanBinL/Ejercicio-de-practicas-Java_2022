package Cola;

import Lista.*;

public class Cola_ListaT<T> {
    private Lista_FinT<T> c;
    
    public Cola_ListaT() {
        this.c = new Lista_FinT();
    }
      
    public void encolar(T x) {
        c.addFin(x);
    }

    public T desencolar(){
        return c.eliminarPrimero();
    }
            
    public boolean esVacia(){
        return c.esVacia();
    }
    
    public T dameFrente(){
        return c.valoInicial();
    }
    
    public void imprimir() {
        c.imprimir();
    }
}
