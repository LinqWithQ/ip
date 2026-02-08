package qlin;

import org.junit.jupiter.api.Test;
import java.io.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class ResponderTest {

    @Test
    public void test0() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("input0.txt");
        System.setIn(input);
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputBuffer));
        Qlin.main(new String[0]);
        List<String> actualLines = List.of(outputBuffer.toString().split("\\r?\\n"));
        InputStream expectedStream = getClass().getClassLoader().getResourceAsStream("expect0.txt");
        assert expectedStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(expectedStream));
        List<String> expectedLines = reader.lines().toList();
        assertLinesMatch(expectedLines, actualLines);
    }

    @Test
    public void test1() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("input1.txt");
        System.setIn(input);
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputBuffer));
        Qlin.main(new String[0]);
        List<String> actualLines = List.of(outputBuffer.toString().split("\\r?\\n"));
        InputStream expectedStream = getClass().getClassLoader().getResourceAsStream("expect1.txt");
        assert expectedStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(expectedStream));
        List<String> expectedLines = reader.lines().toList();
        assertLinesMatch(expectedLines, actualLines);
    }

    @Test
    public void test2() {
        InputStream input = getClass().getClassLoader().getResourceAsStream("input2.txt");
        System.setIn(input);
        ByteArrayOutputStream outputBuffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputBuffer));
        Qlin.main(new String[0]);
        List<String> actualLines = List.of(outputBuffer.toString().split("\\r?\\n"));
        InputStream expectedStream = getClass().getClassLoader().getResourceAsStream("expect2.txt");
        assert expectedStream != null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(expectedStream));
        List<String> expectedLines = reader.lines().toList();
        assertLinesMatch(expectedLines, actualLines);
    }
}
