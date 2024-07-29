/**
 * Key Concepts(from Lecture 8):
 * 1)INTERFACE is a specification of what a List is able to do, not how to do it(without secret
 *      implementation details ). A list of all method signatures.
 * 2)HYPERNYMS  and HYPONYMS :
 *      List61B is a hypernyms of Alist and SLList. And SLList and Alist are hyponyms of List61B
 * 3)Use the key word IMPLEMENTS to tell Java compiler that SLList&Alist is a hyponyms of List61B
 * 4)   (i)OVERRIDING: If a "subclass" has a method with the exact same signatures as in the "superclass".
 *      subclass overriders the method. They have the same
 *      (ii) OVERLOADING: The methods with same name but different signatures are overloaded.
 * 5) Method Overriding :
 *      Use the @Override  in subclass ; if it won't override, it will not compile by java. Without @Override
 *      subclass still overrides the methods.
 * 6) INTERFACE INHERITANCE
 *      The subclass "inherits" the interface. It specifies what the subclass can do but not how to do it
 *      Subclasses MUST override all of these methods !
 *      Inheritance relationships can be multi-generational
 * 7) Copying the bits(in INTERFACE INHERITANCE):
 *      If X is a superclass of Y(for example, X is Dog and Y is Poodle), then memory boxes for X may contain Y
 *      List variables can hold AList addresses.
 * 8) IMPLEMENTATION INHERITANCE:
 *     Subclasses can inherit signatures and implementation. Example will be given in print() method below
 *     Use default before the signature
 * 9) Static Type and Dynamic Type
 *
 *
 */

public interface List61B<Item> {
    /** Inserts Item x to the back of the List */
    void addLast (Item x); // Be sure to use semicolons instead of brackets "{ }"
    /** Insets Item y at the front of the List */
    void addFirst (Item y);
    /** Returns the first item in the list */
    Item getFirst();
    /** Returns the last item in the list */
    Item getLast();
    /** Deletes the last item in the list and returns it */
    Item removeLast();
    /** Returns the item at index pos */
    Item get (int pos);
    /** Inserts the item at index pos in the list */
    void insert(Item X, int pos);
    /** Returns the size of the whole list */
    int size();
    /** Prints each element in the list */
    default void print() {
        for(int i = 0; i < size(); i++){
            System.out.print(get(i) + "");
        }
        System.out.println();
    }
    // efficient for AList and inefficient for SLList
}