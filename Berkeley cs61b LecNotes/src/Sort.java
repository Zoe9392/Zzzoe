/** Lecture3 problem: Selection Sort (1st algorithm in class) T
 *  Randomly give an array of integers : [6,2,1,3,7,8,4]
 *  "Selection sort" makes the array above become: [1,2,3,4,6,7,8]
 *  Three Steps to do it: 1) Find the smallest number in the unsorted part 2) Move the smallest into the
 *                     front 3) selection sort the remaining
 * */

public class Sort {
    public static void sort(String[] s ){
        sortHelper(s,0);
        // python way: sort([1:]) doesn't work
        // a reference for cs61a, set a parameter to recursively call the function
    }
    // Step 1: it depends on the first letter of the word, alphabetically
    /** Step 1: It returns the index of "smallest" string. e.g.:  "apple" is smaller than "banana" */
    // the initial version is findSmallest( Sring[] x )
    public static int findSmallest(String[] x, int k){
        int currSmallest = k;
        for(int i = k; i < x.length; i++ ) {
            // how to compare the first letter of the word? Google it on StackOver flow(lexicographically?)
            int cmpResult = x[i].compareTo(x[currSmallest]);
            // String.compareTo(another String)
            if(cmpResult < 0){
                currSmallest = i;
            }
        }
        return currSmallest;
    }
    /** Step 2: Move the smallest item to front */
    public static void swap (String[] input, int a, int b){ // swap two strings by figuring out the index
        String temp = input[a];
        input[b] = input[a];
        input[a] = temp;
    }

    /** Step 3: the suggestion in the slide: destructively sort --- in-place sorts , starting at index k */
    public static void sortHelper(String[] x, int k) {
        if(k == x.length){
            return;
        }
        int smallest = findSmallest(x, k); // adjust in digits 
        swap(x,smallest, 0);
        sortHelper(x, k + 1);
    }

}
