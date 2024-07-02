/**
 * VengefulList has one more functionality: the deleted items in the list are collected and
 *      can be printed
 * Some Notes: "is-a" relationship and "has-a" relationship
 */

public class VengefulList<Item> extends SLList<Item> {

    /* private access restricted to use details inside */
    private SLList<Item> deletedItems;
    /* Needs a constructor for */
    public VengefulList() {
        super(); // it will call the default one
        deletedItems = new SLList<Item>();
    } // Compiler Error without the new constructor
    /* Note the private access control ; and the use of calling super class */
    @Override
    public Item removeLast() {
        Item X = super.removeLast();
        deletedItems.addFirst(X);
        return X;
    }

    @Override
    public Item removeFirst() {
        Item Y = super.removeFirst();
        deletedItems.addFirst(Y);
        return Y;
    }

    /** Prints the deleted items */
    public void printLostItems() {
        deletedItems.print();
    }

    public static void main (String[] args) {

    }


}
