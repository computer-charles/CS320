import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testValidTaskCreation() {
        Task task = new Task("1", "Homework", "Complete the project");
        assertEquals("1", task.getTaskId());
        assertEquals("Homework", task.getName());
        assertEquals("Complete the project", task.getDescription());
    }

    @Test
    public void testTaskIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Homework", "Complete the project");
        });
    }

    @Test
    public void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Homework", "Complete the project");
        });
    }

    @Test
    public void testNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", null, "Complete the project");
        });
    }

    @Test
    public void testNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "ThisTaskNameIsWayTooLong", "Complete the project");
        });
    }

    @Test
    public void testDescriptionNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "Homework", null);
        });
    }

    @Test
    public void testDescriptionTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("1", "Homework",
                    "This description is definitely going to be longer than fifty characters total.");
        });
    }

    @Test
    public void testUpdateName() {
        Task task = new Task("1", "Homework", "Complete the project");
        task.setName("Study");
        assertEquals("Study", task.getName());
    }

    @Test
    public void testUpdateDescription() {
        Task task = new Task("1", "Homework", "Complete the project");
        task.setDescription("Read chapter 5");
        assertEquals("Read chapter 5", task.getDescription());
    }

    @Test
    public void testUpdateNameInvalid() {
        Task task = new Task("1", "Homework", "Complete the project");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    public void testUpdateDescriptionInvalid() {
        Task task = new Task("1", "Homework", "Complete the project");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("This description is definitely going to be longer than fifty characters total.");
        });
    }
}