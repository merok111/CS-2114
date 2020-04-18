package cybersecurity.lab1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Test the LinkedKVStore class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.18.2020
 *
 */
public class LinkedKVStoreTest extends student.TestCase {
    private LinkedKVStore<Integer, String> store;
    private LinkedKVStore<Integer, String> bigStore;
    private LinkedKVStore<Integer, String> sameStore;


    /**
     * Set up the objects for testing
     */
    public void setUp() {
        this.store = new LinkedKVStore<Integer, String>();
        this.bigStore = new LinkedKVStore<Integer, String>();
        this.sameStore = new LinkedKVStore<Integer, String>();
        for (int i = 1; i <= 10; i++) {
            this.bigStore.put(i, "entry at " + i);
            this.sameStore.put(1, "entry at " + i);
        }
    }


    /**
     * Test LinkedKVStore isEmpty method for proper functionality
     */
    public void testIsEmpty() {
        assertTrue(store.isEmpty());
        store.put(1, "one");
        assertFalse(store.isEmpty());
    }


    /**
     * Test LinkedKVStore size method for proper functionality
     */
    public void testSize() {
        assertEquals(store.size(), 0, 0.01);
        store.put(1, "one");
        assertEquals(store.size(), 1, 0.01);
        store.removeFirst(1);
        assertEquals(store.size(), 0, 0.01);
        assertEquals(this.sameStore.size(), 10, 0.01);
    }


    /**
     * Test LinkedKVStore clear method for proper functionality
     */
    public void testClear() {
        assertEquals(bigStore.size(), 10, 0.01);
        bigStore.clear();
        assertEquals(bigStore.size(), 0, 0.01);
        for (int i = 1; i <= 10; i++) {
            assertFalse(bigStore.contains(i));
        }
    }


    /**
     * Test LinkedKVStore getFirst method for proper functionality
     */
    public void testGetFirst() {
        assertEquals(bigStore.getFirst(10), "entry at 10");
        assertNull(bigStore.getFirst(11));
        assertEquals(sameStore.getFirst(1), "entry at 1");
    }


    /**
     * Test LinkedKVStore getLast method for proper functionality
     */
    public void testGetLast() {
        assertEquals(bigStore.getLast(10), "entry at 10");
        assertNull(bigStore.getLast(11));
        assertEquals(sameStore.getLast(1), "entry at 10");
    }


    /**
     * Test LinkedKVStore addFirst method for proper functionality
     */
    public void testAddFirst() {
        store.put(10, "entry at 10");
        store.addFirst(9, "entry at 9");
        Iterator<Integer> iter = store.iterator();
        assertEquals(iter.next(), 9, 0.01);
        assertEquals(iter.next(), 10, 0.01);
    }


    /**
     * Test LinkedKVStore addLast method for proper functionality
     */
    public void testAddLast() {
        store.put(9, "entry at 9");
        store.put(8, "entry 8");
        store.addLast(10, "entry at 10");
        Iterator<Integer> iter = store.iterator();
        assertEquals(iter.next(), 9, 0.01);
        assertEquals(iter.next(), 8, 0.01);
        assertEquals(iter.next(), 10, 0.01);
    }


    /**
     * Test LinkedKVStore removeFirst method for proper functionality
     */
    public void testRemoveFirst() {
        this.bigStore.put(11, "entry at 11");
        this.bigStore.put(11, "entry at 12");
        assertEquals(bigStore.size(), 12, 0.01);
        assertTrue(bigStore.removeFirst(11));
        assertFalse(bigStore.removeFirst(13));
        assertEquals(bigStore.getFirst(11), "entry at 12");
        assertEquals(bigStore.size(), 11, 0.01);
    }


    /**
     * Test LinkedKVStore removeLast method for proper functionality
     */
    public void testRemoveLast() {
        this.bigStore.put(11, "entry at 11");
        this.bigStore.put(11, "entry at 12");
        assertEquals(bigStore.size(), 12, 0.01);
        assertTrue(bigStore.removeLast(11));
        assertFalse(bigStore.removeLast(13));
        assertEquals(bigStore.getLast(11), "entry at 11");
        assertEquals(bigStore.size(), 11, 0.01);
    }


    /**
     * Test LinkedKVStore contains method for proper functionality
     */
    public void testContains() {
        for (int i = 1; i <= 10; i++) {
            assertTrue(bigStore.contains(i));
        }
        assertFalse(bigStore.contains(11));
    }


    /**
     * Test LinkedKVStore iterator method for proper functionality
     */
    public void testIterator() {
        Iterator<Integer> iter = bigStore.iterator();
        for (int i = 1; i <= 10; i++) {
            assertTrue(iter.hasNext());
            assertEquals(iter.next(), i, 0.01);
        }
        assertFalse(iter.hasNext());
        Exception exception = null;
        try {
            iter.next();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof NoSuchElementException);
    }


    /**
     * Test LinkedKVStore tosString method for proper functionality
     */
    public void testToString() {
        assertEquals(store.toString(), "[]");
        assertEquals(bigStore.toString(), "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        assertEquals(sameStore.toString(), "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1]");
    }
    
    
    /**
     * Test LinkedKVStore get method for proper functionality
     */
    public void testGet() {
        assertEquals(bigStore.get(3), "entry at 3");
    }
}
