package Nodo;

import Lista.*;
import Pila.*;
import Cola.*;
import Interador.*;

public class Main {
    public static void main(String[] args) {
        
        
        /*Comprobar NodoT
        Contacto c1 = new Contacto("1",10);
        Contacto c2 = new Contacto("2",20);  
        
        NodoT<Contacto> n1 = new NodoT(c1);
        NodoT<Contacto> n2 = new NodoT(c2);
        
        PilaT<Contacto> pl = new PilaT();
        pl.push(c1);
        pl.push(c2);*/
        
        
    }
    //Juntar y ordenar dos listas
    public Lista fusionar(Lista l1,Lista l2){
        Lista or = new Lista();
        Interador or1 =new Interador(l1);
        Interador or2 =new Interador(l2);
        
        while(or1.hasNext() || or2.hasNext()){
            if(!or1.hasNext()){
                or.add(or2.getValor());
                or2.next();
            } else if (!or2.hasNext()){
                or.add(or1.getValor());
                or1.next();
            } else {
                if(or1.getValor() > or2.getValor()){
                    or.add(or2.getValor());
                    or2.next();
                } else {
                    or.add(or1.getValor());
                    or1.next();
                }
            }
        }
        or.reverse();
        return or;
    }
}