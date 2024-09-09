
public class QuickFindDS implements DisjointSets{
    private int[]id;

    public QuickFindDS (int N){
        for (int i = 0; i < N; i ++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void connect (int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int j = 0; j < id.length; j++) {
            if (pid >= qid){
                if (id[j] == qid ){
                    id[j] = pid;
                }
            } else {
                if (id[j] == qid){
                    id[j] = qid;
                }
            }
        }
    }
}

/** Goal: Improve "connect(int p , int q)" in Quick Find ---> Quick Union
 *  Answer: use tree structure
 *   {0,1,2,4}, {3,5}, {6}
 *   parent: [-1,0,1,0,-1,3,-1] (lec13 - slide 33)
 *   Notes: the index of parent denotes the value of node. And parent[node] reflects its structure and
 *       connectedness. "-1" denotes the root of a tree/subtree. And parent[node] is the parent node of
 *       the node.
 *   connect(2,5);// let the root node of 5, 3, connect to root node of 2, -1. Mutate: parent[3] = 0;
 *   Then the sets configuration become {0,1,2,4,3,5},{6}
 *
 *   Consider the WORST CASE:
 *    The rooted tree doesn't have multiple branches
 *    {0,1,2,3,4} // parent: [-1,0,1,2,3] ---> similar to use a List
 *
 *   See QuickUnionDS class
 */




