package binarySearchTree;

import student.TestCase;

/**
 * Testing the Lab14BinarySearchTree class for proper functionality
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 5.2.2020
 *
 */
public class BinarySearchTreeTest extends TestCase {

    private Lab14BinarySearchTree<Integer> tree;
    private Lab14BinarySearchTree<Integer> empty;


    /**
     * Set up tests
     */
    public void setUp() {
        tree = new Lab14BinarySearchTree<Integer>();
        empty = new Lab14BinarySearchTree<Integer>();

        tree.insert(5);
        tree.insert(3);
        tree.insert(9);
        tree.insert(2);
        tree.insert(4);
        tree.insert(7);
        tree.insert(10);
        tree.insert(1);
        tree.insert(8);
    }


    /**
     * Test BinarySearchTree insert method for proper functionality
     */
    public void testInsert() {
        // in order gives least to greatest 1-10
        assertEquals("(1, 2, 3, 4, 5, 7, 8, 9, 10)", tree.toString());

        Exception exception = null;
        try {
            tree.insert(1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof DuplicateItemException);
    }


    /**
     * Test BinarySearchTree remove method for proper functionality
     */
    public void testRemove() {
        tree.remove(7);
        assertNull(tree.find(7));
        assertEquals("(1, 2, 3, 4, 5, 8, 9, 10)", tree.toString());
        tree.remove(8);
        assertNull(tree.find(8));
        assertEquals("(1, 2, 3, 4, 5, 9, 10)", tree.toString());
        tree.remove(9);
        assertNull(tree.find(9));
        assertEquals("(1, 2, 3, 4, 5, 10)", tree.toString());
        tree.remove(3);
        assertNull(tree.find(3));
        assertEquals("(1, 2, 4, 5, 10)", tree.toString());
        tree.remove(5);
        assertNull(tree.find(5));
        assertEquals("(1, 2, 4, 10)", tree.toString());
        tree.remove(2);
        assertNull(tree.find(2));
        assertEquals("(1, 4, 10)", tree.toString());
        tree.remove(4);
        assertNull(tree.find(4));
        assertEquals("(1, 10)", tree.toString());
        tree.remove(10);
        assertNull(tree.find(10));
        assertEquals("(1)", tree.toString());
        tree.remove(1);
        assertNull(tree.find(1));
        assertEquals("()", tree.toString());
        Exception exception = null;
        try {
            empty.remove(1);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof ItemNotFoundException);
    }


    /**
     * Test BinarySearchTree findMin method for proper functionality
     */
    public void testFindMin() {
        assertEquals(1, tree.findMin(), 0.01);
        assertNull(empty.findMin());
        empty.insert(1);
        assertEquals(1, empty.findMin(), 0.01);
    }


    /**
     * Test BinarySearchTree findMax method for proper functionality
     */
    public void testFindMax() {
        assertEquals(10, tree.findMax(), 0.01);
        assertNull(empty.findMax());
        empty.insert(1);
        assertEquals(1, empty.findMax(), 0.01);
    }


    /**
     * Test BinarySearchTree find method for proper functionality
     */
    public void testFind() {
        for (int i = 1; i <= 10; i++) {
            if (i == 6) {
                assertNull(tree.find(i));
            }
            else {
                assertEquals(i, tree.find(i), 0.01);
            }
        }
        assertNull(empty.find(10));
    }


    /**
     * Test BinarySearchTree makeEmpty method for proper functionality
     */
    public void testMakeEmpty() {
        assertFalse(tree.isEmpty());
        tree.makeEmpty();
        assertTrue(tree.isEmpty());
    }


    /**
     * Test BinarySearchTree isEmpty method for proper functionality
     */
    public void testIsEmpty() {
        assertTrue(empty.isEmpty());
        assertFalse(tree.isEmpty());
    }


    /**
     * Test BinarySearchTree toString method for proper functionality
     */
    public void testToString() {
        assertEquals("(1, 2, 3, 4, 5, 7, 8, 9, 10)", tree.toString());
        assertEquals("()", empty.toString());
    }

}
