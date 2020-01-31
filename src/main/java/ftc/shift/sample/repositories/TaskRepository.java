package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Task;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Интерфейс для получения данных по заданиям
 */

public interface TaskRepository {

    Task fetchTask(String ownerId, Integer taskStatus);

    ArrayList<Task> fetchTaskStatusAndId(Integer taskStatus, String performerId);

    void updateTask(Task task);

    void createTask(Task task);


}
