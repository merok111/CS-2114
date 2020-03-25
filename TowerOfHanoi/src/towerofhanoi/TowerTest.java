// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package towerofhanoi;

import student.TestCase;

/**
 * Test the Tower class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.25.2020
 *
 */
public class TowerTest extends TestCase {
    private Tower tower;
    private Tower empty;


    /**
     * Set up tests
     */
    public void setUp() {
        this.tower = new Tower(Position.RIGHT);
        this.empty = new Tower(Position.DEFAULT);
    }


    /**
     * Test Tower postion method
     */
    public void testPosition() {
        assertEquals(this.tower.position(), Position.RIGHT);
        assertEquals(this.empty.position(), Position.DEFAULT);
    }


    /**
     * Test Tower push method
     */
    public void testPush() {
        Exception exception = null;
        try {
            this.tower.push(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);

        this.tower.push(new Disk(4));
        this.tower.push(new Disk(2));

        exception = null;
        try {
            this.tower.push(new Disk(6));
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalStateException);
    }
}
