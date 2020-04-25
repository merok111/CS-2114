// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

/**
 * Test the Person class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class PersonTest extends student.TestCase {
    private Person one;
    private Person two;
    private Person three;
    private Person not;
    private String diffClass;
    private Person name;
    private Person skills;


    /**
     * set up the tests
     */
    public void setUp() {
        one = new Person("Joe", 1, 2, 3, "Mars");
        two = new Person("Joe", 1, 2, 3, "Mars");
        three = new Person("Jack", 3, 3, 3, "");
        name = new Person("Joe", 1, 1, 1, "Mars");
        skills = new Person("Joe", 1, 2, 3, "Jupiter");

        diffClass = "wow";
    }


    /**
     * test Person getName method for proper functionality
     */
    public void testGetName() {
        assertEquals("Joe", one.getName());
        assertEquals("Joe", two.getName());
        assertEquals("Jack", three.getName());
    }


    /**
     * test Person getSkills method for proper functionality
     */
    public void testGetSkills() {
        assertEquals(one.getSkills(), new Skills(1, 2, 3));
        assertEquals(two.getSkills(), new Skills(1, 2, 3));
        assertEquals(three.getSkills(), new Skills(3, 3, 3));
    }


    /**
     * test Person getPlanetPreference method for proper functionality
     */
    public void testGetPlanetPreference() {
        assertEquals(one.getPlanetPreference(), "Mars");
        assertEquals(two.getPlanetPreference(), "Mars");
        assertEquals(three.getPlanetPreference(), "");
    }


    /**
     * test Person toString method for proper functionality
     */
    public void testToString() {
        assertEquals("Joe A:1 M:2 T:3 Wants: Mars", one.toString());
        assertEquals("Joe A:1 M:2 T:3 Wants: Mars", two.toString());
        assertEquals("Jack A:3 M:3 T:3", three.toString());
    }


    /**
     * test Person equals method for proper functionality
     */
    public void testEquals() {
        // this.name.equals(other.name) && this.skills.equals(other.skills) &&
        // this.planetPreference.equals(other.planetPreference)
        assertFalse(one.equals(not));
        assertFalse(one.equals(diffClass));
        assertTrue(one.equals(one));
        assertTrue(one.equals(two));
        assertFalse(one.equals(three));
        assertFalse(one.equals(name));
        assertFalse(one.equals(skills));
    }
}
