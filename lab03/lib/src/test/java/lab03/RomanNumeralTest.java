package lab03;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RomanNumeralTest {
    RomanNumeral roman = new RomanNumeral();

    @Test
    void convert_SingleSymbol_vs_InvalidRepetition() {
        assertEquals(1, roman.convert("I"));
        assertThrows(IllegalArgumentException.class, () -> roman.convert("IIII"));
    }
    @Test
    void convert_AdditiveNotation_vs_InvalidAdditive() {
        assertEquals(6, roman.convert("VI"));
        assertThrows(IllegalArgumentException.class, () -> roman.convert("VV"));
    }
    @Test
    void convert_SubtractiveNotation_vs_InvalidSubtractive() {
        assertEquals(4, roman.convert("IV"));
        assertThrows(IllegalArgumentException.class, () -> roman.convert("IIII"));
    }

    @Test
    void convert_MixedNotation_vs_InvalidOrder() {
        assertEquals(14, roman.convert("XIV"));
        assertThrows(IllegalArgumentException.class, () -> roman.convert("DCM"));
    }

    @Test
    void convert_UppercaseValid_vs_LowercaseInvalid() {
        assertEquals(10, roman.convert("X"));
        assertThrows(IllegalArgumentException.class, () -> roman.convert("x"));
    }
    @Test
    void convert_NonEmptyValid_vs_EmptyInvalid() {
        // Empty input has no numeric meaning
        assertEquals(5, roman.convert("V"));
        assertThrows(IllegalArgumentException.class, () -> roman.convert(""));
    }


}
