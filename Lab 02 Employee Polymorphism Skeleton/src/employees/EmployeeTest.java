package employees;

/**
 * EmployeeTest will test all of the methods in Employee to make
 * sure that they run and perform as expected
 *
 * @author Matthew Grillo mwgrillo
 * @version 1.29.2020
 */
public class EmployeeTest extends student.TestCase {
    private Employee testEmployee;
    private Employee equality1;
    private Object equality2;
    private Employee equality3;
    private Employee nonEquality1;
    private Object nonEquality2;
    private Employee not;


    /**
     * set up the Employee objects
     */
    public void setUp() {
        // Create an Employee object with test information
        this.testEmployee = new Employee("John Snow", 8546, 8.0);
        this.equality1 = new Employee("John Snow", 8546, 8.0);
        this.equality2 = new Employee("John Snow", 8546, 8.0);
        this.equality3 = this.testEmployee;
        this.nonEquality1 = new Employee("Not John Snow", 1111, 7.0);
        this.nonEquality2 = new Object();
        this.not = null;
    }


    /**
     * test Employee getName method
     */
    public void testGetName() {
        assertEquals(this.testEmployee.getName(), "John Snow");
    }


    /**
     * test Employee getEmployeeId method
     */
    public void testGetEmployeeId() {
        assertEquals(this.testEmployee.getEmployeeId(), 8546);
    }


    /**
     * test Employee getHourlyRate method
     */
    public void testGetHourlyRate() {
        System.out.println(this.testEmployee.getHourlyRate());
        assertEquals(this.testEmployee.getHourlyRate(), 8.0, 0.01);
    }


    /**
     * test Employee weeklyPay method
     */
    public void testWeeklyPay() {
        assertEquals(this.testEmployee.weeklyPay(), 8.0 * 40, 0.01);
    }


    /**
     * test Employee equals method
     */
    public void testEquals() {
        assertTrue(this.testEmployee.equals(equality1));
        assertTrue(this.testEmployee.equals(equality2));
        assertTrue(this.testEmployee.equals(equality3));
        assertFalse(this.testEmployee.equals(nonEquality1));
        assertFalse(this.testEmployee.equals(nonEquality2));
        assertFalse(this.testEmployee.equals(not));
    }
}
