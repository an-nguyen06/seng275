package lab03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class SpecificationTest {

    //testing insideDisplayArea with HD mode (1280 x 720)
    //valid range: x: [0, 1279]
    //             y: [0, 719]

    @Test
    void insideDisplayAreaHD1() { // ON point for x and y lower bounds
        assertTrue(Specification.insideDisplayArea(0,0));
    }

    @Test
    void insideDisplayAreaHD2() { // ON point for x and y upper bounds
        assertTrue(Specification.insideDisplayArea(1279, 719));
    }

    // OFF point tests
    @Test
    void insideDisplayAreaHD3() {
        assertFalse(Specification.insideDisplayArea(-1, 360));
    }

    @Test
    void insideDisplayAreaHD4() {
        assertFalse(Specification.insideDisplayArea(1280, 360));
    }

    @Test
    void insideDisplayAreaHD5() {
        assertFalse(Specification.insideDisplayArea(640, -1));
    }

    @Test
    void insideDisplayAreaHD6() {
        assertFalse(Specification.insideDisplayArea(640, 720));
    }

    //test insideDisplayArea with FHD mode (1920 x 1080)
    //valid range: x: [0,1919]
    //             y: [0,1079]

    @Test
    void insideDisplayAreaFHD1() {
        Specification.setDefinition(1); // Switch to FHD
        assertTrue(Specification.insideDisplayArea(0, 0));
    }

    @Test
    void insideDisplayAreaFHD2() {
        Specification.setDefinition(1);
        assertTrue(Specification.insideDisplayArea(1919, 1079));
    }

    @Test
    void insideDisplayAreaFHD3() {
        Specification.setDefinition(1);
        assertFalse(Specification.insideDisplayArea(1920, 540));
    }

    @Test
    void insideDisplayArea_FHD4() {
        Specification.setDefinition(1);
        assertFalse(Specification.insideDisplayArea(960, 1080));
    }

    //testing valid messages
    @Test
    void messageValid1() {
        assertTrue(Specification.messageIsValid("AB", false));
    }

    @Test
    void messageValid2() {
        assertTrue(Specification.messageIsValid("A1B2", false));
    }

    @Test
    void messageValid3() {
        assertTrue(Specification.messageIsValid("A B", false));
    }

    @Test
    void messageValid4() {
        assertTrue(Specification.messageIsValid("A-B", false));
    }

    @Test
    void messageValid5() {
        // 7 chars allowed if hyphen present
        assertTrue(Specification.messageIsValid("AB-CD12", false));
    }

    @Test
    void messageValid6() {
        // 6 chars allowed for motorcycle
        assertTrue(Specification.messageIsValid("AB-CD1", true));
    }

    //testing invalid messages
    @Test
    void messageInvalid1() {
        assertFalse(Specification.messageIsValid("A", false));
    }

    @Test
    void messageInvalid2() {
        assertFalse(Specification.messageIsValid("ABCDEFG", false));
    }

    @Test
    void messageInvalid3() {
        assertFalse(Specification.messageIsValid("-AB", false));
    }

    @Test
    void messageInvalid4() {
        assertFalse(Specification.messageIsValid("AB ", false));
    }

    @Test
    void messageInvalid5() {
        assertFalse(Specification.messageIsValid("A--B", false));
    }

    @Test
    void messageInvalid6() {
        assertFalse(Specification.messageIsValid("1234", false));
    }

    @Test
    void messageInvalid7() {
        // 7 chars with hyphen NOT allowed for motorcycle
        assertFalse(Specification.messageIsValid("AB-CD12", true));
    }
}