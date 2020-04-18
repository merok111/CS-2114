package spacecolonies;

public class TestPerson extends student.TestCase {
    private Person one;
    private Person two;
    private Person three;
    private Person four;
    private Person not;
    private String diffClass;


    public void setUp() {
        one = new Person("Joe", 1, 2, 3, "Mars");
        two = new Person("Joe", 1, 2, 3, "Mars");
        three = new Person("Jack", 3, 3, 3, "");

        diffClass = "wow";
    }


    public void testGetName() {

    }


    public void testGetSkills() {

    }


    public void testGetPlanetName() {

    }


    public void testToString() {

    }


    public void testEquals() {
        // this.name.equals(other.name) && this.skills.equals(other.skills) &&
        // this.planetPreference.equals(other.planetPreference)

    }
}
