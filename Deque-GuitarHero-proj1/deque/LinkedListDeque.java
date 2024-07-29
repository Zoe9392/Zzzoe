package deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<T> implements Deque<T>, Iterable<T> {

    /** Follows in Double Sentinel Trend */
    private Node firstSentinel;
    private Node lastSentinel;
    private int size;
    /** The Node class for Double-Sentinel LinkedListDeque */
    public class Node {
        /** Each node has _prev and _next field to point at previous or next node.
            The middle field is for value representation.
         */
        private T val;
        private Node _prev;
        private Node _next;

        /** Constructor of Node class */
        public Node(Node prev,T value, Node next ) {
            this._prev = prev;
            this.val = value;
            this._next = next;
        }
    }

    /** An required empty LLD */
    public LinkedListDeque(){
        firstSentinel = new Node(null, null, null);
        lastSentinel = new Node(null, null ,null);
        /* Connections between the first placeholder and the last placeholder at initial stage */
        firstSentinel._next = lastSentinel;
        lastSentinel._prev = firstSentinel;
        size = 0;
    }

    /* Several Simple Methods */
    @Override
    public int size(){return size;}

    /* In Lecture 11, StringBuilder in Java  */
    @Override
    public void printDeque(){
        /* There are two different ways of toString() method in Lecture 11 */
        StringBuilder returnStr = new StringBuilder("");
        int index = 0;
        while (index < size()) {
            returnStr.append(get(index));
            returnStr.append(" ");
            index += 1;
        }
        System.out.print(returnStr + " \n");
    }

    @Override
    public void addFirst(T item){
        Node currNode = new Node (firstSentinel,item,null);
        if (size() == 0) {
            currNode._next = lastSentinel;
            firstSentinel._next = currNode;
            lastSentinel._prev = currNode;
        } else {
            currNode._next = firstSentinel._next;
            firstSentinel._next = currNode;
            currNode._next._prev = currNode;
        }
        size ++;
    }


    @Override
    public T removeFirst(){
         if (size() == 0) {
            return (T) null;
         }
        T removedItem = firstSentinel._next.val;
        firstSentinel._next = firstSentinel._next._next;
        firstSentinel._next._prev = firstSentinel;
        size --;
        return removedItem;
    }

    /* The 2nd method : add a Node at the last place */
    @Override
    public void addLast(T item) {
        Node currNode = new Node(null,item,lastSentinel);
        if (size() == 0) {
            currNode._prev = firstSentinel;
            firstSentinel._next = currNode;
            lastSentinel._prev = currNode;
        } else {
            currNode._prev = lastSentinel._prev;
            lastSentinel._prev._next = currNode;
            lastSentinel._prev = currNode;
        }
        size++;
    }

    @Override
    public T removeLast(){
        if (size() == 0) {
        return null;
        }
        T removedItem = lastSentinel._prev.val;
        lastSentinel._prev._next = lastSentinel;
        lastSentinel._prev = lastSentinel._prev._prev;
        size --;
        return removedItem;
    }

    /** Gets the i-th item in the linked list Deque in the iterative way */
    @Override
    public T get(int index){
        if (index > size() - 1) {
            return null;
        }
        if (size() == 0) {
            return null;
        }
        Node ptr = new Node (firstSentinel,firstSentinel._next.val,firstSentinel._next);
        while (index > 0) {
            ptr._next = ptr._next._next; // update the "next" field
            ptr.val = ptr._next.val; // update the value of Node ptr
            index--;
        }
        T resVal = ptr.val;
        return resVal;
    }

    /** Recursive way to get the i-th item */
    public T getRecursive(int index) {
        Node ptr = new Node(firstSentinel,null,firstSentinel._next);
        if(size() == 0) {
            return null;
        }
        return getRecHelper(index,ptr);
    }

    private T getRecHelper(int index, Node ptr) {
        if(index == 0) {
            ptr.val = ptr._next.val;
            return ptr.val;
        }
        return getRecHelper(index - 1,ptr._next);
    }
    /** Checks whether o is a LinkedListDeque; Checks whether o has same elements as "this
     *  LinkedListDeque" in same order. */
    @Override
    public boolean equals(Object o){
        boolean theSame = false;
        int index = 0;
        if(o instanceof LinkedListDeque<?>){
            if (((LinkedListDeque<?>) o).size() == this.size()){
                while (index < this.size()) {
                    if (((LinkedListDeque<?>) o).get(index) == this.get(index)){
                        theSame = true;
                    } else {
                        theSame = false;
                        // If there exists one element such that it is not consistent with the original
                        // one, that must not be equal and break to exit the while-loop
                        break;
                    }
                    index ++;
                }
            }
        }
        return theSame;
    }

    /** Iterator method is in Iterable interface */
    @Override
    public Iterator<T> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T>{
        private int currPos;
        public DequeIterator(){
            currPos = 0;
        }
        @Override
        public boolean hasNext(){
            if (size() == 0) {return false;}
            if (currPos > size() - 1) {
                return false;
            }
            return true;
        }
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T result = get(currPos);
            currPos += 1;
            return result;
        }
    }
}




