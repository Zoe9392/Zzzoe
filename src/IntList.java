/** From lec4; IntList is a type of data structure from CS61A;
 *  inconveniences in this structure ?
 *  IntList -> SLList -> DLList
 * */
// Initial/Naive Version of it
public class IntList {
    public int first;
    public IntList rest;
    // The ways to improve this structure : build a constructor for the IntList
    public IntList (int f, IntList r){
        first = f;
        rest = r;
    // "naked" linked list with recursive structure
    }
    // Next: how to know the numbers of nodes in this structure ?  create a size method?
    // How ? iteratively? recursively? It is accessed by instance variable
    /** The method to count the nodes/length of the IntList
     * Note: there are no parameters passing in the method
     * RECURSIVE WAY */
    public int sizeRe() {
        if ( rest == null ){
            return 1;
        }
        // Josh Hug's method in
        return 1 + this.rest.sizeRe(); // "this" in java is equivalent to "self" in python
    }
    /** Count the size/length of the IntList; ITERATIVE WAY  */
    public int sizeIt(){
        int size = 0;
        IntList L = this;
        while(L != null){
            size +=1;
            L = L.rest;
        }
        return size;
    }
    /** The method is for indexing the IntList ( Josh Hug's method )*/
    public int get(int index) {
        if(index == 0) {
            return first;
        }
        return rest.get(index - 1);
    }

    /** Exercise 1: to increase each node value by x creating a brand new IntList */
    public static IntList incrList(IntList L, int y) {
        int size = L.sizeIt();
        int count = 1;
        IntList p = new IntList(L.first + y, null);
        while( count < size ) {
            p.rest = new IntList(L.get(count) + y, null);
            count += 1;
        }
        return p;
    }

    /** Exercise 2: to decrease each node value by x without creating a new IntList */
    // implement it in the iterative way
    public static IntList decrList(IntList L, int x) {
        IntList P = L;
        while( P != null) {
            P.first -= x;
            P = P.rest;
        }
        return L;
    }

    /** ExamPrep03 (2017 Spring MT1) --- skippify(); If IntList A = IntList.list(1,2,3,4,5,6,7,8); it will
     * modify the array into, in the form of list in python, [1,3,6]
     * */
    public void skippify() {
        IntList p = this;
        int n = 1;
        while ( p != null) {
            IntList next = p.rest;
            for (int i = 0; i < n; i++){ // iterate to locate the correct node
                // edge case
                if( next == null){
                    break; // break means the exit of
                }
                next = next.rest;
            }
            n ++; // the numbers of jumps of nodes
            p.rest = next; // connect
            p = p.rest;
        }





    }


    public static void main(String[] args) {
        IntList L = new IntList(5,null);
        L = new IntList(10,L);
        L = new IntList(15,L);

        /**
         The codes below are very hard to use
         IntList L = new IntList();
         L.first = 10;
         L.rest = null;
         L.rest = new IntList();
         L.rest.first = 5;
         L.rest.rest = new IntList();
         L.rest.rest.first = 15; */
    }

}
