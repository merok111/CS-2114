package recursion;

/**
 * Recursive Fibonacci Sequence to find the nth number
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.3.2020
 * 
 */

public class FibonacciGenerator {
    /**
     * Calculates and return the nth number of the Fibonacci Sequence
     * 
     * @param n
     *            nth number
     * @return nth Fibonacci number
     */
    public static int fib(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
