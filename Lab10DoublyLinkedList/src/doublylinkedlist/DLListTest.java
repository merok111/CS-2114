/**
 *
 */
package doublylinkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * @author Eric
 * @author maellis1
 * @version 11-2-15
 * @author Matthew Grillo (mwgrillo)
 * @version 4/11/2020
 *
 */
public class DLListTest extends TestCase {
    /**
     * the list we will use
     */
    private DLList<String> list;


    /**
     * run before every test case
     */
    @Override
    public void setUp() {
        list = new DLList<String>();
        iteratorSetUp();
    }


    /**
     * Tests that an IndexOutOfBounds exception is thrown when the index is
     * greater than or equal to size and less than zero
     */
    public void testRemoveException() {
        list.add("A");
        Exception e = null;
        try {
            list.remove(2);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.remove(-1);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests that objects can be removed at the beginning and end and that the
     * size is changed
     */
    public void testRemoveIndex() {
        list.add("A");
        list.add("B");
        assertTrue(list.remove(1));
        assertEquals(1, list.size());
        list.add("B");
        assertTrue(list.remove(0));
        assertEquals(1, list.size());
    }


    /**
     * Tests the add method. Ensures that it adds the object is added at the end
     * and the size is increased
     */
    public void testAdd() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("B");
        assertEquals(2, list.size());
        assertEquals("B", list.get(1));

    }


    /**
     * Tests that objects can be added at the beginning and end and that they
     * are placed correctly
     */
    public void testAddIndex() {
        list.add("B");
        list.add(0, "A");
        assertEquals("A", list.get(0));
        assertEquals(2, list.size());
        list.add(2, "D");
        assertEquals("D", list.get(2));
        list.add(2, "C");
        assertEquals("C", list.get(2));
    }


    /**
     * This tests that the add method throws a null pointer exception when
     * adding null data to the list
     */
    public void testAddNullException() {
        Exception e = null;
        try {
            list.add(null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests that the add method throws a Invalid argument when adding null
     * data to the list
     */
    public void testAddIndexNullException() {
        Exception e = null;
        try {
            list.add(0, null);
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * This tests when the add method is called and the index is greater than
     * size or less than zero
     */
    public void testAddException() {
        list.add("A");
        Exception e = null;
        try {
            list.add(2, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
        e = null;
        try {
            list.add(-1, "B");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests removing a object changes the size appropiately and that you can
     * remove the first and last elements
     */
    public void testRemoveObj() {
        assertFalse(list.remove(null));
        list.add("A");
        list.add("B");
        assertTrue(list.remove("A"));
        assertEquals("B", list.get(0));
        assertEquals(1, list.size());
        list.add("C");
        assertTrue(list.remove("C"));
        assertEquals("B", list.get(0));
    }


    /**
     * Tests get when the index is greater than or equal to size and when the
     * index is less than zero
     */
    public void testGetException() {
        Exception exception = null;
        try {
            list.get(-1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        exception = null;
        list.add("A");
        try {
            list.get(1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Test contains when it does and does not contain the object
     */
    public void testContains() {
        assertFalse(list.contains("A"));
        list.add("A");
        assertTrue(list.contains("A"));
        assertFalse(list.contains("B"));
        list.add("B");
        assertTrue(list.contains("B"));
    }


    /**
     * Test lastIndexOf when the list is empty, when the object is not in the
     * list, and when it is at the beginning or end
     */
    public void testLastIndexOf() {
        assertEquals(-1, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(0, list.lastIndexOf("A"));
        list.add("A");
        assertEquals(1, list.lastIndexOf("A"));
        list.add("B");
        assertEquals(1, list.lastIndexOf("A"));
        assertEquals(2, list.lastIndexOf("B"));
        list.add("A");
        assertEquals(3, list.lastIndexOf("A"));
    }


    /**
     * Tests isEmpty when empty and full
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        assertFalse(list.isEmpty());
    }


    /**
     * Ensures that all of the objects are cleared and the size is changed
     */
    public void testClear() {
        list.add("A");
        list.clear();
        assertEquals(0, list.size());
        assertFalse(list.contains("A"));
    }


    /**
     * Tests the toString when there are 0, 1, and 2 objects in the list
     */
    public void testToString() {
        assertEquals("{}", list.toString());
        list.add("A");
        assertEquals("{A}", list.toString());
        list.add("B");
        assertEquals("{A, B}", list.toString());
    }


    /**
     * Tests removing from an empty list
     */
    public void testRemoveFromEmpty() {
        list.add("dance");
        list.add(0, "safety");
        list.clear();
        assertFalse(list.remove("safety"));
        Exception exception;
        exception = null;
        try {
            list.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);

        DLList<String> emptyList = new DLList<String>();
        exception = null;
        try {
            emptyList.remove(0);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
    }

    // Iterator Tests
    private Iterator emptyIter;
    private Iterator listIter;
    private DLList<String> anotherList;


    /**
     * helper method to set up the iterator tests
     */
    private void iteratorSetUp() {
        this.emptyIter = new DLList<String>().iterator();
        this.anotherList = new DLList<String>();
        for (char i = 'a'; i <= 'z'; i++) {
            this.anotherList.add(i + "");
        }
        this.listIter = anotherList.iterator();
    }


    /**
     * test the iterator's hasNext method
     */
    public void testIteratorHasNext() {
        // true when the next node isn't the tail SENTINEL node
        assertFalse(emptyIter.hasNext());
        assertTrue(listIter.hasNext());
    }


    /**
     * test the iterator's next method
     */
    public void testIteratorNext() {
        // empty iterator
        Exception e = null;
        try {
            emptyIter.next();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertNotNull(e);
        assertTrue(e instanceof NoSuchElementException);

        // check that each next equals the objects added (a through z in
        // alphabet order)
        for (char i = 'a'; i <= 'z'; i++) {
            String compare = i + "";
            assertEquals(compare, listIter.next());
        }

        // now that all the objects have been looped through, even though the
        // doubly linked list should loop forever, it should throw an error
        e = null;
        try {
            listIter.next();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertNotNull(e);
        assertTrue(e instanceof NoSuchElementException);
    }


    /**
     * test the iterator's remove method
     */
    public void testIteratorRemove() {
        // empty
        Exception e = null;
        try {
            this.emptyIter.remove();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalStateException);

        // no next called
        e = null;
        try {
            this.listIter.remove();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalStateException);

        // remove success
        assertEquals(26, this.anotherList.size(), 0.01);
        for (int i = 0; i < 10; i++) {
            // System.out.println(this.listIter.next());
            this.listIter.next();
        }
        // j is the current
        this.listIter.remove();
        assertFalse(this.anotherList.contains("j"));
        assertEquals(25, this.anotherList.size(), 0.01);

        // error on remove after remove
        e = null;
        try {
            this.listIter.remove();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertNotNull(e);
        assertTrue(e instanceof IllegalStateException);
    }

}
