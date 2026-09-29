package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BoundaryTest {

    @Test
    void isUnsafe() {
        assertTrue(Boundary.isUnsafe(86));
    }

    @Test
    void isNotUnsafe() {
        assertFalse(Boundary.isUnsafe(85));
    }

}