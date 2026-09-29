package lab04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class CollectionUtilsTest {
    @ParameterizedTest
    @MethodSource("generator")
    void containsAny(String description, Collection<?> coll1, Collection<?> coll2, boolean expected){
        boolean result = CollectionUtils.containsAny(coll1, coll2);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> generator() {
        return Stream.of(

                Arguments.of("coll1 smaller, with common elements",
                        List.of(1,2),
                        List.of(1, 3, 4, 5), true),

                Arguments.of("coll2 smaller or equal, common element exists",
                        List.of(1, 2, 3, 4),
                        List.of(4, 5),
                        true),

                Arguments.of("coll2 smaller, no common element",
                        List.of(1, 2, 3, 4),
                        List.of(9, 8),
                        false),

                Arguments.of("equal size, common element",
                        List.of(1, 2),
                        List.of(2, 3),
                        true),

                Arguments.of("equal size, no common element",
                        List.of(1, 2),
                        List.of(3, 4),
                        false),

                Arguments.of("coll1 smaller, loop completes with no match",
                        List.of(7, 8),         
                        List.of(1, 2, 3, 4, 5),
                        false));
        }
    }
