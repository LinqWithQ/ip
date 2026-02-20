package qlin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TodoTest {

    @Test
    public void testToString() {
        Todo todo = new Todo("read book");
        assertEquals("[T][ ] read book", todo.toString(), "Unmarked Todo string format is incorrect");

        todo.setDone();
        assertEquals("[T][X] read book", todo.toString(), "Marked Todo string format is incorrect");
    }

    @Test
    public void testToStoreFormat() {
        Todo todo = new Todo("read book");
        assertEquals("todo /read book /0", todo.toStoreFormat(), "Store format for unmarked Todo is incorrect");

        todo.setDone();
        assertEquals("todo /read book /1", todo.toStoreFormat(), "Store format for marked Todo is incorrect");
    }
}
