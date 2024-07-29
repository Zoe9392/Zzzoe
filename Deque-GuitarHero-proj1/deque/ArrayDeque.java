package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    /* Instance variables of AD */
    private int _size;
    private T[] _items;
    /* the array index of NEXT first item instead of current position of first item */
    private int _nextFirst;
    /* the array index of NEXT last item instead of current position of last item */
    private int _nextLast;
    private static final int CAP = 8;

    /** Initialization */
    public ArrayDeque() {
        _items = (T[]) new Object[CAP];
        _nextFirst = 3;
        _nextLast = 4;
        _size = 0;
    }

    /** Resizing the Array UP */
    private void resizeUP() {
        /* Warned by GSI: do not use System.arraycopy(); too many edge cases */
        int cap = _items.length;
        int updatedLength = 2 * cap;
        T[] updatedItems = (T[]) new Object[updatedLength];
        int index = 0;
        int startPos = 3;
        while (index < size()) {
            updatedItems[index + startPos] = get(index);
            index ++;
        }
        _items = updatedItems;
        _nextFirst = (startPos - 1) % _items.length;
        _nextLast = (_nextFirst + size() + 1) % _items.length;
    }

    /** Resizing the Array DOWN to be the half of the original length */
    private void resizeDOWN() {
        T[] updatedItems = (T[]) new Object[_items.length / 2];
        // Use the System.arraycopy and Consider the multiple edge cases
        if (_nextFirst > _nextLast) {
            if (_nextFirst == _items.length - 1) {
                System.arraycopy(_items,0,updatedItems,1,size());
            } else if (_nextLast == 0) {
                System.arraycopy(_items,_nextFirst + 1, updatedItems, 1, size());

            }else {
                System.arraycopy(_items,_nextFirst + 1, updatedItems,1, _items.length- 1 -_nextFirst);
                System.arraycopy(_items,0,updatedItems,_items.length - _nextFirst, _nextLast);
            }
        }
        if (_nextLast > _nextFirst) {
            System.arraycopy(_items,_nextFirst + 1,updatedItems,1,size());
        }
        _items = updatedItems;
        _nextFirst = 0;
        _nextLast = (_nextFirst + size() + 1) % _items.length;
    }

    @Override
    public int size() {
        return _size;
    }
    /** Adds the item in the front of the deque.
        Notes --- i) Initialization  ----> checks empty
                 ii) Resizing ----> checks validLoads
     */

    // Step1: check loads and resize
    // Step2: Adds the item
    // Step3: Updates the array index of _nextFirst and _size
    @Override
    public void addFirst(T item) {
        if ((_items.length == size()) || (_items.length >= 16 && size()/_items.length >= 0.75)) {
            resizeUP();
        }
        _items[_nextFirst] = item;
        if (_nextFirst == 0) {
            _nextFirst = _items.length - 1;
        } else {
            _nextFirst --;
        }
        _size += 1;
    }

    @Override
    public void addLast(T item) {
        if ((_items.length == size()) || (_items.length >= 16 && size()/_items.length >= 0.75)) {
            resizeUP();
        }
        _items[_nextLast] = item;
        if (_nextLast == _items.length - 1) {
            _nextLast = 0;
        } else {
            _nextLast ++;
        }
        _size += 1;
    }

    // Step1: Checks if the _items is empty
    // case ii: _items is not empty

    @Override
    public T removeLast() {
        // case i : _items is empty
        if (size() == 0) {
            return null;
        }
        if ( (_items.length / size() >= 4) && _items.length >= 16) {
            resizeDOWN();
        }
        T item = get(size() - 1);
        // Avoid modulo math
        if (_nextLast == 0) {
            _items[_items.length - 1] = null;
            _nextLast = _items.length - 1;
        } else {
            _nextLast -= 1;

        }
        _size --;
        return item;
    }

    @Override
    public T removeFirst() {
        if (_size == 0) {
            return null;
        }
        if ((_items.length / size() >= 4) && _items.length >= 16) {
            resizeDOWN();;
        }
        T item = get(0);
         if (_nextFirst == _items.length - 1) {
             _items[0] = null;
             _nextFirst = 0;
         } else {
             _nextFirst += 1;

         }

        _size --;
        return item;
    }

    /** The index here means the index-th item in the _items instead of the current array index */
    @Override
    public T get(int index) {
        /* !!!: Do Consider Edge Cases */
        /* Case 1: */
         if (index > size() - 1) { // A 0-indexed array deque
             return null;
         }
         /* Case 2: */
         if (size() == 0) { // returns null if nothing is in the array deque
             return null;
         }
         int arrayIndex = (_nextFirst + index + 1) % _items.length;
         return _items[arrayIndex];
    }

    @Override
    public void printDeque() {
        StringBuilder returnStr = new StringBuilder(" ");
        int index = 0;
        while (index < size()) {
            returnStr.append(get(index));
            returnStr.append(" ");
            index += 1;
        }
        System.out.print(returnStr + " \n");
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o instanceof ArrayDeque<?>) {
            for (int i = 0; i < this.size(); i++) {
                if (((ArrayDeque<?>) o).get(i) != this.get(i)){
                    result = false;
                    break;
                } else {
                    result = true;
                }
            }
        }
        return result;
    }

    /** Reference: Lecture Slides in ArraySet */
    public Iterator<T> iterator() {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<T> {
        private int currPos;
        public DequeIterator() {
            if (_nextFirst == _items.length - 1){
                currPos = 0;
            } else {
                currPos = _nextFirst + 1;
            }
        }           
        @Override
        public boolean hasNext() {
            if (currPos != _nextLast) {
                return true;
            }
            return false;
        }
        @Override
        public T next() {
            T currItem = _items[currPos];
            if (currPos == _items.length - 1) {
                currPos = 0;
            } else {
                currPos += 1;
            }
            return currItem;
        }
    }
}