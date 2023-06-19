package Lista;

import Nodo.*;

public class Lista {
    private Nodo inicial; //Inicial

    public Lista() {
        this.inicial=null;
    }

    //Añadir datos
    public void add (int x) {
        Nodo nuevo = new Nodo(x);
        
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

    //Borra datos
    public void borra(int x) {
        Nodo ant = null;
        Nodo aux = inicial;

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
    }
    
    //Verificar si es vacio
    public boolean esVacia() {
        return inicial == null;
    }
    
    //Imprimir datos
    public void imprimir() {
        Nodo aux = inicial;

        while(aux!=null){
            System.out.print(aux.getDato());
            aux = aux.getEnlace();
        }
        System.out.println();
    }

    //Buscar datos
    public boolean buscar(int x) {
        Nodo aux = inicial;

        while(aux!=null) {
            if(aux.getDato() == x) {
                return true;
            }
        aux = aux.getEnlace();
        }
        return false;
    }

    //Cuenta cuantos null hay
    public int cuentaNull(int x) {    
        Nodo aux = inicial;
        int num = 0;

        while(aux!=null) {
            if(aux.getDato() == x) {
                num++;
            }
            aux = aux.getEnlace();
        }
        return num;
    }

    //Ponerlo arrevez
    public void reverse() {    
        Nodo aux = inicial;
        inicial = null;
        
        while(aux!=null) {
            this.add(aux.getDato());
            aux = aux.getEnlace();
        }
    }

    //Imprimirlo en recursiva
    public void printRecursiva(Nodo x) {    
        if(x != null) {
            printRecursiva(x.getEnlace());
            System.out.println(x.getDato());
        }
    }

    //Eliminar el primero
    public int eliminarPrimero() {
         if(!esVacia()) {
             int num = inicial.getDato();
             inicial = inicial.getEnlace();
             return num;
         }
         return -1;
    }

    //Pedir nodo primero
    public Nodo damePrimelo() {    
        return inicial;
    }
   
    //Pedir valo incial
    public int valoInicial() {
        if(!esVacia()) {
            return inicial.getDato();
        }
        return -1;
    }
}
