package recursion;

/**
 * Test Recursive FibonacciGenerator
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.3.2020
 * 
 */

public class FibonacciGeneratorTest extends student.TestCase {

    /**
     * test FibonacciGenerator's fib method
     */
    public void testFib() {
        FibonacciGenerator fg = new FibonacciGenerator();
        assertNotNull(fg);
        int[] fibSeq = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 };
        for (int i = 0; i < 10; i++) {
            assertEquals(fibSeq[i], FibonacciGenerator.fib(i), 0.01);
        }
        assertEquals(-1, FibonacciGenerator.fib(-10), 0.01);
    }
}
