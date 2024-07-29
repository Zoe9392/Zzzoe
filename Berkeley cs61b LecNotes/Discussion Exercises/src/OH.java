import java.util.Iterator;
import java.util.NoSuchElementException;

public class OH {
    public class OHRequest{
        public String description;
        public String name;
        public OHRequest next;
        public OHRequest(String description, String name, OHRequest next){
            this.description = description;
            this.name = name;
            this.next = next;
        }
    }

    /**
     * Creates a class OHIterator that implements an iterator over OHRequests and only returns requests
     * with good descriptions(using the isGood function). Our OHIterator's constructor takes in an
     * OHRequest that
     *
     */

    public class OHIterator implements Iterator {
        OHRequest curr;
        public OHIterator(OHRequest queue) {
            curr = queue;
        }

        public boolean isGood(String description) {
            /* actual implementations are ignored here */
            return false;
        }

        public boolean hasNext(){
            /* It requires that only returns requests with good descriptions. Put it to
            *  this method instead of next(). If this process doesn't skip the "bad requests",
            *  hasNext() might return true but next() can not return anything.
            */
            if(curr != null && !isGood(curr.next.description)) {
                curr = curr.next;
            } else if (curr != null && curr.next == null) {
                return false;
            }
            return true;
        }

        public OHRequest next() {
            if(!hasNext()) {
                // not return null here by the given description
                throw new NoSuchElementException();
            }
            OHRequest res = curr;
            curr = curr.next;
            return res;
        }
    }

    /** Question (b): Define a class OHQueue below: we want our OHQueue to be iterable
     * so that we can process OHRequest objects with good descriptions. Our constructor
     * takes in the first OHRequest object on the queue.
     */
    public class OHQueue implements Iterable<OHRequest> {
        OHRequest theQueue;

        public  OHQueue (OHRequest queue) {
            theQueue = queue;
        }
        @Override
        public Iterator<OHRequest> iterator(){
            return new OHIterator(theQueue);
        }

    }

    /** Question (c): */
    public class TYIterator extends OHIterator {
        public TYIterator(OHRequest queue) {
            super(queue);
        }

        /*
        @Override
        public boolean hasNext() {
            if(curr!=null && !isGood(curr.next.description)) {
                curr = curr.next;
            } else if (curr.description.contains("thank u")) {
                curr = curr.next;
            } else if (curr != null && curr.next == null) {
                return false;
            }
            return true;
        }
        */
        // This question means to modify here, the next() method here
        @Override
        public OHRequest next() {
            OHRequest res = super.next();
            if (res.description.contains("thank u")) {
                res = super.next();
            }
            return res;
        }
    }
}

/**
 * Iterator</> and Iterable</> interface has different
 *
 * Usually, Iterator<E> has instance variables, constructor , hasNext() that returns a boolean value,
 *      next() that returns E, in the interface
 * And, Iterable<T> has instance variables , constructor , iterator() that returns an Iterator<T>,
 *      spliterator<> that returns Spliterator<T> and so on.
 * */


