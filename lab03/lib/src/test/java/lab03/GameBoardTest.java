package lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    // Good weather tests
    @Test
    void isInside_ValidPoint_1_1() {
        assertTrue(GameBoard.isInside(1, 1));
    }

    @Test
    void isInside_ValidPoint_3_4() {
        assertTrue(GameBoard.isInside(3, 4));
    }

    @Test
    void isInside_ValidPoint_5_5() {
        assertTrue(GameBoard.isInside(5, 5));
    }

    // Bad weather tests
    @Test
    void isInside_XBelowLowerBound_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> GameBoard.isInside(-1, 2));
    }

    @Test
    void isInside_XAboveUpperBound_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> GameBoard.isInside(6, 3));
    }

    @Test
    void isInside_YBelowLowerBound_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> GameBoard.isInside(2, -1));
    }

    @Test
    void isInside_YAboveUpperBound_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> GameBoard.isInside(4, 6));
    }

    //ON points
    @Test
    void isInside_LowerLeftCorner_ReturnsTrue() {
        assertTrue(GameBoard.isInside(0, 0));
    }

    @Test
    void isInside_UpperRightCorner_ReturnsTrue() {
        assertTrue(GameBoard.isInside(5, 5));
    }
}
