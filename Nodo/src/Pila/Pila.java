package Pila;

import Nodo.*;

public class Pila {
    private Nodo top;

	public Pila() {
        this.top=null;
    }

    public boolean esVacia() {
        return top == null;
    }

    //Añadir elementos
    public void push (int x) {
        Nodo nuevo = new Nodo(x);

        if(esVacia()) {
            top = nuevo;
        } else {
            nuevo.setEnlace(top);
            top = nuevo;
        }
    }

    public int pop() {
        if(!esVacia()) {
            int num = top.getDato();
            top = top.getEnlace();
            return num;
        }
        return -1;
    }

    public int dameTop() {
        if(!esVacia()) {
            return top.getDato();
        }
        return -1;
    }
    
    public void imprimir(){	
        if(!esVacia()) {
            Nodo aux = top;

            while(aux!=null){
                System.out.print(aux.getDato());
                aux = aux.getEnlace();
            }
            System.out.println();
        }
    }
    
}
