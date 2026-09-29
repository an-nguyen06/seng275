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

class LeapYearTest {

    private boolean is;

    //case1: a year that divides 400 is always a leap year
    @Property
    void multipleOf400IsLeapYear(@ForAll("multiplesOf400") int year) {
        assertTrue(LeapYear.isLeapYear(year));
    }

    //case2: a year that divides 100 but not 400 is not a leap year
    @Property
    void multipleOf100Not400IsNotLeapYear(@ForAll("multiplesOf100Not400") int year){
        assertFalse(LeapYear.isLeapYear(year));
    }

    //case3: a year that divides 4 but not 100 is a leap year
    @Property
    void multiplesOf4Not100IsLeapYear(@ForAll("multiplesOf4Not100") int year){
        assertTrue(LeapYear.isLeapYear(year));
    }

    //case4: a year that doesn't divide 4 is not a leap year
    @Property
    void notMultiplesOf4IsNotLeapYear(@ForAll("notMultiplesOf4") int year){
        assertFalse(LeapYear.isLeapYear(year));
    }

    //case5: if year < 1, not a valid year
    @Property
    void invalidYearThrows(@ForAll("invalidYears") int year){
        assertThrows(IllegalArgumentException.class, () -> LeapYear.isLeapYear(year));
    }

    //providers

    @Provide
    Arbitrary<Integer> multiplesOf400() {
        return Arbitraries.integers().filter(n -> n >= 1 && n % 400 == 0);
    }

    @Provide
    Arbitrary<Integer> multiplesOf100Not400() {
        return Arbitraries.integers().filter(n -> n >= 1 && n % 100 == 0 && n % 400 != 0);
    }

    @Provide
    Arbitrary<Integer> multiplesOf4Not100() {
        return Arbitraries.integers().filter(n -> n >= 1 && n % 4 == 0 && n % 100 != 0);
    }

    @Provide
    Arbitrary<Integer> notMultiplesOf4() {
        return Arbitraries.integers().filter(n -> n >= 1 && n % 4 != 0);
    }

    @Provide
    Arbitrary<Integer> invalidYears() {
        return Arbitraries.integers().filter(n -> n < 1);
    }
}