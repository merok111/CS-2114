package spacecolonies;

public class ArrayQueueTest extends student.TestCase {
    private ArrayQueue<Integer> empty;
    private ArrayQueue<Integer> small;
    private ArrayQueue<Integer> big;


    public void setUp() {
        this.empty = new ArrayQueue<Integer>();
        this.small = new ArrayQueue<Integer>();
        this.big = new ArrayQueue<Integer>();

        for (int i = 1; i <= 15; i++) {
            if (i <= 5) {
                small.enqueue(i);
            }
            big.enqueue(i);
        }
    }


    public void testGetLength() {
        assertEquals(10, empty.getLength(), 0.01);
        assertEquals(10, small.getLength(), 0.01);
        assertEquals(20, big.getLength(), 0.01);
    }


    public void testGetSize() {
        
    }


    public void testIsEmpty() {

    }


    public void testMaxCap() {

    }


    public void testEnqueue() {

    }


    public void testDequeue() {

    }


    public void testGetFront() {

    }


    public void testClear() {

    }


    public void testToArray() {

    }


    public void testToString() {

    }


    public void testEquals() {

    }
}
