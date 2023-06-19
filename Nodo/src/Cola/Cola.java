package Cola;

import Nodo.*;

public class Cola {
    private Nodo frente; //Inicio
    private Nodo ultimo; //Final
    
    public Cola() {
        frente = ultimo = null;
    }

    public boolean esVacia() {
        return frente == null;
    }

    //Meter datos
    public void encolar(int x) {
    	Nodo nuevo = new Nodo(x);

    	if(esVacia()) {
    		frente = ultimo = nuevo;
    	} else {
    		ultimo.setEnlace(nuevo);
    		ultimo = nuevo;
        }
    }

    //Borra datos
    public int desencolar() {
        int num = frente.getDato();

    	if(!esVacia()) {
            if(frente == ultimo) {   
                ultimo = null;    
            }
            frente = frente.getEnlace();
            return num;  
        }
        return -1;
    }
            
    //Dar primero
    public int dameFrente() {
        if(!esVacia()) {
            return frente.getDato();
        }
        return -1;
    }
    
}
