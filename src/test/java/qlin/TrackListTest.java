package qlin;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TrackListTest {
    @Test
    public void testAddAndGetTask() {
        TrackList list = new TrackList();
        Todo todo = new Todo("test task");

        list.addTask(todo);

        assertEquals(1, list.getSize(), "TrackList size should be 1 after adding a task");
        assertEquals(todo, list.getTask(0), "Retrieved task does not match the added task");
    }

    @Test
    public void testDeleteTask() {
        TrackList list = new TrackList();
        list.addTask(new Todo("task 1"));
        list.addTask(new Todo("task 2"));

        list.deleteTask(0); // Delete the first task

        assertEquals(1, list.getSize(), "TrackList size should decrease after deletion");
        assertEquals("task 2", list.getTask(0).getName(), "Wrong task was deleted");
    }
}
