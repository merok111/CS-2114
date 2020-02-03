package employees;

/**
 * ExternalContractorTest will test all of the methods in ExternalContractor to
 * make
 * sure that they run and perform as expected
 *
 * @author Matthew Grillo mwgrillo
 * @version 1.29.2020
 */
public class ExternalContractorTest extends student.TestCase {
    private ExternalContractor testEmployee;


    /**
     * set up Employee objects
     */
    public void setUp() {
        this.testEmployee = new ExternalContractor("John Snow", 8546, 8.0);
    }


    /**
     * test ExternalContractor getHourlyRate method
     */
    public void testGetHourlyRate() {
        assertEquals(this.testEmployee.getHourlyRate('A'), 38.50, 0.01);
        assertEquals(this.testEmployee.getHourlyRate('B'), 41.75, 0.01);
        assertEquals(this.testEmployee.getHourlyRate('C'), 45.50, 0.01);
        assertEquals(this.testEmployee.getHourlyRate('F'), 0, 0.01);
    }


    /**
     * test ExternalContractor weeklyPay method
     */
    public void testWeeklyPay() {
        assertEquals(this.testEmployee.weeklyPay(17, 'A'), 38.50 * 17, 0.01);
        assertEquals(this.testEmployee.weeklyPay(18, 'B'), 41.75 * 18, 0.01);
        assertEquals(this.testEmployee.weeklyPay(19, 'C'), 45.50 * 19, 0.01);
        assertEquals(this.testEmployee.weeklyPay(20, 'F'), 0, 0.01);
    }
}
