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

    public Task provideTask(String ownerId, Integer taskStatus) {
        return taskRepository.fetchTask(ownerId, taskStatus);
    }

    public Task provideTaskStatusAndId(Integer taskStatus, String performerId) {
        return taskRepository.fetchTaskStatusAndId(taskStatus, performerId);
    }
/*
    public Task updateTask(String userId, String taskId, Task task) {
        return taskRepository.updateTask(userId, taskId, task);
    }

    public Task createTask(String userId, Task task) {
        return taskRepository.createTask(userId, task);
    }

 */
}
