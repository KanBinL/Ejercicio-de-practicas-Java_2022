package Lista;

import Nodo.*;

public class ListaT<T> {
    private NodoT<T> inicial;

    public ListaT() {
        this.inicial=null;
    }

    public void add (T x) {
    	NodoT<T> nuevo = new NodoT<T>(x);
        nuevo.setEnlace(inicial);
        inicial = nuevo;
        /*
        if(esVacia()){
           inicial = nuevo;
        } else { 
            nuevo.setEnlace(inicial);
            inicial = nuevo;
        } */
    }

    public boolean borra(T x) {
    	NodoT<T> ant = null;
    	NodoT<T> aux = inicial;

        while(aux!=null) {
            if(x == aux.getDato()) {
                if(aux == inicial){
                    inicial = inicial.getEnlace();
                    aux.setEnlace(null);
                    aux = inicial;
                } else {
                    ant.setEnlace(aux.getEnlace());
                    aux.setEnlace(null);
                    aux = ant;
                }
            }
            ant = aux;
            aux = aux.getEnlace();
        }
        return true; 
    }
    
    public boolean esVacia() {
        return inicial == null;
    }

    public void imprimir() {
    	NodoT<T> aux = inicial;

        while(aux!=null){
            System.out.print(aux.getDato());
            aux = aux.getEnlace();
        }
        System.out.println();
    }

    public boolean buscar(T x) {
    	NodoT<T> aux = inicial;

        while(aux!=null) {
            if(aux.getDato() == x) {
                return true;
            }
        aux = aux.getEnlace();
        }
        return false;
    }

    public int cuentaNull(T x) {    
    	NodoT<T> aux = inicial;
        int num = 0;

        while(aux!=null) {
            if(aux.getDato() == x) {
                num++;
            }
            aux = aux.getEnlace();
        }
        return num;
    }

    public void reverse() {    
    	NodoT<T> aux = inicial;
        inicial = null;
        
        while(aux!=null) {
            this.add(aux.getDato());
            aux = aux.getEnlace();
        }
    }

    public void printRecursiva(Nodo x) {    
        if(x != null) {
            this.printRecursiva(x.getEnlace());
            System.out.println(x.getDato());
        }
    }

    public T eliminarPrimero() {
         if(!esVacia()) {
             T num = inicial.getDato();
             inicial = inicial.getEnlace();
             return num;
         }
         return null;
    }

    public NodoT<T> damePrimelo() {    
        return inicial;
    }
   
    public T valoInicial() {
        if(!esVacia()) {
            return inicial.getDato();
        }
        return null;
    }
}
