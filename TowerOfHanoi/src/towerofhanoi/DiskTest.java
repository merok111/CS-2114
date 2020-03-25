// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

import student.TestCase;

/**
 * Test the Disk class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class DiskTest extends TestCase {
    private Disk smaller;
    private Disk bigger;
    private Disk not;
    private Disk same;


    /**
     * Set up tests
     */
    public void setUp() {
        this.smaller = new Disk(2);
        this.bigger = new Disk(5);
        this.not = null;
        this.same = new Disk(2);
    }


    /**
     * Test Disk compareTo method
     */
    public void testCompareTo() {
        Exception exception = null;
        try {
            this.smaller.compareTo(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        assertTrue(this.smaller.compareTo(this.bigger) < 0);
        assertTrue(this.bigger.compareTo(this.smaller) > 0);
        assertTrue(this.smaller.compareTo(this.smaller) == 0);
    }


    /**
     * Test Disk toString method
     */
    public void testToString() {
        assertEquals(this.smaller.toString(), "2");
        assertEquals(this.bigger.toString(), "5");
    }


    /**
     * Test Disk equals method
     */
    public void testEquals() {
        assertFalse(this.smaller.equals(this.not));
        assertTrue(this.smaller.equals(this.smaller));
        assertFalse(this.smaller.equals(this.bigger));
        assertTrue(this.smaller.equals(this.same));
        assertFalse(this.smaller.equals("String"));
    }
}
