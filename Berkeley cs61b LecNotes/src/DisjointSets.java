/** */

public interface DisjointSets {

    void connect(int p, int q);

    boolean isConnected(int p, int q);

}
/**
 *  Implementations of the interface above
 *  ---> Disjoint Set
 *  Naive Approach: Record every single connecting line in some data structure
 *
 *  Better Approach: Model connectedness in terms of sets.
 *  ---> Quick Find
 *
 *  Problem: Pick right data structure to support tracking of sets
 *       for example: List<Set<Integer>>,  Map<Integer, Integer> (first integer is the number itself,
 *        the second number represents the set they are in)
 *        Analysis: 1. List<Set<Integer>> requires to iterate through all elements when implementing
 *        " isConnected " method. Theta(N) in isConnected.
 *                  2. Map<Integer,Integer>
 *
 * */