package ftc.shift.sample.services;

import ftc.shift.sample.models.Task;
import ftc.shift.sample.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task provideTask(String userId, String taskId) {
        return taskRepository.fetchTask(userId, taskId);
    }

    public Task updateTask(String userId, String taskId, Task task) {
        return taskRepository.updateTask(userId, taskId, task);
    }

    public void deleteTask(String userId, String taskId) {
        taskRepository.deleteTask(userId, taskId);
    }

    public Task createTask(String userId, Task task) {
        return taskRepository.createTask(userId, task);
    }

    public Collection<Task> provideTasks(String userId) {
        return taskRepository.getAllTasks(userId);
    }
}
