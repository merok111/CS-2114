// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

/**
 * Test the Planet class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class PlanetTest extends student.TestCase {
    private Planet p1;
    private Planet p2;
    private Planet p3;
    private Person[] randos;

    private Planet not;
    private String diffClass;


    /**
     * set up the tests
     */
    public void setUp() {
        p1 = new Planet("p1", 2, 2, 2, 1);
        p2 = new Planet("p2", 1, 1, 1, 10);
        randos = new Person[10];
        for (int i = 0; i < 10; i++) {
            String name = (int)Math.random() * 1000 + "";
            int skill = (int)Math.random() * 4 + 1;
            randos[i] = new Person(name, skill, skill, skill, p2.getName());
            p2.addPerson(randos[i]);
        }

        diffClass = "wow";
        p3 = new Planet("p1", 2, 2, 2, 1);
    }


    /**
     * Test Planet getName method for proper functionality
     */
    public void testGetName() {
        assertEquals(p1.getName(), "p1");
    }


    /**
     * Test Planet setName method for proper functionality
     */
    public void testSetName() {
        p1.setName("setName");
        assertEquals(p1.getName(), "setName");
    }


    /**
     * Test Planet getMinSkills method for proper functionality
     */
    public void testGetMinSkills() {
        assertEquals(new Skills(2, 2, 2), p1.getMinSkills());
    }


    /**
     * Test Planet getPopulation method for proper functionality
     */
    public void testGetPopulation() {
        Person[] pop = p1.getPopulation();
        assertEquals(1, pop.length, 0.01);
        assertNull(pop[0]);
    }


    /**
     * Test Planet getPopulationSize method for proper functionality
     */
    public void testGetPopulationSize() {
        assertEquals(0, p1.getPopulationSize(), 0.01);
    }


    /**
     * Test Planet getCapacity method for proper functionality
     */
    public void testGetCapacity() {
        assertEquals(1, p1.getCapacity(), 0.01);
    }


    /**
     * Test Planet getAvailability method for proper functionality
     */
    public void testGetAvailability() {
        assertEquals(1, p1.getAvailability(), 0.01);
    }


    /**
     * Test Planet isFull method for proper functionality
     */
    public void testIsFull() {
        assertFalse(p1.isFull());
        assertTrue(p2.isFull());
    }


    /**
     * Test Planet addPerson method for proper functionality
     */
    public void testAddPerson() {
        assertFalse(p1.addPerson(new Person("failure", 1, 1, 1, "")));
        assertTrue(p1.addPerson(new Person("tester joe", 2, 2, 2, "")));
        assertFalse(p1.addPerson(new Person("full", 2, 2, 2, "")));
    }


    /**
     * Test Planet isQualified method for proper functionality
     */
    public void testIsQualified() {
        assertTrue(p1.isQualified(new Person("yes", 5, 5, 5, "")));
        assertFalse(p1.isQualified(new Person("no", 1, 1, 1, "")));
    }


    /**
     * Test Planet toString method for proper functionality
     */
    public void testToString() {
        assertEquals(
            "p1, population 0 (cap: 1), Requires: A >= 2, M >= 2, T >= 2", p1
                .toString());
        assertEquals(
            "p2, population 10 (cap: 10), Requires: A >= 1, M >= 1, T >= 1", p2
                .toString());
    }


    /**
     * Test Planet equals method for proper functionality
     */
    public void testEquals() {
        assertFalse(p1.equals(not));
        assertTrue(p1.equals(p1));
        assertFalse(p1.equals(diffClass));
        assertTrue(p1.equals(p3));
        assertFalse(p1.equals(p2));
    }


    /**
     * Test Planet compareTo method for proper functionality
     */
    public void testCompareTo() {
        assertTrue(p1.compareTo(p2) > 0);
        assertTrue(p1.compareTo(null) > 0);
        assertTrue(p2.compareTo(p1) < 0);
        assertEquals(0, p1.compareTo(p1), 0.01);
    }
}
