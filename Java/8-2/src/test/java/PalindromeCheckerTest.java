import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PalindromeCheckerTest {

    private final PalindromeChecker checker = new PalindromeChecker();

    @Test
    public void testIsPalindrome() {
        // Palindromes
        assertTrue(checker.isPalindrome("hannah"));
        assertTrue(checker.isPalindrome("level"));
        // Test Pharese
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));
        // Not palindromes
        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("openai"));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(checker.isPalindrome("a"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(checker.isPalindrome(""));
    }
}
