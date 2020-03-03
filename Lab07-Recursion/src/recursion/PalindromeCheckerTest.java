package recursion;

/**
 * Test Recursive PalindromeChecker
 * 
 * @author Matthew Grillo (mwgrillo)
 * @version 3.3.2020
 * 
 */

public class PalindromeCheckerTest extends student.TestCase {

    /**
     * test PalindromeChecker isPalindrome method
     */
    public void testIsPalindrome() {
        PalindromeChecker pc = new PalindromeChecker();
        assertNotNull(pc);
        assertTrue(PalindromeChecker.isPalindrome("eye"));
        assertTrue(PalindromeChecker.isPalindrome("Eye"));
        assertFalse(PalindromeChecker.isPalindrome(null));
        assertTrue(PalindromeChecker.isPalindrome(""));
        assertFalse(PalindromeChecker.isPalindrome("kejbvkdl"));

        assertTrue(PalindromeChecker.isPalindrome(
            "Go hang a salami, I'm a lasagna hog."));
        assertTrue(PalindromeChecker.isPalindrome(
            "A Toyota! Race fast, safe car. A Toyota."));
        assertTrue(PalindromeChecker.isPalindrome(
            "\"Tie Mandie,\" I'd name it."));
        assertTrue(PalindromeChecker.isPalindrome("Wonton? Not now."));
    }
}
