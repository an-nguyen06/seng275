package lab03;

public class GameBoard {

    private static final int SIZE = 6;

    public static boolean isInside(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            throw new IllegalArgumentException("Player outside board");
        }
        return true;
    }
}
