// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

/**
 * Test the Skills class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class SkillsTest extends student.TestCase {
    private Skills one;
    private Skills two;
    private Skills three;
    private Skills four;
    private String diffClass;
    private Skills not;
    private Skills web1;
    private Skills web2;
    private Skills web3;
    private Skills web4;


    /**
     * set up the tests
     */
    public void setUp() {
        this.one = new Skills(1, 2, 3);
        this.two = new Skills(1, 2, 3);
        this.three = new Skills(4, 5, 6);
        this.four = new Skills(2, 3, 4);
        this.diffClass = "wow";

        this.web1 = new Skills(1, 1, 1);
        this.web2 = new Skills(2, 1, 1);
        this.web3 = new Skills(2, 2, 1);
        this.web4 = new Skills(2, 2, 2);
    }


    /**
     * Test Skills getAgriculture method for proper functionality
     */
    public void testGetAgriculture() {
        assertEquals(one.getAgriculture(), 1, 0.01);
    }


    /**
     * Test Skills getMedicine method for proper functionality
     */
    public void testGetMedicine() {
        assertEquals(one.getMedicine(), 2, 0.01);
    }


    /**
     * Test Skills getTechnology method for proper functionality
     */
    public void testGetTechnology() {
        assertEquals(one.getTechnology(), 3, 0.01);
    }


    /**
     * Test Skills isBelow method for proper functionality
     */
    public void testIsBelow() {
        assertTrue(one.isBelow(two));
        assertTrue(one.isBelow(three));
        assertTrue(one.isBelow(four));
        assertFalse(three.isBelow(four));
        assertTrue(four.isBelow(three));

        assertTrue(web1.isBelow(web2));
        assertTrue(web1.isBelow(web3));
        assertTrue(web1.isBelow(web4));
        assertFalse(web2.isBelow(web1));
        assertTrue(web2.isBelow(web3));
        assertTrue(web2.isBelow(web4));
        assertFalse(web3.isBelow(web1));
        assertFalse(web3.isBelow(web2));
        assertTrue(web3.isBelow(web4));
        assertFalse(web4.isBelow(web1));
        assertFalse(web4.isBelow(web2));
        assertFalse(web4.isBelow(web3));

    }


    /**
     * Test Skills toString method for proper functionality
     */
    public void testToString() {
        assertEquals(one.toString(), "A:1 M:2 T:3");
    }


    /**
     * Test Skills equals method for proper functionality
     */
    public void testEquals() {
        assertFalse(one.equals(not));
        assertTrue(one.equals(one));
        assertFalse(one.equals(diffClass));
        assertTrue(one.equals(two));
        assertFalse(one.equals(four));

        assertFalse(web1.equals(web2));
        assertFalse(web1.equals(web3));
        assertFalse(web1.equals(web4));
        assertFalse(web2.equals(web1));
        assertFalse(web2.equals(web3));
        assertFalse(web2.equals(web4));
        assertFalse(web3.equals(web1));
        assertFalse(web3.equals(web2));
        assertFalse(web3.equals(web4));
        assertFalse(web4.equals(web1));
        assertFalse(web4.equals(web2));
        assertFalse(web4.equals(web3));
    }
}
