package Pila;

import Nodo.*;

public class PilaT<T> {
    private NodoT<T>  top;

	public PilaT() {
        this.top=null;
    }

    public boolean esVacia() {
    	if (top == null) {
            return true;
        }
        return false;
    }

    public void push (T x) {
    	NodoT<T> nuevo = new NodoT(x);

        if(esVacia()) {
            top = nuevo;
        } else {
            nuevo.setEnlace(top);
            top = nuevo;
        }
    }

    public T pop() {
        if(!esVacia()) {
            T num = top.getDato();
            top = top.getEnlace();
            return num;
        }
        return null;
    }

    public T dameTop() {
        if(!esVacia()) {
        	return top.getDato();
        }
        return null;
    }
    
    public void imprimir(){	
        if(!esVacia()) {
            NodoT<T> aux = top;

            while(aux!=null){
                System.out.print(aux.getDato());
                aux = aux.getEnlace();
            }
            System.out.println();
        }
    }
}
