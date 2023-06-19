package Lista;

import Nodo.*;

public class Lista_FinT<T> {
    private NodoT<T> inicial;
    private NodoT<T> fin;
    
    public Lista_FinT(){
        this.inicial= this.fin = null;
    }
     
    public void add (T x) {
    	NodoT<T> nuevo = new NodoT<T>(x);
         
        if (inicial == null) {
            inicial = fin = nuevo;
            /*
            inicial = nuevo;
            fin = inicial;*/
        } else {
            nuevo.setEnlace(inicial);
            inicial = nuevo;
        }
     }

    public void addFin(T x) {
    	NodoT<T> nuevo = new NodoT<T>(x);

        if(inicial == null) {
            inicial = fin = nuevo;
        } else {
            fin.setEnlace(nuevo);
            fin = nuevo;
       }
    }

    public boolean borra(T x) {
    	NodoT<T> ant = null;
    	NodoT<T> aux = inicial;

        while(aux!=null) {
            if(x == aux.getDato()) {
                if(this.fin == this.inicial) {
                    inicial = fin = null;
                } else {
                    if(aux == inicial) {
                        inicial = aux.getEnlace();
                        aux.setEnlace(null);
                        aux = inicial;
                    } else {
                        if(aux == fin) {
                            fin =ant;
                       } 
                        ant.setEnlace(aux.getEnlace());
                        aux.setEnlace(null);
                        aux = aux.getEnlace();
                    }
                }
            } else {
                ant = aux;
                aux = aux.getEnlace();
            }
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
        fin = null;
        
        while(aux!=null) {
            this.add(aux.getDato());
            aux = aux.getEnlace();
        }
    }

    public void printRecursiva(NodoT<T> x) {    
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
