package Cola;

import Nodo.*;

public class ColaT<T> {
    private NodoT<T> frente;    //Inicial
    private NodoT<T> ultimo;    //Final
    
    public ColaT() {
        frente = ultimo = null;
    }

    public boolean esVacia() {
    	return frente == null;
    }

    public void encolar(T x) {
    	NodoT<T> nuevo = new NodoT<T>(x);

    	if(esVacia()) {
            frente = ultimo = nuevo;
    	} else {
            ultimo.setEnlace(nuevo);
            ultimo = nuevo;
        }
    }

    public T desencolar() {
        T num = frente.getDato();

    	if(!esVacia()) {
            if(frente == ultimo) {   
                ultimo = null;    
            }
            frente = frente.getEnlace();
            return num;  
        }
        return null;
    }

    public T dameFrente() {
    	if(!esVacia()) {
            return frente.getDato();
        }
        return null;
    }
}
