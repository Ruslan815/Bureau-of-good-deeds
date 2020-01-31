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

    public void updateTask(Task task) {
        taskRepository.updateTask(task);
    }

    public void createTask(Task task) {
        taskRepository.createTask(task);
    }


}
