

public class Asymptotics {
    /** Theta(logN) --- Returns the array index of goal item in a sorted array
     *  The recursive method of implementing Binary Search
     */
    static int BinarySearch(String[] sorted,String goal, int low, int high) {
        if (low > high) {
            return -1;
        }
        int m = (high + low) / 2;
        int cmp = goal.compareTo(sorted[m]); // compare goal to the middle value to find the relative position
        if (cmp < 0) { // less than middle value
            return BinarySearch(sorted, goal, low, m - 1);
        } else if (cmp > 0) { // greater than middle value
            return BinarySearch(sorted, goal, m + 1, high);
        } else {
            return m;
        }
    }
    /** Selection Sort V.S. Merge Sort ; selection sort : Theta(N^2) , merge sort: theta(NlogN) in total
     * and each layer takes theta(N) times and there are logN layers in total.
     */



}
