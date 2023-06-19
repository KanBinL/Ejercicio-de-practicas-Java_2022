package Lista;

import Nodo.*;

public class Lista_Fin {
    private Nodo inicial;
    private Nodo fin;
    
    public Lista_Fin(){
        this.inicial= this.fin = null;
    }
     
    public void add (int x) {
        Nodo nuevo = new Nodo(x);
         
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

    public void addFin(int x) {
        Nodo nuevo = new Nodo(x);

        if(inicial == null) {
            inicial = fin = nuevo;
        } else {
            fin.setEnlace(nuevo);
            fin = nuevo;
       }
    }

    public void borra(int x) {
        Nodo ant = null;
        Nodo aux = inicial;

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
    }

    public boolean esVacia() {
        return inicial == null;
    }

    public void imprimir() {
        Nodo aux = inicial;

        while(aux!=null){
            System.out.print(aux.getDato());
            aux = aux.getEnlace();
        }
        System.out.println();
    }

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

    public void reverse() {
        Nodo aux = inicial;
        inicial = null;
        fin = null;
        
        while(aux!=null) {
            this.add(aux.getDato());
            aux = aux.getEnlace();
        }
    }

    public void printRecursiva(Nodo x) {    
        if(x != null) {
            printRecursiva(x.getEnlace());
            System.out.println(x.getDato());
        }
    }

    public int eliminarPrimero() {
         if(!esVacia()) {
             int num = inicial.getDato();
             inicial = inicial.getEnlace();
             return num;
         }
         return -1;
    }
    
    public Nodo damePrimelo() {    
        return inicial;
    }
   
    public int valoInicial() {
        if(!esVacia()) {
            return inicial.getDato();
        }
        return -1;
    }
}
