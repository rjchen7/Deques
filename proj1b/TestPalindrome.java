import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne offByOne = new OffByOne();
    static OffByN offByFive = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String actualPalindrome = "noon";
        String fakePalindrome = "ryan";
        assertTrue(palindrome.isPalindrome(actualPalindrome));
        assertFalse(palindrome.isPalindrome(fakePalindrome));
        assertFalse(palindrome.isPalindrome(null));
    }

    @Test
    public void testIsPalindromeCC() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("abcb", offByOne));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("aba", null));
        assertFalse(palindrome.isPalindrome("aba", offByOne));
        assertTrue(palindrome.isPalindrome("af", offByFive));
        assertFalse(palindrome.isPalindrome("ae", offByFive));
    }
}
