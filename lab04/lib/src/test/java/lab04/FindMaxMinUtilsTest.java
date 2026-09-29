package lab04;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

public class FindMaxMinUtilsTest {
    @Test
    void testEmptyList() {
        List<Float> list = new ArrayList<>();

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        FindMaxMinUtils.findMaxMin(list);

        assertTrue(out.toString().contains("No scores found"));
    }
    @Test
    void testSingleElement() {
        List<Float> list = Arrays.asList(5.0f);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        FindMaxMinUtils.findMaxMin(list);

        String output = out.toString();

        assertTrue(output.contains("1 total scores"));
        assertTrue(output.contains("5.0"));
    }

    @Test
    void testMultipleElements() {
        List<Float> list = Arrays.asList(3.0f, 7.0f, 1.0f);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        FindMaxMinUtils.findMaxMin(list);

        String output = out.toString();

        assertTrue(output.contains("3 total scores"));
        assertTrue(output.contains("7.0")); // max
        assertTrue(output.contains("1.0")); // min
    }
    @Test
    void testNoUpdateMaxMin() {
        List<Float> list = Arrays.asList(5.0f, 5.0f, 5.0f);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        FindMaxMinUtils.findMaxMin(list);

        String output = out.toString();

        assertTrue(output.contains("3 total scores"));
        assertTrue(output.contains("5.0"));
    }
}
