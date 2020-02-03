package employees;

/**
 * PartTimeEmployeeTest will test all of the methods in PartTimeEmployee to make
 * sure that they run and perform as expected
 *
 * @author Matthew Grillo mwgrillo
 * @version 1.29.2020
 */
public class PartTimeEmployeeTest extends student.TestCase {
    private PartTimeEmployee testEmployee;


    /**
     * set up Employee object
     */
    public void setUp() {
        this.testEmployee = new PartTimeEmployee("John Snow", 8546, 8.0, 17);
    }


    /**
     * test PartTimeEmployee getHours method
     */
    public void testGetHoursWorked() {
        assertEquals(this.testEmployee.getHoursWorked(), 17, 0.01);
    }


    /**
     * test PartTimeEmployee weeklyPay method
     */
    public void testWeeklyPay() {
        assertEquals(this.testEmployee.weeklyPay(), 17 * 8.0, 0.01);
    }
}
