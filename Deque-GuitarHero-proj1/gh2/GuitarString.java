package gh2;
import deque.ArrayDeque;
import deque.Deque;


//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {
    /** Constants. Do not change. In case you're curious, the keyword final
     * means the values cannot be changed at runtime. We'll discuss this and
     * other topics in lecture on Friday. */
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor
    /* Buffer for storing sound data. */
    private Deque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        // TODO: Create a buffer with capacity = SR / frequency. You'll need to
        //       cast the result of this division operation into an int. For
        //       better accuracy, use the Math.round() function before casting.
        //       Your should initially fill your buffer array with zeros.
        int capacity = (int) Math.round( SR / frequency);
        buffer = new ArrayDeque<>();
        double knot = 0.0;
        while (buffer.size() < capacity) {
            buffer.addFirst(knot); // resize criterion in java
        }

    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        // TODO: Dequeue everything in buffer, and replace with random numbers
        //       between -0.5 and 0.5. You can get such a number by using:
        //       double r = Math.random() - 0.5;
        //       Make sure that your random numbers are different from each
        //       other is does not mean that you need to check that the numbers
        //       are different from each other. It means you should repeatedly call
        //       Math.random() - 0.5 to generate new random numbers for each array index.
        /* For-loop here works; while loop doesn't work */
        for (int index = 0; index < buffer.size(); index ++) {
            double r = Math.random() - 0.5;
            buffer.removeFirst(); // dequeue: Removes an item from the front of the queue
            buffer.addLast(r); // enqueue: adds an item from the back of the queue
        }
    }

    public void tic() {
        // TODO: Dequeue the front sample and enqueue a new sample that is
        //       the average of the two multiplied by the DECAY factor.
        double fString = buffer.get(0); // Do Not Use removeFirst()
        double sString = buffer.get(1);
        double avgFactor = DECAY * 0.5;
        double newString = avgFactor * (sString + fString);
        buffer.removeFirst(); // dequeue
        buffer.addLast(newString); // enqueue
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.get(0); // Do not use removeFirst()
        // peek() in queue : returns the value of the item in front of the queue without
        // removing(dequeuing) items ; pop()              
    }
}

