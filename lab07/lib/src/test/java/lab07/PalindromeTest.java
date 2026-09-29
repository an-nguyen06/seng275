package lab07;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.StringLength;
import net.jqwik.api.constraints.UniqueElements;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

class PalindromeTest {

    /*
     * Try testing the following cases:
     *  - any string, followed by the reverse of that string is a palindrome.
     *  - any string, followed by a single character, then the reverse of the string is a palindrome.
     *  - Any string made up of unique characters of length 2 or greater is not a palindrome.
     *  - Any palindrome set to uppercase is still a palindrome.
     */


    static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    //case1: abc + cba = abccba -> always a palindrome
    @Property
    void stringPlusReverseIsPalindrome(
            @ForAll @AlphaChars @StringLength(min = 1, max = 10) String half) {
        String palindrome = half + reverse(half);
        assertTrue(Palindrome.isPalindrome(palindrome));
    }

    //case2: abc + x + cba = abcxcba -> always a palindrome
    @Property
    void stringPlusCharReverseIsPalindrome(
            @ForAll @AlphaChars @StringLength(min = 1, max = 10) String half,
            @ForAll @AlphaChars char middle
    ){
        String palindrome = half + middle + reverse(half);
        assertTrue(Palindrome.isPalindrome(palindrome));
    }

    //case3: string with unique characters and length >= 2 -> not a palindrome
    @Property
    void uniqueCharsStringIsNotPalindrome(
            @ForAll @AlphaChars @UniqueElements @Size(min = 2) char [] chars
    ){
        String word = new String(chars);
        assertFalse(Palindrome.isPalindrome(word));
    }

    //case4: palindrome in uppercase is still palindrome
    @Property
    void palindromeToUpperCaseIsStillPalindrome(
            @ForAll @AlphaChars @StringLength(min = 1, max = 10) String half
    ){
        String palindrome = half + reverse(half);
        assertTrue(Palindrome.isPalindrome(palindrome.toUpperCase()));
    }

}