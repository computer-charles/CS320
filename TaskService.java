import java.util.HashMap;
import java.util.Map;

public class TaskService {
    private final Map<String, Task> tasks = new HashMap<>();

    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID must be unique");
        }
        tasks.put(task.getTaskId(), task);
    }

    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task not found");
        }
        tasks.remove(taskId);
    }

    public void updateName(String taskId, String name) {
        Task task = getTask(taskId);
        task.setName(name);
    }

    public void updateDescription(String taskId, String description) {
        Task task = getTask(taskId);
        task.setDescription(description);
    }

    public Task getTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task not found");
        }
        return tasks.get(taskId);
    }
}