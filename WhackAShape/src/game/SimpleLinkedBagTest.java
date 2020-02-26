package game;

import student.TestableRandom;

/**
 * Testing the SimpleLinkedBag object and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2.24.2020
 *
 */
public class SimpleLinkedBagTest extends student.TestCase {

    private SimpleLinkedBag<Integer> emptyBag;
    private SimpleLinkedBag<Integer> fullBag;


    /**
     * set up test methods
     */
    public void setUp() {
        this.emptyBag = new SimpleLinkedBag<Integer>();

        this.fullBag = new SimpleLinkedBag<Integer>();

        for (int i = 0; i < 25; i++) {
            this.fullBag.add(i);
        }

    }


    /**
     * test SimpleArrayBag add method
     */
    public void testAdd() {
        assertTrue(this.emptyBag.isEmpty());
        assertEquals(this.emptyBag.getCurrentSize(), 0, 0.01);
        this.emptyBag.add(1);
        assertEquals(this.emptyBag.getCurrentSize(), 1, 0.01);
        assertFalse(this.emptyBag.add(null));
        assertEquals(this.emptyBag.getCurrentSize(), 1, 0.01);
    }


    /**
     * test SimpleArrayBag getCurrentSize method
     */
    public void testGetCurrentSize() {
        assertTrue(this.emptyBag.isEmpty());
        assertEquals(this.emptyBag.getCurrentSize(), 0, 0.01);
        this.emptyBag.add(1);
        assertEquals(this.emptyBag.getCurrentSize(), 1, 0.01);
        this.emptyBag.remove(1);
        assertEquals(this.emptyBag.getCurrentSize(), 0, 0.01);
        this.emptyBag.add(1);
        this.emptyBag.add(2);
        this.emptyBag.add(3);
        assertEquals(this.emptyBag.getCurrentSize(), 3, 0.01);
    }


    /**
     * test SimpleArrayBag isEmpty method
     */
    public void testIsEmpty() {
        assertTrue(this.emptyBag.isEmpty());
        assertFalse(this.fullBag.isEmpty());
    }


    /**
     * test SimpleArrayBag pick method
     */
    public void testPick() {
        assertNull(this.emptyBag.pick());
        TestableRandom.setNextInts(0, 20, 7);
        assertEquals(this.fullBag.pick(), 24, 0.01);
        assertEquals(this.fullBag.pick(), 4, 0.01);
        assertEquals(this.fullBag.pick(), 17, 0.01);
    }


    /**
     * test SimpleArrayBag remove method
     */
    public void testRemove() {
        assertTrue(this.emptyBag.isEmpty());
        assertEquals(this.emptyBag.getCurrentSize(), 0, 0.01);
        this.emptyBag.add(1);
        assertEquals(this.emptyBag.getCurrentSize(), 1, 0.01);
        assertTrue(this.emptyBag.remove(1));
        assertEquals(this.emptyBag.getCurrentSize(), 0, 0.01);
        assertFalse(this.emptyBag.remove(1));
        assertFalse(this.emptyBag.remove(null));
        assertFalse(this.emptyBag.remove(20));
        this.emptyBag.add(1);
        this.emptyBag.add(2);
        this.emptyBag.add(3);
        assertTrue(this.emptyBag.remove(3));
    }
}
