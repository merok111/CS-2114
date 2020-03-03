package recursion;

/**
 * Test Recursive ReverseStringGenerator
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.3.2020
 * 
 */

public class PalindromeChecker {
    /**
     * Checks if a String is a palindrome
     * 
     * @param str
     *            String to check
     * @return true if the String is a valid palindrome, false if it is not
     */
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() <= 1) {
            return true;
        }
        str = str.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        if (str.charAt(0) != str.charAt(str.length() - 1)) {
            return false;
        }
        return isPalindrome(str.substring(1, str.length() - 1));
    }
}
