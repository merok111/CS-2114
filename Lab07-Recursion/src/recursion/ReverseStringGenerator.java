package recursion;

/**
 * Recursive String reverser
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.3.2020
 * 
 */

public class ReverseStringGenerator {
    /**
     * Solves and returns a String in reverse character order
     * 
     * @param str
     *            String to be reversed
     * @return reversed String
     */
    public static String reverse(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }
}
