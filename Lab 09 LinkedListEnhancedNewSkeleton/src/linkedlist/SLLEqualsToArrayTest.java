package linkedlist;

import java.util.Arrays;
import student.TestCase;

/**
 * 
 * Tests the equals and toArray methods of a singly linked list.
 * 
 * @author Margaret Ellis (maellis1)
 * 
 * @author Jeff Robertson (thejar)
 * 
 * @version 03/19/2017
 *
 */
public class SLLEqualsToArrayTest extends TestCase {

    private SinglyLinkedList<String> emptyListA;
    private SinglyLinkedList<String> emptyListB;
    private SinglyLinkedList<String> smallListA;
    private SinglyLinkedList<String> smallListB;
    private SinglyLinkedList<String> bigListA;
    private SinglyLinkedList<String> bigListB;
    private String nullObject;
    private SinglyLinkedList<String> repeating;


    /**
     * Initializes 2 empty lists, 2 lists with a small number of items, and 2
     * lists with a large number of items
     */
    public void setUp() {
        emptyListA = new SinglyLinkedList<String>();
        emptyListB = new SinglyLinkedList<String>();

        smallListA = new SinglyLinkedList<String>();
        smallListB = new SinglyLinkedList<String>();

        this.repeating = new SinglyLinkedList<String>();

        this.repeating.add("test");
        this.repeating.add("test");
        this.repeating.add("test1");

        smallListA.add("soccer");
        smallListA.add("swimming");
        smallListA.add("gymnastics");

        smallListB.add("soccer");
        smallListB.add("swimming");
        smallListB.add("gymnastics");

        bigListA = new SinglyLinkedList<String>();

        for (int i = 0; i < 100; i++) {
            bigListA.add("sport" + i);
        }

        bigListB = new SinglyLinkedList<String>();
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }

