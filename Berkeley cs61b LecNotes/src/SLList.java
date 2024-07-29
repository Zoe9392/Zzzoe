/**
 * IntList & SLList: Avoid "naked recursion" via IntList
 * The speed of SLList is SLOW ! How to SPEED UP ?
 * IntList -> SLList; IntNode -> Sentinel Node
 * */

/* The Generic List part; if the IntNode was declared, the data type int can not be modified */
/* Initialize it once at the top */
public class SLList<Item> /* implements List61B<T> */{
    // The content in the angle brace here is a placeholder
    /* Change the "public" instance variable into private
    * ?: access control;
    * Potential problem: Infinite loop --- the "next" part points back to itself
    */
    private int size;
    /* Sentinel node works as a placeholder. It will never be modified */
    // private IntNode first;
    private IntNode sentinel;

    /* Creates an empty SLList */
    public SLList(){
        sentinel = new IntNode(100,null);// place holder
        size = 0;
    }
    /* The constructor */
    public SLList(int x){
        sentinel = new IntNode(100,null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }
    /* Changes: IntNode --> StuffNode */
    private /* static */ class StuffNode {
        // make it be private and static
        public Item item;
        public StuffNode next;
        public StuffNode(Item i, StuffNode n ) {
            item = i;
            next = n;
        }
    }
    /* Adds x into the front of SLList */
    public void addFirst(int y){
        sentinel.next = new IntNode(y,sentinel.next); size += 1;
    }

    /* Remove the first item or number of SLList */
    public int gerFirst(){
        return sentinel.next.item;
    }


    /* Adds x into the last node/item of SLList */
    public void addLast(int x) {
        // edge case: the empty SLList instantiated
        /* Special case is no more needed
        if (sentinel.next == null) {

            sentinel.next = new IntNode(x,null);
            return;
        } */
        IntNode p = sentinel.next;
        // Use the iterative way to find the last node of it
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x,null);
        size += 1;
    }
    /* Returns the size of SLList */
    public int size() {
        // SLList doesn't have recursive data structure.
        // If we would like to use the recursive way, the helper function works
        // It speaks the language of the model

        //return sizeHelper(first);
        return size;
    }
    /* Returns the size if list which starts at p */
    /* private static int sizeHelper(IntNode p){
        if (p.next == null) {
            return 1;
        }
        return 1 + sizeHelper(p.next);
    } */
/*
   @Override
    public Item removeLast() {
        Item X = get(size() - 1);
        IntNode p = sentinel.next;
        while (p != null) {
            if (p.next == null) {
                p = null;
            }
            p = p.next;
        }
        size -= 1;
        return X;
    }


    public Item removeFirst() {
        Item X = getFirst();
        sentinel.next = sentinel.next.next;
        size -= 1;
        return X;
    }

    public static void main(String[] args){

    }

 */
}
/**
 * Way 1: Access Restriction:
 * a) Hide implementation details from users of the class
 * b) Users don't know it
 * Way 2: Nested Classes or Static Nested Classes
 * a) A class is useful and doesn't stand it on its own
 * b) If "IntNode" class never uses "SLList", can put "IntNode" to be static
 *
 * Question in SIZE ?
 * How to make it be efficient of using SIZE method above ? How to improve execution time?
 * Change a way to write the method? NO! The answer is to track the size(i.e., functionality -> attributes)
 * --Caching --- solve the SIZE problem;
 * --Special cases are "ugly", for as data structures are more complex; need "one consistent story"
 * --Invariants of coding
 * */
