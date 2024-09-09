import java.util.*;

public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    private void bfs(Graph G, int s) {
        Queue<Integer> fringe = new PriorityQueue<>();
        fringe.add(s);
        /* Queue is First-In-First-Out */
        while(!fringe.isEmpty()) {
            int v = fringe.peek();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    fringe.add(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                }
            }

        }

    }

}