        // to be explicit
        nullObject = null;
    }


    // Given Tests
    /**
     * Tests the equals method on an empty list
     */
    public void testEqualsEmptyList() {
        assertEquals(emptyListA, emptyListA);
        assertEquals(emptyListA, emptyListB);
        assertFalse(emptyListA.equals(nullObject));
        assertFalse(emptyListA.equals("soccer"));
        assertFalse(emptyListA.equals(smallListA));
        assertFalse(smallListA.equals(emptyListA));
        emptyListB.add("jump roping");
        assertFalse(emptyListA.equals(emptyListB));
        smallListA.clear();
        assertEquals(emptyListA, smallListA);
    }


    /**
     * Tests the equals method on a list with a small number of items in it
     */
    public void testEqualsSmallList() {
        assertEquals(smallListA, smallListA);
        assertEquals(smallListA, smallListB);
        assertFalse(smallListA.equals(nullObject));
        assertFalse(smallListA.equals("soccer"));
        assertFalse(smallListA.equals(bigListA));
        assertFalse(smallListA.equals(emptyListA));
        smallListB.add("jump roping");
        assertFalse(smallListA.equals(smallListB));

        // Make smallListA and smallListB differ in
        // content, but have the same size
        smallListA.add("rope jumping");
        assertFalse(smallListA.equals(smallListB));

        // Replace the last element in smallListA
        // to make smallListA and smallListB equal again
        smallListA.remove("rope jumping");
        smallListA.add("jump roping");
        assertEquals(smallListA, smallListB);
    }


    /**
     * Tests the equals method on a list with a large number of items in it
     */
    public void testEqualsBigList() {
        assertEquals(bigListA, bigListA);
        assertEquals(bigListA, bigListB);
        assertFalse(bigListA.equals(nullObject));
        assertFalse(bigListA.equals("soccer"));
        assertFalse(bigListA.equals(smallListA));
        assertFalse(bigListA.equals(emptyListA));
        bigListB.add("jump roping");
        assertFalse(bigListA.equals(bigListB));

        // Same content, same size, but reversed
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 100; i > 0; i--) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // one a subset of the other but with dups
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        for (int i = 0; i < 50; i++) {
            bigListB.add("sport" + i);
        }
        assertFalse(bigListA.equals(bigListB));

        // make them equal again
        bigListB.clear();
        assertFalse(bigListA.equals(bigListB));
        for (int i = 0; i < 100; i++) {
            bigListB.add("sport" + i);
        }
        assertEquals(bigListA, bigListB);

    }


    /**
     * Tests the toArray method on an empty list
     */
    public void testToArrayEmpty() {

        Object[] emptyArray = {};
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(emptyListA.toArray(), smallListB.toArray()));
        Object[] oneItemArray = { "one thing" };
        emptyListA.add("one thing");
        assertTrue(Arrays.equals(emptyListA.toArray(), oneItemArray));

    }


    /**
     * Tests the toArray method on a list with items in it
     */
    public void testToArrayContents() {

        Object[] origArray = { "soccer", "swimming", "gymnastics" };
        assertTrue(Arrays.equals(smallListA.toArray(), origArray));
        assertTrue(Arrays.equals(emptyListA.toArray(), emptyListB.toArray()));
        assertFalse(Arrays.equals(smallListA.toArray(), bigListB.toArray()));

    }


    // My Tests
    /**
     * test the add method with an index and object
     */
    public void testAddWithIndex() {
        // null obj
        Exception exone = null;
        try {
            this.emptyListA.add(0, nullObject);
        }
        catch (Exception e) {
            exone = e;
        }
        assertNotNull(exone);
        assertTrue(exone instanceof IllegalArgumentException);

        // index out of bounds
        exone = null;
        Exception extwo = null;
        try {
            this.emptyListA.add(-1, "below index");

        }
        catch (Exception e) {
            exone = e;
        }
        try {
            this.emptyListA.add(200, "above index");
        }
        catch (Exception e) {
            extwo = e;
        }
        assertNotNull(exone);
        assertNotNull(extwo);
        assertTrue(exone instanceof IndexOutOfBoundsException);
        assertTrue(extwo instanceof IndexOutOfBoundsException);

        // empty list
        assertEquals(this.emptyListA.size(), 0, 0.01);
        assertEquals(this.emptyListA.toString(), "{}");
        this.emptyListA.add(0, "string");
        assertEquals(this.emptyListA.size(), 1, 0.01);
        assertEquals(this.emptyListA.toString(), "{string}");

        // index == 0
        assertEquals(this.smallListA.size(), 3, 0.01);
        assertEquals(this.smallListA.toString(),
            "{soccer, swimming, gymnastics}");
        this.smallListA.add(0, "string");
        assertEquals(this.smallListA.size(), 4, 0.01);
        assertEquals(this.smallListA.toString(),
            "{string, soccer, swimming, gymnastics}");

        // other
        assertEquals(this.smallListA.size(), 4, 0.01);
        assertEquals(this.smallListA.toString(),
            "{string, soccer, swimming, gymnastics}");
        this.smallListA.add(1, "another");
        assertEquals(this.smallListA.size(), 5, 0.01);
        assertEquals(this.smallListA.toString(),
            "{string, another, soccer, swimming, gymnastics}");
    }


    /**
     * test the add method with just the object
     */
    public void testAddWithoutIndex() {
        // null obj
        Exception exone = null;
        try {
            this.emptyListA.add(nullObject);
        }
        catch (Exception e) {
            exone = e;
        }
        assertNotNull(exone);
        assertTrue(exone instanceof IllegalArgumentException);

        // empty list
        assertEquals(this.emptyListA.size(), 0, 0.01);
        assertEquals(this.emptyListA.toString(), "{}");
        this.emptyListA.add("string");
        assertEquals(this.emptyListA.size(), 1, 0.01);
        assertEquals(this.emptyListA.toString(), "{string}");

        // other
        assertEquals(this.smallListA.size(), 3, 0.01);
        assertEquals(this.smallListA.toString(),
            "{soccer, swimming, gymnastics}");
        this.smallListA.add("another");
        assertEquals(this.smallListA.size(), 4, 0.01);
        assertEquals(this.smallListA.toString(),
            "{soccer, swimming, gymnastics, another}");
    }


    /**
     * test the remove method with an object
     */
    public void testRemoveObject() {
        // matching head
        assertEquals(this.emptyListA.size(), 0, 0.01);
        this.emptyListA.add("test");
        assertEquals(this.emptyListA.size(), 1, 0.01);
        assertTrue(this.emptyListA.remove("test"));
        assertEquals(this.emptyListA.size(), 0, 0.01);
        
        assertFalse(this.emptyListA.remove("tet"));
        
        // size greater than 1
        assertEquals(this.smallListA.size(), 3, 0.01);
        assertTrue(this.smallListA.remove("swimming"));
        assertEquals(this.smallListA.size(), 2, 0.01);
        
        //size of 1
        this.emptyListB.add("test");
        assertFalse(this.emptyListB.remove("wow"));
        assertTrue(this.emptyListB.remove("test"));
        
        // returns false
        assertFalse(this.smallListA.remove("swimming"));
    }


    /**
     * test the remove method with an index
     */
    public void testRemoveIndex() {
        // empty remove index
        Exception exception = null;
        try {
            this.emptyListA.remove(1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        // index less than 0
        exception = null;
        try {
            this.smallListA.remove(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        // index greater than list
        exception = null;
        try {
            this.smallListA.remove(200);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
        // test working remove
        assertTrue(this.smallListA.remove(1));
    }


    /**
     * test the get method
     */
    public void testGet() {
        // test working
        assertEquals(this.smallListA.get(0), "soccer");
        assertEquals(this.smallListA.get(1), "swimming");
        assertEquals(this.smallListA.get(2), "gymnastics");
        // index out of bounds
        Exception exception = null;
        try {
            this.smallListA.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * test the contains method
     */
    public void testContains() {
        // does contain
        assertTrue(this.smallListA.contains("gymnastics"));
        // does not contain
        assertFalse(this.smallListA.contains("test"));
    }


    /**
     * test the clear method
     */
    public void testClear() {
        // empty clear
        assertEquals(this.emptyListA.size(), 0, 0.01);
        this.emptyListA.clear();
        assertEquals(this.emptyListA.size(), 0, 0.01);
        // non empty clear
        assertEquals(this.smallListA.size(), 3, 0.01);
        this.smallListA.clear();
        assertEquals(this.smallListA.size(), 0, 0.01);
    }


    /**
     * test the lastIndexOf method
     */
    public void testLastIndexOf() {
        // equality on last index found
        // one index
        assertEquals(this.repeating.lastIndexOf("test1"), 2, 0.01);
        // two indexes
        assertEquals(this.repeating.lastIndexOf("test"), 1, 0.01);
        // -1, no index
        assertEquals(this.repeating.lastIndexOf("wow"), -1, 0.01);
    }


    /**
     * test the toString method
     */
    public void testToString() {
        // empty
        assertEquals(this.emptyListA.toString(), "{}");
        // 1 element
        this.emptyListA.add("test");
        // multiple elements
        assertEquals(this.smallListA.toString(),
            "{soccer, swimming, gymnastics}");
    }

}
