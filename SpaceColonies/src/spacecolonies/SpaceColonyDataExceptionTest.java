// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

/**
 * Test the SpaceColonyDataException class
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class SpaceColonyDataExceptionTest extends student.TestCase {

    private String test;


    /**
     * set up tests
     */
    public void setUp() {
        this.test = "test";
    }


    /**
     * test a creation of the exception
     */
    public void testException() {
        Exception e = new SpaceColonyDataException("test");
        assertEquals(e.getLocalizedMessage(), test);
    }

}
