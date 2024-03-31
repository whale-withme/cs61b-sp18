import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offbyone = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("d");
        String actual = "";
        for (int i = 0; i < "d".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("d", actual);
    } 


    @Test
    public void isPalindrmoeTest(){
        assertTrue(palindrome.isPalindrome("e"));
        assertFalse(palindrome.isPalindrome("null"));
        assertTrue(palindrome.isPalindrome("reacucaer"));
    }

    @Test
    public void ispalindOffbyoneTest(){
        assertTrue(palindrome.isPalindrome("acbdb", offbyone));
        assertFalse(palindrome.isPalindrome("null", offbyone));
        assertFalse(palindrome.isPalindrome(null, offbyone));

    }
}
