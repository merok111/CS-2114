package groceries;

/**
 * Test class for ArrayBasedBag
 * 
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.03.30
 * @author Gracie (sgrace)
 * @version 2016.02.09
 */
public class ArrayBasedBagTest extends student.TestCase {
    private ArrayBasedBag bag;
    private ArrayBasedBag bag2;


    /**
     * Set up for all test methods. Runs before every test.
     */
    public void setUp() {
        bag = new ArrayBasedBag();
        bag.add("apples");
        bag.add("nuts");
        bag.add("chips");

        bag2 = new ArrayBasedBag(10);
        bag2.add("pretzels");
        bag2.add("apples");
        bag2.add("yogurt");
    }


    /**
     * Test method for the constructors.
     */
    public void testConstructors() {
        String[] contents = bag.contents();
        assertEquals(100, contents.length);

        String[] contents2 = bag2.contents();
        assertEquals(10, contents2.length);
    }


    /**
     * Test method for add. Items should only be added when below capacity.
     */
    public void testAdd() {
        bag2.add("orange juice");
        bag2.add("carrots");
        bag2.add("bananas");
        bag2.add("chips");
        bag2.add("pickles");
        bag2.add("grapes");
        assertTrue(bag2.add("soda"));

        // bag should not add 11th item since it's beyond its capacity
        assertFalse(bag2.add("bread"));
    }


    /**
     * Test method for remove. Only existing items should be removed.
     */
    public void testRemove() {
        assertFalse(bag.remove("milk"));
        assertEquals(bag.size(), 3);

        assertTrue(bag.remove("chips"));
        assertEquals(bag.size(), 2);
    }


    /**
     * Test method for contains.
     */
    public void testContains() {
        assertFalse(bag.contains("milk"));
        assertTrue(bag.contains("nuts"));
    }


    /**
     * Test method for empty.
     */
    public void testIsEmpty() {
        assertFalse(bag.isEmpty());

        bag.remove("apples");
        bag.remove("nuts");
        bag.remove("chips");

        assertTrue(bag.isEmpty());
    }


    /**
     * Test method for size.
     */
    public void testSize() {
        assertEquals(bag.size(), 3);

        bag.remove("apples");
        bag.remove("nuts");
        bag.remove("chips");

        assertEquals(bag.size(), 0);

        bag.add("chips");
        assertEquals(bag.size(), 1);
    }


    /**
     * Test method for contents. Should return array of bag.
     */
    public void testContents() {
        String[] contents = bag.contents();
        assertEquals(contents[0], "apples");
        assertEquals(contents[1], "nuts");
        assertEquals(contents[2], "chips");
    }


    /**
     * Test method for toString. Should be in brackets with commas.
     */
    public void testToString() {
        assertEquals(bag.toString(), "[apples, nuts, chips]");

        ArrayBasedBag bagEmpty = new ArrayBasedBag();
        assertEquals(bagEmpty.toString(), "[]");

    }


    /**
     * Test method for occurrence.
     */
    public void testOccurrence() {
        assertEquals(1, bag.occurrence("nuts"));

        bag.add("nuts");
        bag.add("nuts");

        assertEquals(3, bag.occurrence("nuts"));
    }
}
