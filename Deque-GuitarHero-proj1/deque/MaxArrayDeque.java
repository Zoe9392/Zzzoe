package deque;
import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> implements Deque<T>{

    private Comparator<T> _comparator;
    /* No runtime restrictions on these two additional methods */

    public MaxArrayDeque(Comparator<T> c){
        super();
        this._comparator = c;
    }

    /** The maximum comparator in itself by using the Comparator<T>  */
    public T max(){
        if (this.isEmpty()) {
            return null;
        }
        T max = get(0);
        int index = 1;
        while (index < size()){
            T curr = get(index);
            if (_comparator.compare(max,curr) < 0) {
                max = curr;
            }
            index ++;
        }
        return max;
    }

    /** An arbitrary one that is different from the one given in constructor */
    public T max(Comparator<T> c){
        if (isEmpty()) {
            return null;
        }
        T max = this.get(0);
        int index = 1;
        while (index < size()){
            T curr = get(index);
            if (c.compare(max,curr) < 0) {
                max = curr;
            }
            index ++;
        }
        return max;
    }
}
