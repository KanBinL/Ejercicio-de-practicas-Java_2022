package Cola;

import Lista.*;

public class Cola_Lista {
    private Lista_Fin c;
    
    public Cola_Lista()
    {
        this.c = new Lista_Fin();
    }
      
    public void encolar(int x)
    {
        c.addFin(x);
    }

    public int desencolar(){
        return c.eliminarPrimero();
    }
            
    public boolean esVacia(){
        return c.esVacia();
    }
    
    public int dameFrente(){
        return c.valoInicial();
    }
    
    public void imprimir() {
        c.imprimir();
    }
}
