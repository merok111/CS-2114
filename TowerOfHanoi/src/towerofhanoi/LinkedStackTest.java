// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

import java.util.EmptyStackException;
import student.TestCase;

/**
 * Test the LinkedStack class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class LinkedStackTest extends TestCase {
    private LinkedStack<Integer> stack;
    private LinkedStack<Integer> empty;


    /**
     * Set up tests
     */
    public void setUp() {
        this.stack = new LinkedStack<Integer>();
        for (int i = 0; i < 10; i++) {
            this.stack.push(i);
        }

        this.empty = new LinkedStack<Integer>();
    }


    /**
     * Test LinkedStack size method
     */
    public void testSize() {
        assertEquals(this.stack.size(), 10, 0.01);
        assertEquals(this.empty.size(), 0, 0.01);
    }


    /**
     * Test LinkedStack isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(this.empty.isEmpty());
        assertFalse(this.stack.isEmpty());
    }


    /**
     * Test LinkedStack peek method
     */
    public void testPeek() {
        Exception exception = null;
        try {
            this.empty.peek();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof EmptyStackException);

        assertEquals(this.stack.peek(), 9, 0.01);
    }


    /**
     * Test LinkedStack push method
     */
    public void testPush() {
        assertEquals(this.stack.size(), 10, 0.01);
        this.stack.push(10);
        assertEquals(this.stack.size(), 11, 0.01);
        assertEquals(this.stack.peek(), 10, 0.01);
    }


    /**
     * Test LinkedStack pop method
     */
    public void testPop() {
        Exception exception = null;
        try {
            this.empty.pop();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof EmptyStackException);

        assertEquals(this.stack.size(), 10, 0.01);
        this.stack.pop();
        assertEquals(this.stack.size(), 9, 0.01);
        assertEquals(this.stack.peek(), 8, 0.01);
    }


    /**
     * Test LinkedStack toString method
     */
    public void testToString() {
        assertEquals(this.empty.toString(), "[]");
        assertEquals(this.stack.toString(), "[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]");
    }


    /**
     * Test LinkedStack clear method
     */
    public void testClear() {
        assertEquals(this.stack.size(), 10, 0.01);
        this.stack.clear();
        assertEquals(this.stack.size(), 0, 0.01);
        Exception exception = null;
        try {
            this.empty.pop();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof EmptyStackException);
    }
}
