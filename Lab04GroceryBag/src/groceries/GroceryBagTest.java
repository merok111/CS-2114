package groceries;

/**
 * Test the GroceryBag object and it's methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2020.02.12
 *
 */
public class GroceryBagTest extends student.TestCase {
    private GroceryBag bag1; // unordered
    private GroceryBag bag2; // unordered with repeat items
    private GroceryBag bag3; // ordered
    private GroceryBag bag4; // ordered with repeat items
    private GroceryBag same; // same contents as bag1
    private GroceryBag not; // null bag
    private String diffClass; // different class than a bag

    private GroceryBag intersection = new GroceryBag(); // intersection between
                                                        // bag1 and bag4


    /**
     * Sets up each test method.
     */
    public void setUp() {
        bag1 = new GroceryBag();
        bag1.add("apples");
        bag1.add("chips");
        bag1.add("yogurt");
        bag1.add("chicken");
        bag1.add("pasta");

        same = new GroceryBag();
        same.add("apples");
        same.add("chips");
        same.add("yogurt");
        same.add("chicken");
        same.add("pasta");

        bag2 = new GroceryBag();
        bag2.add("pizza");
        bag2.add("broccoli");
        bag2.add("pasta");
        bag2.add("pasta");
        bag2.add("apples");

        bag3 = new GroceryBag();
        bag3.add("apples");
        bag3.add("chicken");
        bag3.add("chicken");
        bag3.add("pasta");
        bag3.add("pizza");
        bag3.add("soda");
        bag3.add("yogurt");
        bag3.add("wheat");

        bag4 = new GroceryBag();
        bag4.add("chicken");
        bag4.add("chicken");
        bag4.add("pasta");
        bag4.add("pasta");
        bag4.add("yogurt");
        this.not = null;
        this.diffClass = "not";
        this.intersection = new GroceryBag();
        intersection.add("yogurt");
        intersection.add("chicken");
        intersection.add("pasta");
    }


    /**
     * test GroceryBag intersection method
     */
    public void testIntersection() {
        /*
         * You can test this method by a) defining 3 bags where one of them is
         * the intersection of the other 2 bags, as in the examples above, then
         * b) use assertTrue to check that the results will equal to the third
         * object.
         */
        GroceryBag result = bag1.intersection(bag4);
        assertTrue(result.equals(intersection));
        assertEquals(result.size(), intersection.size(), 0.01);
        for (int i = 0; i < result.size(); i++) {
            assertTrue(result.contents()[i].equals(intersection.contents()[i]));
        }
    }


    /**
     * test GroceryBag equality using the implements equals method
     */
    public void testEquals() {
        // test null class
        assertFalse(bag1.equals(not));
        // test same object
        assertTrue(bag1.equals(bag1));
        // test different class
        assertFalse(bag1.equals(diffClass));
        // different size
        assertFalse(bag1.equals(bag3));
        // same size different contents
        assertFalse(bag1.equals(bag2));
        // different object same contents
        assertTrue(bag1.equals(same));
    }
}
