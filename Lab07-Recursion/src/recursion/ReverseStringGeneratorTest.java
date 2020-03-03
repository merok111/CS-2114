package recursion;

/**
 * Test Recursive ReverseStringGenerator
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.3.2020
 * 
 */

public class ReverseStringGeneratorTest extends student.TestCase {

    /**
     * test ReverseStringGenerator reverse method
     */
    public void testReverse() {
        ReverseStringGenerator rsg = new ReverseStringGenerator();
        assertNotNull(rsg);
        assertEquals("gnirtStseT", ReverseStringGenerator.reverse(
            "TestString"));
        assertNull(ReverseStringGenerator.reverse(null));
        assertEquals("", ReverseStringGenerator.reverse(""));
    }
}
