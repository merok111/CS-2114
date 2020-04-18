package spacecolonies;

public class TestSkills extends student.TestCase {
    private Skills one;
    private Skills two;
    private Skills three;
    private Skills four;
    private String diffClass;
    private Skills not;


    public void setUp() {
        this.one = new Skills(1, 2, 3);
        this.two = new Skills(1, 2, 3);
        this.three = new Skills(4, 5, 6);
        this.four = new Skills(2, 3, 4);
        this.diffClass = "wow";
    }


    public void testGetAgriculture() {
        assertEquals(one.getAgriculture(), 1, 0.01);
    }


    public void testGetMedicine() {
        assertEquals(one.getMedicine(), 2, 0.01);
    }


    public void testGetTechnology() {
        assertEquals(one.getTechnology(), 3, 0.01);
    }


    public void testIsBelow() {
        assertTrue(one.isBelow(two));
        assertTrue(one.isBelow(three));
        assertTrue(one.isBelow(four));
        assertFalse(three.isBelow(four));
        assertTrue(four.isBelow(three));
    }


    public void testToString() {
        assertEquals(one.toString(), "A:1 M:2 T:3");
    }


    public void testEquals() {
        assertFalse(one.equals(not));
        assertTrue(one.equals(one));
        assertFalse(one.equals(diffClass));
        assertTrue(one.equals(two));
        assertFalse(one.equals(four));
    }
}
