package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Task;

import java.util.Collection;

public interface TaskRepository {
    Task fetchTask(String userId, String taskId);

    Task updateTask(String userId, String bookId, Task task);

    void deleteTask(String userId, String taskId);

    Task createTask(String userId, Task task);

    Collection<Task> getAllTasks(String userId);
}
