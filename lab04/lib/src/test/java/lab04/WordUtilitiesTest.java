package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class WordUtilitiesTest {

    @ParameterizedTest
    @MethodSource("generator")
    void swapCase(String description, String input, String expected) {
        String result = WordUtilities.swapCase(input);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(

                Arguments.of("null input", null, null),

                Arguments.of("empty string", "", ""),

                Arguments.of("uppercase to lowercase", "HELLO", "hello"),

                Arguments.of("all lowercase",
                        "hello", "HELLO"),

                Arguments.of("lowercase after whitespace",
                        "hello world", "HELLO WORLD"),

                Arguments.of("mixed case",
                        "Hello World", "hELLO wORLD"),

                Arguments.of("with numbers",
                        "a1b", "A1B")
        );
        }
    }
