import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/** Skeletons of ArraySet with functionality */
public class ArraySet<T> {
    private T[] items;
    private int size;
    /* Constructor of ArraySet */
    public ArraySet() {
        items = (T[]) new Object[100]; // cast type Object to T
        size = 0;
    }
    /* Checks whether x is in the ArraySet */
    public boolean contains(T x) {
        for (int i = 0; i<items.length; i ++) {
            if ( x == items[i] ){ // x.equals() --- compares memory box address
                return true;
            }
        }
        return false;
    }

    /*  Associates the specified value with the specified key in this map.
        Throws an IllegalArgumentException if the key is null
        Needs more illustration:
    */
    public void add (T x) {
        if (x == null) {
            throw new IllegalArgumentException("You can not add null to an ArraySet");
        }
        if (contains(x)){
            return;
        }
    }
    /* Returns the number of elements in this ArraySet */
    public int size() {
        return 0;
    }
    /*  Returns an iterator into ME: The return type is an Iterator. And the name of the method
     *   
     */
    public Iterator<T> iterator() {

    }



    public static void main(String[] args) {
        ArraySet<String> S = new ArraySet<>();
        S.add("Aleksandra");
        S.add(null); // Java code will crash ?

        Set<String> S2 = new HashSet<>();
        S2.add(null);
        System.out.println(S2.contains(null));

        /** Iterable Stuff */
        Set<Integer> javaSet = new HashSet<>();
        javaSet.add(1);
        javaSet.add(4);
        Iterator<Integer> seer = javaSet.iterator();
        while(seer.hasNext()) {
            System.out.println(seer.next());
        }

    }

}
/**
 * Exception
 *      e.g.: add(T) method above
 *
 * Iterable
 *      e.g.: would like to iterate all
 *      iteration function: the enhanced for-loop  ----->  Iterator
 *
 * toString
 *
 */
