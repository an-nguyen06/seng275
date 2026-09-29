package lab04;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

        Calculator calculator = new Calculator();

        @Test
        void testALessThan2() {
            assertEquals(-5, calculator.ComplexAdd(1, 4));
            // kills mutant removing * -1
        }

        @Test
        void testAGreaterOrEqual2() {
            assertEquals(6, calculator.ComplexAdd(2, 4));
        }

        @Test
        void testBoundaryAEquals2() {
            assertEquals(6, calculator.ComplexAdd(2, 4));
            // kills mutant: < -> <=
        }

        @Test
        void testZeroCase() {
            assertEquals(-4, calculator.ComplexAdd(0, 4));
        }

        @Test
        void testNegativeA() {
            assertEquals(-1, calculator.ComplexAdd(-1, 2));
        }
    }
/*
Test Suite Explanation:
- both branches were covered: a < 2 and a >= 2
- test boundary value: a = 2
- line coverage: achieve 100%
- mutation coverage: achieve 100%, all mutants killed
 */