package lab03;
import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {
    private static Map<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Empty input");
        }

        int total = 0;
        int prev = 0;
        int repeatCount = 0;
        char prevChar = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                throw new IllegalArgumentException("Invalid character");
            }

            int value = map.get(c);

            // repetition rules
            if (c == prevChar) {
                repeatCount++;
                if (c == 'V' || c == 'L' || c == 'D' || repeatCount > 2) {
                    throw new IllegalArgumentException("Invalid repetition");
                }
            } else {
                repeatCount = 0;
            }

            // subtractive rules
            if (value < prev) {
                if (!(c == 'I' && (prevChar == 'V' || prevChar == 'X')) &&
                        !(c == 'X' && (prevChar == 'L' || prevChar == 'C')) &&
                        !(c == 'C' && (prevChar == 'D' || prevChar == 'M'))) {
                    throw new IllegalArgumentException("Invalid subtractive pair");
                }
                total -= value;
            } else {
                total += value;
                prev = value;
                prevChar = c;
            }

            prevChar = c;
        }

        return total;
    }

}