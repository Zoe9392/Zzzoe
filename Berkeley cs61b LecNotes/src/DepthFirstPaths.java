

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;


    public DepthFirstPaths(Graph G, int x) {

        dfs(G,x);

    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for (int w : G.adj(s)) {
            if (marked[w] = false) {
                edgeTo[w] = s;
                dfs(G,w);
            }
        }
    }




}
