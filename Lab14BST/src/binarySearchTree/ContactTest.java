package binarySearchTree;

/**
 * Test the Contact object and its methods
 * 
 * @author Matthew Grillo
 * @version 5.2.2020
 *
 */
public class ContactTest extends student.TestCase {
    private Contact contact;
    private Contact diffFirstLess;
    private Contact sameFirstdiffLastLess;
    private Contact sameFirstsameLastdiffNumLess;
    private Contact diffFirstGreat;
    private Contact sameFirstdiffLastGreat;
    private Contact sameFirstsameLastdiffNumGreat;
    private Contact same;
    private Contact not;


    /**
     * set up the tests
     */
    public void setUp() {
        contact = new Contact("b", "b", 100);

        diffFirstLess = new Contact("a", "b", 100);
        diffFirstGreat = new Contact("c", "b", 100);
        sameFirstdiffLastLess = new Contact("b", "a", 100);
        sameFirstdiffLastGreat = new Contact("b", "c", 100);
        sameFirstsameLastdiffNumLess = new Contact("b", "b", 99);
        sameFirstsameLastdiffNumGreat = new Contact("b", "b", 101);
        same = new Contact("b", "b", 100);
        not = null;
    }


    /**
     * Test Contact compareTo class for proper functionality
     */
    public void testCompareTo() {
        assertEquals(contact.compareTo(contact), 0, 0.01);
        assertEquals(contact.compareTo(same), 0, 0.01);
        assertTrue(contact.compareTo(diffFirstLess) > 0);
        assertTrue(contact.compareTo(sameFirstdiffLastLess) > 0);
        assertTrue(contact.compareTo(sameFirstsameLastdiffNumLess) > 0);
        assertTrue(contact.compareTo(diffFirstGreat) < 0);
        assertTrue(contact.compareTo(sameFirstdiffLastGreat) < 0);
        assertTrue(contact.compareTo(sameFirstsameLastdiffNumGreat) < 0);
        assertTrue(contact.compareTo(not) > 0);
    }

}
