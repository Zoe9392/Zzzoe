import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

/** Skeletons of ArraySet with functionality */
public class ArraySet<T> implements Iterable<T> {
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
    /**  Returns an iterator into ME: The return type is an Iterator. And the name of the method
     *
     */
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }
    private class ArraySetIterator implements Iterator<T> {
        /* This Iterator class needs constructor and instance variables */
        private int wizPos;

        public ArraySetIterator() {
            wizPos = 0;
        }

        public boolean hasNext() {
            if (wizPos < items.length - 1 ) {
                return true;
            }
            return false;
        }

        public T next() {
            T currItem = items[wizPos];
            wizPos ++;
            return currItem;
        }

    }

    public String toString() {
        String returnString = "{";
        for (int i = 0; i < size() - 1; i++) {
            returnString += items[i].toString();
            returnString += ", ";
        }
        returnString += items[size() - 1]; // Strings are immutable
        returnString += "}";
        return returnString;
    }
    /** A python-like way to do build a string */
    public String toString2(){
        StringBuilder returnStr = new StringBuilder ("{");
        for(int i = 0; i < size() - 1; i ++){
            returnStr.append(items[i].toString());
            returnStr.append(",");
        }
        returnStr.append(items[size() - 1]);
        returnStr.append("}");
        return returnStr.toString();

    }


    public static void main(String[] args) {
        ArraySet<String> S = new ArraySet<>();
        S.add("Aleksandra");
        S.add(null); // Java code will crash ?

        Set<String> S2 = new HashSet<>();
        S2.add(null);
        System.out.println(S2.contains(null));

        /** Iterable Stuff: seen as enhanced for-loop?  */
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
   Exception
        e.g.: add(T) method above

   Iterable
        e.g.: would like to iterate all
        iteration function: the enhanced for-loop  ----->  Iterator

   Iterable(a java built-in interface): should be declared to tell java that this class has an iterator method otherwise java
        does not know that there is an iterator method

   Set | Collection | Iterable

   Objects and toString() (note: "memory location")

   String Builder

 */
