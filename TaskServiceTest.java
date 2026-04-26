import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    @Test
    public void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Homework", "Complete the project");
        service.addTask(task);
        assertEquals(task, service.getTask("1"));
    }

    @Test
    public void testAddDuplicateTaskId() {
        TaskService service = new TaskService();
        Task task1 = new Task("1", "Homework", "Complete the project");
        Task task2 = new Task("1", "Study", "Read chapter 5");

        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    @Test
    public void testAddNullTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(null);
        });
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Homework", "Complete the project");
        service.addTask(task);
        service.deleteTask("1");
        assertThrows(IllegalArgumentException.class, () -> {
            service.getTask("1");
        });
    }

    @Test
    public void testDeleteNonexistentTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("99");
        });
    }

    @Test
    public void testUpdateName() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Homework", "Complete the project");
        service.addTask(task);
        service.updateName("1", "Study");
        assertEquals("Study", service.getTask("1").getName());
    }

    @Test
    public void testUpdateDescription() {
        TaskService service = new TaskService();
        Task task = new Task("1", "Homework", "Complete the project");
        service.addTask(task);
        service.updateDescription("1", "Read chapter 5");
        assertEquals("Read chapter 5", service.getTask("1").getDescription());
    }

    @Test
    public void testUpdateNonexistentTask() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateName("99", "Study");
        });
    }
}