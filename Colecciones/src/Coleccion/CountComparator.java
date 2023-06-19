package Coleccion;

import java.util.Comparator;

public class CountComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        if(o1 != null && o2 != null && 
                o1 instanceof Count && o2 instanceof Count){
            Count c1 = (Count) o1;
            Count c2 = (Count) o2;
            return (c2.i - c1.i);
        } else {
            return 0;
        }
    }
}
