package lab07;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;
import net.jqwik.api.*;
import net.jqwik.api.arbitraries.*;
import net.jqwik.api.constraints.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

class ColoursTest {

    //case1: valid inputs
    @Property
    void validRGBPackedCorrectly(
            @ForAll @IntRange(min = 0, max = 225) int r,
            @ForAll @IntRange(min = 0, max = 225) int g,
            @ForAll @IntRange(min = 0, max = 225) int b){
        int expected = r * 65536 + g * 256 + b;
        assertEquals(expected, Colours.rgbBytesToInt(r,g,b));
    }

    //case2: negative inputs, so throw IllegalArgumentException
    @Property
    void negativeValueThrows(
            @ForAll("invalidNegative") int r,
            @ForAll @IntRange(min = 0, max = 225) int g,
            @ForAll @IntRange(min = 0, max = 225) int b) {
        assertThrows(IllegalArgumentException.class, () -> Colours.rgbBytesToInt(r, g, b));
    }

    //case3: inputs > 225, also throw IllegalArgumentException
    @Property
    void tooLargeValueThrows(
            @ForAll("invalidTooLarge") int r,
            @ForAll @IntRange(min = 0, max = 255) int g,
            @ForAll @IntRange(min = 0, max = 225) int b) {
        assertThrows(IllegalArgumentException.class, () -> Colours.rgbBytesToInt(r, g, b));
    }

    @Provide
    Arbitrary<Integer> invalidNegative() {
        return Arbitraries.integers().filter(n -> n < 0);
    }

    @Provide
    Arbitrary<Integer> invalidTooLarge() {
        return Arbitraries.integers().filter(n -> n > 255);
    }
}