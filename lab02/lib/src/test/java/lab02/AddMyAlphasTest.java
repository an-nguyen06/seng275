package lab02;

import org.apache.commons.math3.analysis.function.Add;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddMyAlphasTest {
    @Test
    void emptyStringReturnsZero() {
        AddMyAlphas a = new AddMyAlphas();
        assertEquals(0, a.add(""));
    }

    @Test
    void singleNumberReturnsValue() {
        AddMyAlphas a = new AddMyAlphas();
        assertEquals(5, a.add("5"));
    }

    @Test
    void twoNumbersCommaSeparated() {
        AddMyAlphas a = new AddMyAlphas();
        assertEquals(3, a.add("1,2"));
    }

    @Test
    void someNumbers() {
        AddMyAlphas a = new AddMyAlphas();
        assertEquals(10, a.add("1,2,3,4"));
    }

    @Test
    void newlineAndCommaDelimiters() {
        AddMyAlphas a = new AddMyAlphas();
        assertEquals(6, a.add("1\n2,3"));
    }

    @Test
    void negativesNotAllowed() {
        AddMyAlphas a = new AddMyAlphas();

        Exception e = assertThrows(IllegalArgumentException.class,
                () -> a.add("2,-4,3,-5"));

        assertEquals("Negatives not allowed: -4,-5", e.getMessage());
    }

    @Test
    void ignoreLargeNumbers() {
        AddMyAlphas a = new AddMyAlphas();
        assertEquals(2, a.add("1001,2"));
    }

    @Test
    void customDelimiter() {
        AddMyAlphas a = new AddMyAlphas();
        assertEquals(3, a.add("//;\n1;2"));
    }
}

