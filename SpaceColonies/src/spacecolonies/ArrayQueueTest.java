// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

import queue.EmptyQueueException;

/**
 * Test the ArrayQueue class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class ArrayQueueTest extends student.TestCase {
    private ArrayQueue<Integer> empty;
    private ArrayQueue<Integer> small;

    private ArrayQueue<Integer> big;
    private ArrayQueue<Integer> same;

    private ArrayQueue<Integer> not;
    private String diffClass = "wow";
    private ArrayQueue<Integer> hmm;


    /**
     * method to set up tests
     */
    public void setUp() {
        this.empty = new ArrayQueue<Integer>();
        this.small = new ArrayQueue<Integer>();
        this.big = new ArrayQueue<Integer>();
        this.same = new ArrayQueue<Integer>();
        this.hmm = new ArrayQueue<Integer>();

        for (int i = 1; i <= 15; i++) {
            if (i <= 5) {
                small.enqueue(i);
                hmm.enqueue(i + 20);
            }
            big.enqueue(i);
            same.enqueue(i);
        }
    }


    /**
     * test ArrayQueue getLength method for proper functionality
     */
    public void testGetLength() {
        assertEquals(11, empty.getLength(), 0.01);
        assertEquals(11, small.getLength(), 0.01);
        assertEquals(21, big.getLength(), 0.01);

        empty.enqueue(1);
        empty.enqueue(2);
        assertEquals(11, empty.getLength(), 0.01);
    }


    /**
     * test ArrayQueue getSize method for proper functionality
     */
    public void testGetSize() {
        assertEquals(0, empty.getSize(), 0.01);
        assertEquals(5, small.getSize(), 0.01);
        assertEquals(15, big.getSize(), 0.01);
    }


    /**
     * test ArrayQueue getLength method for proper functionality
     */
    public void testIsEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(small.isEmpty());
    }


    /**
     * test ArrayQueue enqueue, dequeue, and getFront methods for proper
     * functionality
     */
    public void testQueue() {
        assertEquals(0, empty.getSize(), 0.01);
        empty.enqueue(4);
        assertEquals(1, empty.getSize(), 0.01);
        assertEquals(4, empty.getFront(), 0.01);
        empty.enqueue(5);
        assertEquals(4, empty.getFront(), 0.01);
        assertEquals(4, empty.dequeue(), 0.01);
        assertEquals(5, empty.getFront(), 0.01);
        assertEquals(5, empty.dequeue(), 0.01);

        Exception exception = null;
        for (int i = 1; i <= 100; i++) {
            empty.enqueue(i);
        }
        try {
            empty.enqueue(101);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
        assertEquals(161, empty.getLength(), 0.01);
        empty.clear();
        try {
            empty.getFront();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof EmptyQueueException);
    }


    /**
     * test ArrayQueue clear method for proper functionality
     */
    public void testClear() {
        assertEquals(15, big.getSize(), 0.01);
        big.clear();
        assertEquals(0, big.getSize(), 0.01);
        assertEquals(11, big.getLength(), 0.01);
    }


    /**
     * test ArrayQueue toArray method for proper functionality
     */
    public void testToArray() {
        boolean failit = false;
        Object[] objs = big.toArray();
        for (int i = 1; i <= objs.length; i++) {
            if (objs[i - 1] instanceof Integer) {
                int obj = (int)objs[i - 1];
                assertEquals(i, obj, 0.01);
            }
            else if (objs[i - 1] != null) {
                assertTrue(failit);
            }
        }
    }


    /**
     * test ArrayQueue toString method for proper functionality
     */
    public void testToString() {
        assertEquals("[]", empty.toString());
        assertEquals("[1, 2, 3, 4, 5]", small.toString());
        assertEquals("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]", big
            .toString());
    }


    /**
     * test ArrayQueue equals method for proper functionality
     */
    public void testEquals() {
        assertFalse(big.equals(not));
        assertFalse(big.equals(diffClass));
        assertTrue(big.equals(same));
        assertFalse(big.equals(small));
        assertFalse(small.equals(big));
        assertFalse(hmm.equals(small));
        assertFalse(hmm.equals(big));
        assertFalse(hmm.equals(empty));
        assertFalse(small.equals(hmm));
    }
}
