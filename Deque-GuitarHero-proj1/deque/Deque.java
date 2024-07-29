package deque;
import java.util.Iterator;

/** Deque Interface */
public interface Deque<T> {
    /** Adds an item in front of the deque */
    void addFirst(T item);
    /** Adds an item to the back of the deque*/
    void addLast(T item);
    /** Returns true if the deque is empty */
    default boolean isEmpty(){ return size() == 0;}
    /** Returns the number of items in the deque */
    int size();
    /** Prints the items in the deque from first to last, separated by a space.
        Once all the items have been printed, print out a new line */
    void printDeque();
    /** Removes and returns the item at the front of the deque.
        If no such item exists, returns null. */
    T removeFirst();
    /** Removes and returns the last-indexed item at the back of the deque.
        If no such item exists, returns null. */
    T removeLast();
    /** Gets the item at the given index, where 0 is the front, 1 is the next, and so on */
    T get(int index);
    /** The deque objects we will make are iterable */
    Iterator<T> iterator();
    /** Returns whether the parameter o is equal to the deque. */
    boolean equals(Object o);
}

    

