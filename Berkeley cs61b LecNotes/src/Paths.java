import java.util.*;

public abstract class Paths {

    /** */
    public Paths(Graph G, int s){

    }

    /** */
    public boolean hasPathsTo(Graph G, int s){
        return false;
    }

    /** */
    public Iterable<Integer> PathsTo(Graph G, int t) {


        Iterable<Integer> seenIter = new Iterable<Integer>() {
            @Override
            public Iterator<Integer> iterator() {
                return null;
            }
        };

        return seenIter;
    }

}


