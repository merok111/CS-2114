package icecream;

/**
 * Test the IceCreamCone object and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 2020.02.12
 */
public class IceCreamConeTest extends student.TestCase {
    private IceCreamCone cone1;
    private String addFlavor;

    private IceCreamCone same;
    private IceCreamCone diff;

    private IceCreamCone empty;
    private IceCreamCone not;


    /**
     * Set up tests
     */
    public void setUp() {
        cone1 = new IceCreamCone();
        cone1.addScoop("vanilla");
        cone1.addScoop("chocolate");
        cone1.addScoop("strawberry");

        addFlavor = "peanut butter";

        empty = new IceCreamCone();

        same = new IceCreamCone();
        same.addScoop("vanilla");
        same.addScoop("chocolate");
        same.addScoop("strawberry");

        diff = new IceCreamCone();
        diff.addScoop("banana");
        diff.addScoop("steve");
        diff.addScoop("fudge");
        
        not = null;
    }


    /**
     * test IceCreamCone eatScoop method
     */
    public void testEatScoop() {
        // test that the number of scoops goes down
        assertEquals(cone1.numScoops(), 3, 0.01);
        cone1.eatScoop();
        assertEquals(cone1.numScoops(), 2, 0.01);
        // test with an empty cone
        assertNull(empty.eatScoop());
    }


    /**
     * test IceCreamCone addScoop method
     */
    public void testAddScoop() {
        assertEquals(cone1.numScoops(), 3, 0.01);
        cone1.addScoop(addFlavor);
        assertEquals(cone1.numScoops(), 4, 0.01);
        cone1.addScoop(null);
        assertEquals(cone1.numScoops(), 4, 0.01);
    }


    /**
     * test IceCreamCone equals method
     */
    public void testNumScoops() {
        assertEquals(cone1.numScoops(), 3, 0.01);
        cone1.addScoop(addFlavor);
        assertEquals(cone1.numScoops(), 4, 0.01);
        cone1.eatScoop();
        assertEquals(cone1.numScoops(), 3, 0.01);
    }


    /**
     * test IceCreamCone contains method
     */
    public void testContains() {
        assertFalse(cone1.contains(addFlavor));
        assertTrue(cone1.contains("vanilla"));
        assertFalse(cone1.contains(null));
        assertFalse(empty.contains(addFlavor));
    }


    /**
     * test IceCreamCone emptyCone method
     */
    public void testEmptyCone() {
        assertTrue(empty.emptyCone());
        assertFalse(cone1.emptyCone());
    }


    /**
     * test IceCreamCone currentScoop method
     */
    public void testCurrentScoop() {
        cone1.addScoop(addFlavor);
        assertEquals(cone1.currentScoop(), addFlavor);
        assertNull(empty.currentScoop());
    }


    /**
     * test IceCreamCone toString method
     */
    public void testToString() {
        assertEquals(cone1.toString(), "[vanilla, chocolate, strawberry]");
        assertEquals(empty.toString(), "[]");
    }


    /**
     * test IceCreamCone equals method
     */
    public void testEquals() {
        assertTrue(cone1.equals(cone1));
        assertFalse(cone1.equals(not));
        assertFalse(cone1.equals(addFlavor));
        assertTrue(cone1.equals(same));
        assertFalse(cone1.equals(diff));
    }
}
