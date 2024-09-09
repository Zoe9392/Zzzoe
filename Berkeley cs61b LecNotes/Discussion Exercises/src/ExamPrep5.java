import java.util.*;
import java.util.function.Predicate;
public class ExamPrep5 {
    /** ExamPrep 5 Question 2: Reads the prompt and ArraySet content in Lec11 */
    public class FilteredList<T> implements Iterable<T>{
        List<T> list;
        Predicate<T> filter;
        /* Constructor: the constructor of FilteredList */
        public FilteredList(List<T> l, Predicate<T> filter) {
            this.list = l;
            this.filter = filter;
        }

        @Override
        public Iterator<T> iterator(){
            return new FilteredListIterator(list,filter);
        }
        private class FilteredListIterator implements Iterator<T>{
            List<T> lst;
            Predicate<T> predicate;
            int index = 0;
            /* Constructor of FilteredListIterator */
            public FilteredListIterator(List<T> list, Predicate<T> filter) {
                lst = new LinkedList<>();
                int currIndex = 0;
                this.predicate = filter;
                while (currIndex < list.size()) {
                    T currItem = list.get(currIndex);
                    if(predicate.test(currItem)) {
                        lst.add(currItem);
                    }
                    currIndex++;
                }
            }

            @Override
            public boolean hasNext() {
                return index < lst.size();
            }

            @Override
            public T next() {
                T result = lst.get(index);
                index ++;
                return result;
            }
        }
    }

    /** ExamPrep 5 Question 3: Iterator of iterators */
    public class IteratorOfIterators implements Iterator<Integer>{
        /* Core Idea in solution: to initiate a new linked list to be an iterator containing
         the required return elements in order. A list of iterators means that the data type in the
         list is not list.
        */
        List<Integer> list;
        int index = 0;
        int listIndex = 0;

        public IteratorOfIterators( List<Iterator<Integer>> a) {
            list = new LinkedList<>();
            while (!a.isEmpty()) {
                if (a.get(index).hasNext()) {
                    list.add(a.get(index).next());
                }
                index = (index + 1) % a.size();
            }
        }

        @Override
        public boolean hasNext() {
            return listIndex < list.size();
        }

        @Override
        public Integer next() {
            int result = list.get(listIndex);
            listIndex ++;
            return result;
        }
    }
}
