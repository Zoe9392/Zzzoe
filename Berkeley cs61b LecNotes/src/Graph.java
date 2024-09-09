import java.util.ArrayList;
import java.util.List;

/** Bare-Bones Undirected Graph (use adjacency list)   */
public class Graph {
    private final int V;
    private List<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = (List<Integer>[]) new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    Iterable<Integer> adj(int v){
        return adj[v];
    }

    /* number of vertices in the graph */
    int V(){
        return 0;
    }
    /* number of vertices in the graph */
    int E() {
        return 0;
    }
    
}





/**
 *  Needs an underlying data structure to represent the GRAPH
 *  Adjacent Matrix ; Edge Sets ; Adjacency list
 *
 */








