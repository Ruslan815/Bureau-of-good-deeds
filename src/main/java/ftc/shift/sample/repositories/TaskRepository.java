package ftc.shift.sample.repositories;

import ftc.shift.sample.models.Task;

import java.util.Collection;

/**
 * Интерфейс для получения данных по заданиям
 */

public interface TaskRepository {

    Task fetchTask(String userId);
/*
    Task updateTask(String userId, String bookId, Task task);

    Task createTask(String userId, Task task);

 */
}
