package Introduction;

import student.TestCase;

/**
 * CalculatorTest will test all of the methods in Calculator to make
 * sure that they run and perform as expected
 *
 * @author Matthew Grillo mwgrillo
 * @version 1.22.2020
 */

public class CalculatorTest extends TestCase {
    private Calculator norm;
    private Calculator divByZero;


    /**
     * sets up each test method before it runs
     */
    public void setUp() {
        this.norm = new Calculator(2, 4);
        this.divByZero = new Calculator(1, 0);
    }


    /**
     * test the first input into the calculator parameters
     */
    public void testGetFirstInput() {
        assertEquals(norm.getFirstInput(), 2, 0.01);
    }


    /**
     * test the second input into the calculator parameters
     */
    public void testGetSecondInput() {
        assertEquals(norm.getSecondInput(), 4, 0.01);
    }


    /**
     * test the multiplication method in the Calculator object
     */
    public void testMultiply() {
        assertEquals(norm.multiply(), 8, 0.01);
    }


    /**
     * test the division method in the Calculator object
     */
    public void testDivide() {
        assertEquals(norm.divide(), 0.5, 0.01);
        assertTrue(Double.isNaN(divByZero.divide()));
    }


    /**
     * test the addition method in the Calculator object
     */
    public void testAdd() {
        assertEquals(norm.add(), 6, 0.01);
    }


    /**
     * test the subtraction method in the Calculator object
     */
    public void testSubtract() {
        assertEquals(norm.subtract(), -2, 0.01);
    }


    /**
     * test
     */
    public void testPower() {
        assertEquals(norm.power(), 16, 0.01);
    }

}
