// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Matthew Grillo (mwgrillo)
package spacecolonies;

/**
 * Test the ColonyCalculator class and its methods
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 4.19.2020
 *
 */
public class ColonyCalculatorTest extends student.TestCase {
    private ArrayQueue<Person> people;
    private Planet[] planets;
    private ColonyCalculator calculator;

    private Planet p1;
    private Planet p2;
    private Planet p3;

    private Person not;


    /**
     * Method to set up the tests
     */
    public void setUp() {
        this.people = new ArrayQueue<Person>();
        people.enqueue(new Person("Billy", 5, 5, 5, "p1"));
        people.enqueue(new Person("Joe", 5, 5, 5, "p1"));
        people.enqueue(new Person("Daniel", 5, 5, 5, "p2"));
        people.enqueue(new Person("hmm", 5, 5, 5, "p2"));

        p1 = new Planet("p1", 1, 1, 1, 1);
        p2 = new Planet("p2", 1, 1, 1, 1);
        p3 = new Planet("p3", 1, 1, 1, 1);
        this.planets = new Planet[] { p1, p2, p3, null };
        this.calculator = new ColonyCalculator(people, planets);
    }


    /**
     * Test ColonyCalculator constructor for exception
     */
    public void testConstructor() {
        Exception exception = null;
        try {
            new ColonyCalculator(null, planets);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
        assertTrue(exception instanceof IllegalArgumentException);
    }


    /**
     * Test ColonyCalculator getQueue method for proper functionality
     */
    public void testGetQueue() {
        assertEquals(people, this.calculator.getQueue());
    }


    /**
     * Test ColonyCalculator getPlanets method for proper functionality
     */
    public void testGetPlanets() {
        assertEquals(planets, ColonyCalculator.getPlanets());
    }


    /**
     * Test ColonyCalculator getPlanetForPerson method for proper functionality
     */
    public void testGetPlanetForPerson() {
        assertNull(calculator.getPlanetForPerson(not));
        Person person = this.people.dequeue();
        assertEquals(p1, calculator.getPlanetForPerson(person));
        p1.addPerson(person);
        person = this.people.dequeue();
        assertEquals(p3, calculator.getPlanetForPerson(person));
        p3.addPerson(person);
        person = this.people.dequeue();
        assertEquals(p2, calculator.getPlanetForPerson(person));
        p2.addPerson(person);
        person = this.people.dequeue();
        assertNull(calculator.getPlanetForPerson(person));

        Planet pref = new Planet("p4", 3, 3, 3, 1);
        Planet avail = new Planet("p5", 2, 2, 2, 10);
        Planet[] webps = { pref, avail };

        Person qualified = new Person("webcat i hate u", 5, 5, 5, "p4");
        Person notqualified1 = new Person("webcat i hate u", 1, 1, 1, "p4");
        Person notqualified2 = new Person("webcat i hate u", 2, 2, 2, "p4");
        Person availqualified = new Person("webcat i still hate u", 5, 5, 5,
            "");
        ArrayQueue<Person> q = new ArrayQueue<Person>();
        q.enqueue(qualified);
        ColonyCalculator cal2 = new ColonyCalculator(q, webps);

        assertNull(cal2.getPlanetForPerson(notqualified1));
        assertEquals(avail, cal2.getPlanetForPerson(notqualified2));
        assertEquals(pref, cal2.getPlanetForPerson(qualified));
        pref.addPerson(qualified);
        assertEquals(avail, cal2.getPlanetForPerson(qualified));
        assertEquals(avail, cal2.getPlanetForPerson(availqualified));

    }


    /**
     * Test ColonyCalculator accept and reject methods for proper functionality
     */
    public void testAccept() {
        assertTrue(calculator.accept());
        assertEquals(p1.getAvailability(), 0, 0.01);
        assertTrue(calculator.accept());
        assertEquals(p3.getAvailability(), 0, 0.01);
        assertTrue(calculator.accept());
        assertEquals(p2.getAvailability(), 0, 0.01);
        assertFalse(calculator.accept());
        calculator.reject();
        assertFalse(calculator.accept());
        calculator.reject();
    }


    /**
     * Test ColonyCalculator planetByNumber method for proper functionality
     */
    public void testPlanetByNumber() {
        assertEquals(p1, calculator.planetByNumber(1));
        assertEquals(p2, calculator.planetByNumber(2));
        assertEquals(p3, calculator.planetByNumber(3));
        assertNull(calculator.planetByNumber(-1));
        assertNull(calculator.planetByNumber(20));
    }


    /**
     * Test ColonyCalculator getPlanetIndex method for proper functionality
     */
    public void testGetPlanetIndex() {
        assertEquals(0, calculator.getPlanetIndex(p1.getName()));
        assertEquals(1, calculator.getPlanetIndex(p2.getName()));
        assertEquals(2, calculator.getPlanetIndex(p3.getName()));
        assertEquals(-1, calculator.getPlanetIndex("wowzers"));
    }
}
