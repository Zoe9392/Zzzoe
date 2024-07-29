package deque;
import org.junit.Test;
import static org.junit.Assert.*;
public class ArrayDequeTest {
    @Test
    /** */
    public void addIsEmptySizeWithoutResizingTest() {

        ArrayDeque<String> ad1 = new ArrayDeque<String>();

        assertTrue("A newly initialized ArrayDeque should be empty and length 8", ad1.isEmpty());
        ad1.addFirst("front");

        assertEquals(1, ad1.size());
        assertEquals("front", ad1.get(0));
        assertFalse("ad1 should now contain 1 item", ad1.isEmpty());

        ad1.addLast("middle");
        assertEquals("middle", ad1.get(1));

        ad1.addLast("back");
        assertEquals("back", ad1.get(2));

        ad1.removeFirst();
        assertEquals("back",ad1.get(1));

        ad1.removeLast();
        assertEquals("middle",ad1.get(0));
        assertEquals(1,ad1.size());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    public void addWithResizeUpTest() {
        ArrayDeque<Character> ad1 = new ArrayDeque<Character>();
        assertTrue("A newly initialized ArrayDeque should be empty and length 8", ad1.isEmpty());

        ad1.addLast('x');
        ad1.addLast('y');
        ad1.addFirst('z');
        ad1.addLast('w');
        ad1.addFirst('r');
        ad1.addLast('a');
        ad1.addFirst('g');
        ad1.addFirst('h');
        ad1.addFirst('j');
        ad1.addFirst('k');
        ad1.removeFirst();
        ad1.removeLast();


        assertEquals(8,ad1.size());
        assertEquals('j', ad1.get(0).charValue());

        System.out.println("Printing out deque: ");
        ad1.printDeque();
    }

    @Test
    public void addRemoveWithResizeUpDownTest() {
        ArrayDeque<Character> ad1 = new ArrayDeque<Character>();
        assertTrue("A newly initialized ArrayDeque should be empty and length 8", ad1.isEmpty());
        ad1.addLast('x');
        ad1.addLast('y');
        ad1.addFirst('z');
        ad1.addLast('w');
        ad1.addFirst('r');
        ad1.addLast('a');
        ad1.addFirst('g');
        ad1.addFirst('h');
        ad1.addFirst('j');
        ad1.addFirst('k');
        ad1.addFirst('u');

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.addFirst('s');
        ad1.addFirst('m');

        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();
        ad1.removeLast();

        System.out.println("Printing out deque: ");
        ad1.printDeque();

        ad1.removeLast();

        System.out.println("Printing out deque: ");
        ad1.printDeque();

    }

    @Test

    public void bigLLDequeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }
    }

    @Test

    public void IteratorTest() {
        ArrayDeque<Integer> ad2 = new ArrayDeque<Integer>();

    }

}
