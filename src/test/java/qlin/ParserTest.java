package qlin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {

    @Test
    public void test0() {
        String[] result = Parser.breakString("");
        assertEquals(0, result.length);
    }

    @Test
    public void test1() {
        String[] expected = new String[] {"n", "m", "o"};
        String[] result = Parser.breakString("n /m /o");
        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(result[i], expected[i]);
        }
    }

    @Test
    public void test2() {
        String[] expected = new String[] {"n", "m", "o"};
        String[] result = Parser.breakString("n /  m    //   /   /o");
        assertEquals(expected.length, result.length);
        for (int i = 0; i < expected.length; i++) {
            assertEquals(result[i], expected[i]);
        }
    }
}
