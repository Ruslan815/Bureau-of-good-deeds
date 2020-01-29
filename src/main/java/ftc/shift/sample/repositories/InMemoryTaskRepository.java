package ftc.shift.sample.repositories;

import ftc.shift.sample.VariableClass;
import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.Task;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Реализиция, хранящая все данные в памяти приложения
 */
@Repository
@ConditionalOnProperty(name = "use.database", havingValue = "false")
public class InMemoryTaskRepository implements TaskRepository {
    /**
     * Ключ - имя пользователя, значение - все книги, которые есть у пользователя
     */
    private Map<String, Map<String, Task>> taskCache = new HashMap<>();

    public InMemoryTaskRepository() {
        // Заполним репозиторий тестовыми данными
        // В тестовых данных существует всего 3 пользователя: UserJ / UserK / UserZ

        taskCache.put("UserJ", new HashMap<>()); // создаём в БД место для записи
        taskCache.get("UserJ").put("1", new Task("taskId", "ownerId", "performerId", "taskName",
                777, "taskDescription", 1337, "creationDate",
                "completionDate", "taskPicture")); // записываем данные в запись в БД

        taskCache.put("UserK", new HashMap<>());
        taskCache.get("UserK").put("2", new Task("taskId", "ownerId", "performerId", "taskName",
                777, "taskDescription", 1337, "creationDate",
                "completionDate", "taskPicture"));

        taskCache.put("UserZ", new HashMap<>());
        taskCache.get("UserZ").put("3", new Task("taskId", "ownerId", "performerId", "taskName",
                777, "taskDescription", 1337, "creationDate",
                "completionDate", "taskPicture"));
    }

    @Override
    public Task fetchTask(String userId, String taskId) {
        if (!taskCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> userTasks = taskCache.get(userId);

        if (!userTasks.containsKey(taskId)) {
            // У пользователя не найдена книга
            throw new NotFoundException();
        }

        return userTasks.get(taskId);
    }

    @Override
    public Task updateTask(String userId, String taskId, Task task) {
        if (!taskCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> userTasks = taskCache.get(userId);

        if (!userTasks.containsKey(taskId)) {
            // У пользователя не найдена книга
            throw new NotFoundException();
        }

        task.setTaskId(taskId);
        userTasks.put(taskId, task);
        return task;
    }

    @Override
    public void deleteTask(String userId, String taskId) {
        if (!taskCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> taskBooks = taskCache.get(userId);

        if (!taskBooks.containsKey(taskId)) {
            // У пользователя не найдена книга
            throw new NotFoundException();
        }

        taskCache.remove(taskId);
    }

    @Override
    public Task createTask(String userId, Task task) {
        if (!taskCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        Map<String, Task> userTasks = taskCache.get(userId);

        // способ генерирования случайных идентификаторов, использовать только для примеров
        task.setTaskId(VariableClass.getAvailableId());
        userTasks.put(task.setTaskId(), task);
        return task;
    }

    @Override
    public Collection<Task> getAllTasks(String userId) {
        if (!taskCache.containsKey(userId)) {
            // Пользователь не найден
            throw new NotFoundException();
        }

        return taskCache.get(userId).values();
    }
}

