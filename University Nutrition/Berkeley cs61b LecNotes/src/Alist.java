/**
 * Lecture6: The (Naive) Array List
   Improved from SLList | for example, to make things faster. change a data structure to improve
        i.e., randomly access/get what "users" want ; this is shown by index; To Be Ultra Fast
        ? the speed is too slow ---> "Optimize" the data structure
   Further Considerations:
        ? what if the content in the array is full ---> Resizing
        ? space usage:  # of boxes created for resizing
                        save memory, do not loiter
        ? runtime analysis:
  */

public class Alist <Item> implements List61B<Item>{
    /** instance variables of Alist */
    int size;
    /* Assume generic data type is integer; The generic type is Item */
    Object[] items;

    /** Alist constructor: creates an empty list */
    public Alist(){
        items = (Item[]) new Object[100]; // initial container & casting type
        size = 0;
    }
    /** Resizing the items */
    public void resize(int capacity) {
        // Note the resizing: size + refactor X ---> size * refactor ;
        // Memory Efficiency: resizing boundaries
        Object[] a  = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }

    /** Inserts int x to the back of the list */
    public void addLast(Item x) {
        /* instead of manually resizing the array at each step */
        items[size] = x;
        size++;
    }

    @Override
    public void addFirst(Item y) {
        // inserts item y into the 0-indexed box in the array
        // System.arraycopy can copy arrays to itself
        System.arraycopy(items,0,items,1,size());
        items[0] = y;
        size++;
    }

    @Override
    public Item getFirst() {
        return (Item) items[0];
    }

    /** Get the last item of the list */
    public Item getLast(){
        return (Item)items[size - 1];
    }
    /** Get the item at position index */
    public Item get(int index){
        return (Item) items[index];
    }

    @Override
    public void insert(Item X, int position) {
        System.arraycopy(items,position, items, position + 1, size - position - 1);
        items[position] = X;
        size++;
    }

    /** Returns the number of items in the list */
    public int size(){
        return size;
    }
    /** Removes the last item in the list */
    public Item removeLast(){
        Item x = getLast();
        size--;
        // items[size] = 0; // It is unnecessary to delete it. As long as the pointer moves ahead
        //Nulling out deleted objects
        items[size - 1] = null;
        return x;

    }
}
