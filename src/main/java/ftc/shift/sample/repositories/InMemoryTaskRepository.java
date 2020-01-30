package ftc.shift.sample.repositories;

import ftc.shift.sample.VariableClass;
import ftc.shift.sample.exception.NotFoundException;
import ftc.shift.sample.models.Task;
import ftc.shift.sample.models.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@ConditionalOnProperty(name = "use.database", havingValue = "false")
public class InMemoryTaskRepository implements TaskRepository {

    private Task[] userCache = new Task[100];

    public InMemoryTaskRepository() {
        String tempTaskId, tempOwnerId, tempPerformerId, tempTaskName,
                tempTaskDescription, tempCreationDate, tempCompletionDate, tempTaskPicture;

        for (int i = 0; i < 100; i++) {
            tempTaskId = String.valueOf(i);
            tempOwnerId = String.valueOf(i);
            tempPerformerId = String.valueOf(i);
            tempTaskName = "name" + i;
            tempTaskDescription = "taskDescription" + i;
            tempCreationDate = "01-01-" + i;
            tempCompletionDate = "01-01-" + i;
            tempTaskPicture = "taskPicture" + i;

            userCache[i] = new Task(tempTaskId, tempOwnerId, tempPerformerId, tempTaskName, 1,
                    tempTaskDescription, i, tempCreationDate, tempCompletionDate, tempTaskPicture);
        }
    }

    @Override
    public Task fetchTask(String id) {
        boolean isFound = false;
        Task answer = new Task();

        for (int i = 0; i < 100; i++) {
            if (userCache[i].getTaskId().equals(id)) {
                answer = userCache[i];
                isFound = true;
                break;
            }
        }

        if (isFound) {
            return answer;
        } else {
            throw new NotFoundException();
        }
    }
/*
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

 */
}

