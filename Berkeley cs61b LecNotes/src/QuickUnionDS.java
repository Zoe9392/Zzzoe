
public class QuickUnionDS implements DisjointSets {
    private int[] parent;

    public QuickUnionDS(int N) {
        for (int i = 0; i < N; i++) {
            /* initial case: each node is a root at the original state */
            parent[i] = -1;
        }
    }
    /* Returns the root node of the input node p*/
    private int find(int p) {
        int root = p;
        while (parent[root] >= 0) {
            root = parent[root];
        }
        return root;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void connect(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        parent[qid] = pid;
    }
}

/** Goal: Improve connect() method via avoiding the worst trees, one-sided trees.
 *   There is a hole in connect method. There is no restriction in connecting smaller tree to
 *   bigger tree.
 *
 *  ---> WeightedQuickUnionDSWithPathCompression (cs170 - topological stuff)
 *  Briefly summary: lower the depth of the tree via connecting "pass-by" nodes with root
 *
 */
