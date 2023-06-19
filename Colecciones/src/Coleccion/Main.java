package Coleccion;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        TreeMap words = new TreeMap();
        
        String delim = " \t\n.,:;?!-/()[]\"\'";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line, word;
        Count count;
        try {
            while (!(line=in.readLine()).equals("fin")) {
                StringTokenizer st = new StringTokenizer(line, delim);
                while (st.hasMoreTokens()){
                    word = st.nextToken().toLowerCase();
                    count = (Count)words.get(word);
                    if(count == null){
                        words.put(word, new Count("word", 1));
                    } else {
                        count.i++;
                    }
                }
            }
        } catch (IOException e){}
        
        List list = new ArrayList (words.values()); 
        Collections.sort (list, new CountComparator());
        Iterator iter;
        iter = list.iterator();
        while (iter.hasNext()){ 
            count = (Count) iter.next(); 
            word = count.word; 
            System.out.println(word + (word.length() < 8 ? "\t\t" : "\t") + count.i);
        }

        /* Ejercicio 2 Contar repetidos
        HashMap words = new HashMap();
        String delim = " \t\n.,:;?!-/()[]\"\'";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line, word;
        Count count;
        try {
            while (!(line=in.readLine()).equals("fin")) {
                StringTokenizer st = new StringTokenizer(line, delim);
                while (st.hasMoreTokens()){
                    word = st.nextToken().toLowerCase();
                    count = (Count)words.get(word);
                    if(count == null){
                        words.put(word, new Count(word, 1));
                    } else {
                        count.i++;
                    }
                }
            }
        } catch (IOException e){}
        
        Set set = words.entrySet();
        Iterator iter = set.iterator();
        while (iter.hasNext()){
            Map.Entry entry = (Map.Entry) iter.next();
            word = (String)entry.getKey();
            count = (Count)entry.getValue();
            System.out.println(word + (word.length() < 8 ? "\t\t" : "\t") + count.i);
        }
        */
        
        /*Ejercicio 1 Escribir y contalar las palablas
        HashSet words = new HashSet();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String delim = " \t\n.,:;?!-/()[]\"\'";
        String line;
        int count = 0;
        try {
            while (!(line=in.readLine()).equals("fin")) {
                StringTokenizer st = new StringTokenizer(line, delim);
                while (st.hasMoreTokens()){
                    count++;
                    words.add(st.nextToken().toLowerCase());
                }
            }
        } catch (IOException e){}
        
        System.out.println("Numero total de palabras: " + count);
        System.out.println("Numero de palabras diferentes: " + words.size());
        */

    }
}
