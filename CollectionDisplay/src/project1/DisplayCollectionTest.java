// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)

package project1;

import java.util.ArrayList;
import bag.BagInterface;

/**
 * Test the DisplayCollection class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2020-02-05
 *
 */
public class DisplayCollectionTest extends student.TestCase {
    /**
     * string array constant to test the bag contents
     */
    public static final String[] STRINGS = { "red circle", "blue circle",
        "red square", "blue square" };


    /**
     * Set up the JUnit test
     */
    public void setUp() {
        // nothing needs to be initialized
    }


    /**
     * test DisplayCollection bag contents to make sure that they are all from
     * the array
     */
    public void testBagContents() {
        DisplayCollection dc = new DisplayCollection();
        BagInterface<String> bag = dc.getItemBag();
        boolean contain = false;
        while (bag.getCurrentSize() > 0) {
            String content = bag.remove();
            for (String s : STRINGS) {
                if (s.equals(content)) {
                    contain = true;
                }
            }
            assertTrue(contain);
        }
    }


    /**
     * test DisplayCollection to make sure that the bag is within size 5 and 15
     */
    public void testBagSize() {
        ArrayList<Integer> sizes = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            DisplayCollection dc = new DisplayCollection();
            BagInterface<String> bag = dc.getItemBag();
            int size = bag.getCurrentSize();
            sizes.add(size);
            assertTrue(size >= 5 && size <= 15);
            assertFalse(size < 5 || size > 15);
        }
        assertTrue(sizes.contains(15));
        assertTrue(sizes.contains(5));
    }

}
